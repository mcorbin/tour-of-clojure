;; create a fn which add elements to 1
(def add-one (partial + 1))

;; will do (+ 1 2)
(println (add-one 2))

;; will do (+ 1 2 3 4)
(println (add-one 2 3 4) "\n")

;; create a fn which returns the :foo key in a map
(def get-foo (partial :foo))

;; get the :foo key
;; will do (:foo {:foo 1})
(println (get-foo {:foo 1}))

;; default value if the :foo key does not exists
;; will do (:foo {:bar 1} 3)
(println (get-foo {:bar 1} 3))
