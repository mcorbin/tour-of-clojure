;; define an atom
(def my-atom (atom []))

;; redef the atom to get its value
(println @my-atom "\n")

;; update the atom value
(swap! my-atom conj 10)

(println @my-atom "\n")

;; You can pass a function to swap!
(swap! my-atom (fn [old-state]
                 (conj old-state 20)))

(println @my-atom "\n")

;; swap returns the new value of the atom
(println (swap! my-atom conj 30) "\n")

;; reset! set the atom value to something
(println (reset! my-atom [100]))
