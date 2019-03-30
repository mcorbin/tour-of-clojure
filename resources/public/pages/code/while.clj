(def state (atom [1 2 3 4 5]))

(while (not-empty @state)
  (println (last @state))
  (swap! state pop))
