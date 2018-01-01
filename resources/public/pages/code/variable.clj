(def foo 1)
(println foo "\n")

(def bar [1 2 3])
(println bar "\n")

;; variables in clojure are immutable
(println (conj bar 4))
;; bar has not changed
(println bar "\n")
