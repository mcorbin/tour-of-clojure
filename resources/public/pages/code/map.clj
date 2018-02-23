(println (map inc [1 2 3 4]) "\n")

(println (map #(+ % 10) [1 2 3 4]) "\n")

(map (fn [v] (assoc v :foo "bar")) [{} {:foo "foo"} {:bar "baz"}])
