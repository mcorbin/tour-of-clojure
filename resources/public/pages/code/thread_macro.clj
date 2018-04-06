;; thread-last example
(println
 (->> (range 5)
      (filter even?)
      (map inc)
      (reduce +)))

;; thread-first example
(println
 (-> {:foo 1}
     :foo
     (/ 100)))
