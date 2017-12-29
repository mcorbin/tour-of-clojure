;; add value in nested maps
(println (assoc-in
          {:foo {:bar {:hello "hello"}}}
          [:foo :bar :goodbye] "goodbye") "\n")

;; get a value in nested maps
(println (get-in
          {:foo {:bar {:hello 1}}}
          [:foo :bar :hello]) "\n")

;; update value in nested maps
(println (update-in
          {:foo {:bar {:hello 1}}}
          [:foo :bar :hello]
          inc) "\n")

;; select keys in a map
(println (select-keys {:foo 1 :bar 2 :baz 3} [:foo :baz]) "\n")

;; merge two maps
(println (merge {:foo 1 :bar 2} {:foo 2 :baz 3}))
