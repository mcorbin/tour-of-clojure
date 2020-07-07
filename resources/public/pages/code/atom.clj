;; defines an atom
(def my-atom (atom []))

;; redefs the atom to get its value
(println @my-atom "\n")

;; updates the atom value
(swap! my-atom conj 10)

(println @my-atom "\n")

;; a function can be passed to swap!
(swap! my-atom (fn [old-state]
                 (conj old-state 20)))

(println @my-atom "\n")

;; swap! returns the new value of the atom
(println (swap! my-atom conj 30) "\n")

;; reset! sets the atom value to something
(println (reset! my-atom [100]))
