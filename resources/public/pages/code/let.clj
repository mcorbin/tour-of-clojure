(defn foo
  [a]
  (let [b (conj [10 20] 30)
        c (conj b a)]
    ;; returns c
    c))

(println (foo 40) "\n")

(defn bar
  [a]
  (let [b (* 10 100)
        _ (println "b = " b)
        c (+ a b)]
    c))

(println (bar 2))
