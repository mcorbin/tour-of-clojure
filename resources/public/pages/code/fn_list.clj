;; add a value
(println (conj '(1 2 3) 4))

;; return the first value
(println (peek '(1 2 3)))

;; return a new list without the first value
(println (pop '(1 2 3)))

;; get the value at index n
(println (nth '(1 2 3) 2))
