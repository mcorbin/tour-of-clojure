(def my-future
  (future
    (Thread/sleep 10000) ;; Doing some work
    4))                  ;; Returns and cache the result


;; Dereferences the future - blocking
(println (deref my-future) "\n")


(def my-promise (promise))
(deliver my-promise 12)

;; Deferences the promise - blocking until a value has been delivered
(println (deref my-promise) "\n")

;; Calls the constructor
(def queue (java.util.concurrent.ArrayBlockingQueue.))

;; Calls a static method
(def executor (java.util.concurrent.Executors/newFixedThreadPool 10))

;; Calls a method on an object
(.submit executor #(println "Hello"))
