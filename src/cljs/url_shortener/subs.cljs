(ns url-shortener.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::urls
 (fn [db]
   (:urls db)))
