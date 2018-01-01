;; a map containing functions
(def a-map {:foo (fn [a] (+ a 5))
            :bar *})

;; get and call the functions with parameters
(println ((:foo a-map) 10))
(println ((:bar a-map) 9 5) "\n")

;; a function returning a function
(defn add-n
  [n]
  (fn [m]
    (+ n m)))

;; add-five will contains (fn [m] (+ 5 m))
(def add-5 (add-n 5))
(println (add-5 30) "\n")

;; takes a function and 2 parameters, call (f arg1 arg2)
(defn call-f
  [f arg1 arg2]
  (f arg1 arg2))

(defn multiply
  "multiply 2 numbers"
  [n m]
  (* n m))

(println (call-f multiply 10 5))
