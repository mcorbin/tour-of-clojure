(defproject mcorbin/tourofclojure "0.8.0"
  :description "An interactive Clojure tutorial"
  :url "https://github.com/mcorbin/tour-of-clojure"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/tools.logging "1.0.0"]
                 [cheshire "5.10.0"]
                 [circleci/clj-yaml "0.6.0"]
                 [compojure "1.6.1"]
                 [environ "1.1.0"]
                 [hiccup "1.0.5"]
                 [mount "0.1.16"]
                 [ring/ring-defaults "0.3.2"]
                 [org.clojure/tools.namespace "1.0.0"]
                 [ring/ring-jetty-adapter "1.8.0"]
                 [spootnik/unilog "0.7.25"]]
  :ring {:handler tourofclojure.handlers/app}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main tourofclojure.core
  :source-paths ["src"]
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [pjstadig/humane-test-output "0.10.0"]
                                  [ring/ring-mock "0.4.0"]]
                   :plugins [[lein-ring "0.12.5"]
                             [lein-environ "1.1.0"]
                             [lein-ancient "0.6.15"]]
                   :env {:config-path "dev/resources/config.yml"}
                   :injections [(require 'pjstadig.humane-test-output)
                                (pjstadig.humane-test-output/activate!)]
                   :repl-options {:init-ns user}
                   :source-paths ["dev/src" "test/tourofclojure"]}})
