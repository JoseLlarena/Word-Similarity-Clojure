(ns
  ^{:doc "Calculation of word similarity metrics."}
  word-similarity.core
  (:require [clojure.core.memoize :as memo]))

(declare min-levenshtein levenshtein)

(defn- levenshtein [a b]
  (cond
   (empty? a) (count b)
   (empty? b) (count a)
   (= (last a) (last b)) (min-levenshtein a b 0)
   :else (min-levenshtein a b 1)))


(defn- min-levenshtein [a b cost]
  (min (+ (levenshtein (butlast a) b) 1)
       (+ (levenshtein a (butlast b)) 1)
       (+ (levenshtein (butlast a) (butlast b)) cost)))

(defn normal-levenshtein* [a b]
 (- 1 ( double ( /  (levenshtein a b) (max (count a) (count b))))))


(def normal-levenshtein
  "similarity as normalised levenshtein distance between two strings"
  (memo/lu normal-levenshtein* :lu/threshold 50000))
