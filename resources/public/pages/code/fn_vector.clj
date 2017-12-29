;; add an element
(println (conj [1 2 3] 4))
(println (conj [1 2 3] 4 5 6) "\n")

;; get the nth element
(println (get [1 2 3] 2) "\n")

;; get the last element
(println (peek [1 2 3]) "\n")

;; remove the last element
(println (pop [1 2 3]) "\n")

;; create a subvec between index [1, 3[
(println (subvec [1 2 3 4] 1 3))

