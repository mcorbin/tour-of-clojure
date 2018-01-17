;; matching clause
(println (cond
           (= 1 2) "1 == 2 ?!"
           (= 1 1) "1 == 1"))

;; default value
(println (cond
           (= 1 2) "1 == 2 ?!"
           (= 1 3) "1 == 3 ?!"
           :default "A default value"))

;; no matching clause, return nil
(println (cond
           (= 1 2) "1 == 2 ?!"
           (= 1 3) "1 == 3 ?!"))
