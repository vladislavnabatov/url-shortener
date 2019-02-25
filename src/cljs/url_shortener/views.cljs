(ns url-shortener.views
  (:require
   [re-frame.core :refer [dispatch subscribe]]
   [url-shortener.subs :as subs]
   [url-shortener.events :as events]
   [nano-id.core :refer [nano-id]]
   ))


(defn url-form []
  (let [urls @(subscribe [::subs/urls])]
    [:form {:on-submit (fn [e]
                         (let [value (-> js/document (.getElementById "input") (.-value))]
                           (.preventDefault e)
                           (if (not (get urls value))
                             (dispatch [::events/add-url value (str "http://bit.ly/ " (nano-id 6)) ]))))}
     [:input {:id :input
              :type :url
              :required true
              :auto-focus true}]
     [:button {:type :submit} "Shorten"]]
    ))

(defn main-panel []
  (let [urls @(subscribe [::subs/urls])]
    [:div
     [url-form]
     [:div (map (fn [[url short]]
                  [:div
                   [:a {:href url} (str short "(" url ")")]])
                urls)]
     ]))
