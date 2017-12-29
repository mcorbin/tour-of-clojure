;; transform to seq
(println (seq [1 2 3]))
(println (seq {:foo 1 :bar 2}))
(println (seq #{1 2 3 4}) "\n")

;; get the first element
(println (first [1 2 3]))
(println (first #{1 2 3}))
(println (first {:foo 1 :bar 2}) "\n")

;; get the rest
(println (rest [1 2 3]))
(println (rest {:foo 1 :bar 2}) "\n")

;; add a value to the head of the collection and return a seq
(println (cons 4 [1 2 3]))
(println (cons 4 '(1 2 3)))
(println (cons [:bar 2] {:foo 1}))
