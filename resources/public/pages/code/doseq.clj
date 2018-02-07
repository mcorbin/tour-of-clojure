;; simple doseq
(doseq [value [0 1 2 3 4]]
  (println value))

(println "\n")

;; you can combine values
(doseq [v1 [0 1 2 3 4]
        v2 [10 9 8 7 6]]
  (println v1 ":" v2))
