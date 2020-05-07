; Create an agent with the state of 0
(def my-agent (agent 0))

; Dereference the agent gives the current value
(println "Agent state is:" @my-agent)

; Send an action to an agent
(send-off my-agent
  (fn [s]
    (Thread/sleep 2000) ; Doing some work like writing to a file
    (inc s)))

; Agent never blocks and the current value is readed
(println "Agent state is:" @my-agent)

; Waiting the agent to proceed
(Thread/sleep 3000)

(println "Agent state is:" @my-agent)
