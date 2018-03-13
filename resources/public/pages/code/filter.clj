;; keep only even numbers
(println (filter even? [1 2 3]) "\n")

;; keep only maps with a :b key
(println (filter :b [{:a 1} {:b 2} {:b 1}]) "\n")


;; keep all numbers > 10
(println (filter (fn [elem] (> elem 10)) [2 5 11 9 81]) "\n")
