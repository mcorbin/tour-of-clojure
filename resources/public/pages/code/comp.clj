(def get-bar-foo (comp :foo :bar))

(println (get-bar-foo {:bar {:foo 1}}))

(def count-and-add-one (comp (partial + 1) count))

(println (count-and-add-one [10 10 10]))

(def f1 (comp (partial + 1) (partial * 2) (partial / 10)))

(println (f1 100))
