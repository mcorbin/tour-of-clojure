(println
 (->> (range 5)
      (filter even?)
      (map inc)
      (reduce +)))
