(ns url-shortener.events
  (:require
   [re-frame.core :refer [reg-event-db reg-event-fx inject-cofx]]
   [url-shortener.db :as db]
   [nano-id.core :refer [nano-id]]
   [akiroz.re-frame.storage :refer [persist-db]]
   ))

(defn local-storage-reg-event-db
  [event-id handler]
  (reg-event-fx
    event-id
    [(persist-db :my-app :urls)]
    (fn [{:keys [db]} event-vec]
      {:db (handler db event-vec)})))

(local-storage-reg-event-db
  ::initialize-db
  (fn [db _]
    {:urls (get-in db [:urls])}))

(local-storage-reg-event-db
  ::add-url
  (fn [db [_ url short]]
    (assoc-in db [:urls url] short)))
