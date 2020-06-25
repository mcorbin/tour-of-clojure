(defmacro infix [coll]
  (list (second coll) (first coll (last coll))))

(println (infix (2 + 3)) "\n")

(println (macroexpand '(infix (2 + 3))))
