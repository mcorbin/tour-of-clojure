;; simple doseq
(doseq [value [0 1 2 3 4]]
  (println value))

(println "\n")

;; you can use multiple bindings
(doseq [v1 [0 1]
        v2 [10 9]]
  (println v1 ":" v2))

(println "\n")

;; using :when and :let
(doseq [v1 [0 1 2]
        v2 [10 9 8]
        :let [result (* v1 v2)]
        :when (> result 17)]
  (println result))
