;; sum of the element of a vector
(println (reduce + [1 2 3 4 5]))

;; same thing using an anonymous function
(println (reduce #(+ %1 %2) [1 2 3 4 5]))

;; Use an initial value
(println (reduce + 30 [1 2 3 4 5]))

;; Example of reduced: stop the computation if the accumulator is > 5
(println (reduce (fn [acc elem] (if (> (+ acc elem) 5)
                                  (reduced elem)
                                  (+ acc elem)))
                 [1 2 3 4 5]))

;; another example of reduce : filter non-even elements. In real world, you probably
;; want to use filter instead of reduce for this.
(println (reduce (fn [acc elem] (if (even? elem)
                                    (conj acc elem)
                                    acc))
                 []
                 [1 2 3 4 5]))
