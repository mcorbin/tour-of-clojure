(ns tourofclojure.pages.namespaces
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/namespaces.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Namespaces"]
          [:p "TODO"]
          ]

    [:h2 "Language not supported."])
  )

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
