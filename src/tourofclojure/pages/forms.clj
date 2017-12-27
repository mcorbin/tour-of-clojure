(ns tourofclojure.pages.forms
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/forms.clj"))

(defn desc
  [page-number]
  [:div
   [:h2 "Forms et l'appel de fonctions"]
   [:p]
   (navigation-block page-number)])

(defn page
  [page-number]
  [(desc page-number)
   code])
