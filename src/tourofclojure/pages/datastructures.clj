(ns tourofclojure.pages.datastructures
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/datastructures.clj"))

(defn desc
  [page-number]
  [:div
   [:h2 "Structures de données"]
   [:p]
   (navigation-block page-number)
   ])

(defn page
  [page-number]
  [(desc page-number)
   code])
