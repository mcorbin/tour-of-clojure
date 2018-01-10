;; simple number comparison
(println (if (= 1 1)
           "(= 1 1) is true \n"
           "(= 1 1) is not true \n"))
;; simple number comparison
(println (if (not (= 1 2))
           (str "1" "!=" "2" "\n")
           "Something is wrong with math \n"))

;; nil is false
(println (if nil
           "nil is true \n"
           "nil is false \n"))

;; false is false
(println (if false
           "false is true \n"
           "false is false \n"))

;; Everything else is true !
(println (if +
           "+ is true \n"
           "+ is false \n"))

;; Everything !
(println (if [1 2 3]
           "[1 2 3] is true \n"
           "[1 2 3] is false \n"))

;; Or returns its first true param, or the last param
(println ((or nil false +) 1000 1000) "\n")

;; and returns its first false param, or the last param
(println ((and "foo" "bar" +) 3000 3000) "\n")
