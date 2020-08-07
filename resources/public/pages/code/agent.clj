;; creates an agent with the state of 0
(def my-agent (agent 0))

;; dereferencing the agent gives the current value
(println "Agent state is:" @my-agent)

;; sends an action to an agent
(send-off my-agent
  (fn [s]
    (Thread/sleep 2000) ; Doing some work like writing to a file
    (inc s)))

;; agent never blocks and the current value can be read
(println "Agent state is:" @my-agent)

;; waiting the agent to proceed
(Thread/sleep 3000)

(println "Agent state is:" @my-agent)
