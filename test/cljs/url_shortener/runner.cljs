(ns url-shortener.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [url-shortener.core-test]))

(doo-tests 'url-shortener.core-test)
