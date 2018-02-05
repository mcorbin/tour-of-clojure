(def my-map {:foo "bar"})

(if-let [value (:foo my-map)]
  (println "if-let: the key exists : " value "\n")
  (println "if-let: the key does not exists \n"))

(if-let [value (:bar my-map)]
  (println "if-let: the key exists : " value "\n")
  (println "if-let: the key does not exists \n"))

(when-let [value (:foo my-map)]
  (println "when-let: the key exists : " value)
  (println "when-let: you can have multiple expressions in when-let, like in when \n"))
