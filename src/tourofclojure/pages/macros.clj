(ns tourofclojure.pages.macros
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/macros.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Macros"]
          [:p "TODO"]
          ]

    [:h2 "Language not supported."])
  )

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
