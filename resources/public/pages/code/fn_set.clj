;; add a value
(println (conj #{1 2 3} 4) "\n")

;; remove a value
(println (disj #{1 2 3 4} 4) "\n")

;; is the value present in the set ?
(println (contains? #{"foo" "bar"} "foo") "\n")

;; set difference
(println (clojure.set/difference #{1 2 3} #{1 2}) "\n")

;; set union
(println (clojure.set/union #{1 2 3} #{1 2 3 4}) "\n")

;; set intersection
(println (clojure.set/intersection #{2 3} #{1 2 3 4}) "\n")

