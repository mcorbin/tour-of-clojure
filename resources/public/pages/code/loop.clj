(loop [counter 5
       result []]
  (if (= counter 0)
    (println result "\n")
    (recur (dec counter)
           (conj result counter))))

(loop [my-vector (range 10)
       result 0]
  (if my-vector
    (recur (next my-vector)
           (+ result (first my-vector)))
    (println result "\n")))
