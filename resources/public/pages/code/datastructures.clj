;; vector
(println [1 2 3 4])

(println (vector 1 [2 2.2] "foo" "bar" true (+ 2 2 2)))

(println)
;; map
(println {"key1" "value1" "key2" "value2"})
;; you can use keywords for keys
(println {:key1 "value1" :key2 "value2"})

(println (hash-map :key1 "value1" :key2 [1 2 3]))

(println)
;; set
(println #{1 2 3 4})

(println (hash-set 1 2 3 4 4))

(println)
;; list
(println '(1 2 3 4))

(println (list 1 2 "foo" "bar"))
