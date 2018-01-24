;; matching clause
(println (case "foo"
           "bar" "foo == bar ?!"
           "foo" "foo == foo !"))

;; no matching clause: an exception is fired
(println (try
           (case "foo"
             "bar" "foo == bar ?!"
             "baz" "foo == foo !")
           (catch :default e
             (str "No matching clause : " e))))
