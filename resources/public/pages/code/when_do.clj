;; you can use do for i/o for example
(println
 (if (= 1 1)
   (do
     (println "hello from do!")
     (println "1 + 1 =" 2)
     "returned value"))
 "\n")

;; the 2 first expressions are useless
(println
 (do
   "this will do nothing"
   (+ 10 10) ;; do nothing
   (+ 30 30))  ;; returned value
 "\n")

;; condition is true
(println
 (when (= 1 1)
   (println "you can have multiple expressions in when !")
   "1 == 1 !")
 "\n")

;; condition is false, return nil
(println
 (when (= 1 2)
   "1 == 2 !?"))
