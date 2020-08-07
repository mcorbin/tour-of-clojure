(def my-future
  (future
    (Thread/sleep 10000) ;; doing some work
    4))                  ;; returns and cache the result


;; dereferences the future - blocking
(println (deref my-future) "\n")


(def my-promise (promise))
(deliver my-promise 12)

;; deferences the promise - blocking until a value has been delivered
(println (deref my-promise) "\n")

;; calls the constructor
(def queue (java.util.concurrent.ArrayBlockingQueue.))

;; calls a static method
(def executor (java.util.concurrent.Executors/newFixedThreadPool 10))

;; calls a method on an object
(.submit executor #(println "Hello"))
