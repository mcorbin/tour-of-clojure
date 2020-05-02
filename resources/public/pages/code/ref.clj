;; ref with the value of 1000
(def account1 (ref 1000))
;; ref with the value of 0
(def account2 (ref 0))

;; in a transaction (STM), transfer 100 from account1 to account2
;; if one of the two alters fails (because one of the ref was modified by another transaction),
;; retry the transaction
(dosync
  (alter account1 #(- % 100))
  (alter account2 #(+ % 100)))

(println @account1)
(println @account2 "\n")

;; in a transaction (STM), set both of the account with an amount of 0
;; if one of the two ref-set fails, retry the transaction
(dosync
  (ref-set account1 0)
  (ref-set account2 0))

(println @account1)
(println @account2 "\n")

;; commute can be used if the order of the operations in the transaction does not matter
;; (cannot always be used)
(dosync
  (commute account1 #(- % 100))
  (commute account2 #(+ % 100)))

(println @account1)
(println @account2 "\n")
