;; simple for
(println
 (for [value [0 1 2 3 4]]
   (* value 10))
 "\n")

;; multiple binding
(println
 (for [v1 [1 2 3 4]
       v2 [1 10 100]]
   (* v1 v2))
 "\n")

; using :let and :when helper
(println
 (for [v1 [1 2 3 4]
       v2 [1 10 100]
       :let [result (* v1 v2)]
       :when (> result 100)]
   result)
 "\n")
