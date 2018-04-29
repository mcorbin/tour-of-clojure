(ns tourofclojure.pages.agent
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]
            [clojure.java.io :as io]))

(def code
  (slurp (io/resource "public/pages/code/agent.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "agent"]
          [:p "TODO"]
          ]

    [:h2 "Language not supported."])
  )

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
