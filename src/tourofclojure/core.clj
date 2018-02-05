(ns tourofclojure.core
  "Application entrypoint."
  (:require [clojure.tools.logging :as log]
            [clojure.tools.namespace.repl :as tn]
            [mount.core :as m]
            [ring.adapter.jetty :refer [run-jetty]]
            [tourofclojure.config :as config]
            [tourofclojure.handlers :as h])
  (:gen-class))

(m/defstate server
  "Mount component for the web server. Use the configuration component.
   Start a jetty web server."
  :start (do (log/info (str "Starting server on "
                            (get-in config/configuration [:http :host]) ":"
                            (get-in config/configuration [:http :port])))
             (run-jetty (h/get-handler)
                        (:http config/configuration)))
  :stop (.stop server))

(defn start
  "Start the application using mount."
  []
  (m/start)
  :ready)

(defn -main [& args]
  (start))

