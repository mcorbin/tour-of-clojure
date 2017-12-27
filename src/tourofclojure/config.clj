(ns tourofclojure.config
  "This namespace load the application configuration."
  (:require [clojure.tools.logging :as log]
            [clj-yaml.core :as yaml]
            [environ.core :refer [env]]
            [mount.core :as m]
            [unilog.config  :refer [start-logging!]]))

(def default-config
  "Default configuration for the application.

  The `:http` key can contains any ring.adapter.jetty option
  (https://ring-clojure.github.io/ring/ring.adapter.jetty.html for the option
  list).

  The `logging` key can contains any unilog option (https://github.com/pyr/unilog
  for the option list)."
  {:http {:host "localhost"
          :port 8080
          :join? true}
   :logging {:level "info"
             :console {:encoder "json"}}})

(defn get-config
  "Read a YAML configuration file. `path` is the file path.
  Returns the configuration contained in the YAML file, merged with the default
  configuration.

  If the `path` variable is nil, returns the default configuration."
  [path]
  (if path
    (->> (slurp path)
         (yaml/parse-string)
         (into {})
         (merge default-config))
    default-config))

(m/defstate configuration
  "Mount component for the configuration.
  Read a YAML configuration file. The configuration file path should be in the
  `CONFIG_PATH` environment variable."
  :start  (let [config (get-config (env :config-path))]
            (start-logging! (:logging config))
            config))

