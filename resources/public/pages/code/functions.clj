(defn add-five
  "Add 5 to the number `n`"
  [n]
  (+ 5 n))

(println (add-five 5))
(println (add-five 10.5) "\n")

(def multiply
  "multiply the 2 parameters"
  (fn [n m]
    (+ n m)                                 ;; do nothing
    (str "Hello " "world" "!")              ;; do nothing
    (println "Side effects")                ;; i/o
    (* m n)))                               ;;returned value

(println (multiply 2 4) "\n")

;; you can define functions using #(...)
(def add-three #(+ % 3))
(println (add-three 10) "\n")

(def add #(+ %1 %2))
(println (add 10 5))
