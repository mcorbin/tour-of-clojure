(try
  (throw (js/Error. "My exception"))
  (catch js/Error err
    (println "Caught " err))
  (finally
    (println "Finally block" "\n")))

(try
  (throw "My exception is a string")
  (catch js/Object err
    (println "Caught a string: " err "\n")))

(try
  (throw "My exception is a string")
  (catch :default err
    (println "Caught everything: " err)))
