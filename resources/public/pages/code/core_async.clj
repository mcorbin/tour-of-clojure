;; creates two channels
(def one-chan (chan))
(def two-chan (chan))

;; produces 1 every second
(go-loop []
    (<! (timeout 1000))
    (>! one-chan 1)
    (recur))

;; produces 2 every two seconds
(go-loop []
    (<! (timeout 2000))
    (>! two-chan 2)
    (recur))

;; consumes both channels as soon as possible
(go-loop []
    (let [[v c] (alts! [one-chan two-chan])]
      (prn v)
      (recur)))
