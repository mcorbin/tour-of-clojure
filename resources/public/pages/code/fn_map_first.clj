;; add value(s)
(println (assoc {:foo "foo"} :bar "bar"))
(println (assoc {:foo "foo"} :bar "bar" :baz "baz") "\n")

;; remove value(s)
(println (dissoc {:foo "foo" :bar "bar"} :foo))
(println (dissoc {:foo "foo" :bar "bar"} :foo :bar) "\n")

;; get value
(println (get {:foo "foo"} :foo))
;; if the key is a keyword, you can use the keyword as a function to get the value
(println (:foo {:foo "foo"}))
;; the key does not exists, returns nil
(println (:bar {:foo "foo"}))
;; provide a default value if the key does not exists (work with get too)
(println (:bar {:foo "foo"} "default value!") "\n")

;; update value
(println (update {:foo 1} :foo inc) "\n")

;; test if the map contains the key
(println (contains? {:foo 1} :foo))

