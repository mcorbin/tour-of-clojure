(defn numbers
  [n]
  (lazy-seq (cons (do (println n "!") n) (numbers (inc n)))))

;; creates a lazy seq
(def s (numbers 10))


