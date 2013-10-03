(ns word-similarity.core-test
  (:use clojure.test
        word-similarity.core))

(deftest similarity

  (testing "computes normalised levenshtein distance between two identical strings"

           (is (= (normal-levenshtein "abc" "abc") 1.0))
  )

  (testing "computes normalised levenshtein distance between two completely different strings"

           (is (= (normal-levenshtein "abc" "def") 0.0))
  )

)

(run-tests)


