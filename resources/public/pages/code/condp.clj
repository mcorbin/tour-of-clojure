;; with a matching close
(println (condp = 1
           2 "1 == 2 ?!"
           1 "1 == 1 !"))

;; Another example with an anonymous function.
(println (condp #(= (:foo %1) %2) 10
           {:foo 1} ":foo == 1 ?!"
           {:foo 10} ":foo == 10 !"))

;; without matching clause, default valueo
(println (condp = 1
           2 "1 == 2 ?!"
           3 "3 == 1 !"
           "default value"))
