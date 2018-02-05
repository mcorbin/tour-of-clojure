(defproject tourofclojure "0.0.1-SNAPSHOT"
  :description "An interactive Clojure tutorial"
  :url "https://github.com/mcorbin/tour-of-clojure&"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/tools.logging "0.4.0"]
                 [cheshire "5.8.0"]
                 [circleci/clj-yaml "0.5.6"]
                 [compojure "1.6.0"]
                 [environ "1.1.0"]
                 [hiccup "1.0.5"]
                 [mount "0.1.11"]
                 [ring/ring-defaults "0.3.1"]
                 [org.clojure/tools.namespace "0.2.11"]
                 [ring/ring-jetty-adapter "1.6.2"]
                 [spootnik/unilog "0.7.22"]]
  :ring {:handler tourofclojure.handlers/app}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :uberjar-name "tourofclojure.jar"
  :main tourofclojure.core
  :source-paths ["src"]
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [pjstadig/humane-test-output "0.8.2"]
                                  [ring/ring-mock "0.3.2"]]
                   :plugins [[lein-ring "0.12.2"]
                             [lein-environ "1.1.0"]]
                   :env {:config-path "dev/resources/config.yml"}
                   :injections [(require 'pjstadig.humane-test-output)
                                (pjstadig.humane-test-output/activate!)]
                   :repl-options {:init-ns user}
                   :source-paths ["dev/src" "test/tourofclojure"]}})
