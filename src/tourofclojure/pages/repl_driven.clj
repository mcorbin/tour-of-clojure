(ns tourofclojure.pages.repl-driven
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/repl_driven.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Repl Driven Development"]
          [:p "TODO"]
          ]

    [:h2 "Language not supported."])
  )

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
