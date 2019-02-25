(ns url-shortener.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [url-shortener.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
