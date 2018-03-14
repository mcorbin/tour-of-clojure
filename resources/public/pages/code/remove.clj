;; remove all even numbers
(println (remove even? [1 2 3]) "\n")

;; remove maps with a :b key
(println (remove :b [{:a 1} {:b 2} {:b 1}]) "\n")

;; remove all numbers > 10
(println (remove (fn [elem] (> elem 10)) [2 5 11 9 81]) "\n")
