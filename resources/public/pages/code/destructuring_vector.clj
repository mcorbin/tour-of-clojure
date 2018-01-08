;; destructure a list/vector/sequence
(let [[s1 s2] ["first-string" "second-string"]]
  (println s1 s2 "\n"))

;; destructure the 2 first values and the rest
(let [[n1 n2 & nrest] [1 2 3 4 5]]
  (println n1 n2 nrest "\n"))

;; destructure nested arrays. p4 will be nil because the array size = 3
(let [[p1 [p2 p3] p4] [100 [200 300]]]
  (println p1 p2 p3 p4 "\n"))

;; use :as to get the full value
(let [[c1 c2 c3 :as full-string] "Hello world!"]
  (println "c :" c1 c2 c3 full-string "\n"))
