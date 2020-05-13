; Creates two channels
(def one-chan (chan))
(def two-chan (chan))

; Produces 1 every second
(go-loop []
    (<! (timeout 1000))
    (>! one-chan 1)
    (recur))

; Produces 2 every two seconds
(go-loop []
    (<! (timeout 2000))
    (>! two-chan 2)
    (recur))

; Consumes both channels as soon as possible
(go-loop []
    (let [[v c] (alts! [one-chan two-chan])]
      (prn v)
      (recur)))
