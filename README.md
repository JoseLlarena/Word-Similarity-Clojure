Word-Similarity-Clojure
=====================

API for the calculation of word similarity based on version with [memoisation and double recursion](https://github.com/Who828/fuzzy_matcher)


Running at command line
=======================

```(normal-levenshtein "abc" "abc")

0.33333333333333326
```

will compute the normalised levenshtein distance between strings 'abc' and 'bca'