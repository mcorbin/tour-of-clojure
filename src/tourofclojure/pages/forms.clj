(ns tourofclojure.pages.forms
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/forms.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Forms et l'appel de fonctions"]
          [:p "La syntaxe de Clojure peut sembler déroutante aux premiers abords."
           "Pourtant, celle-ci est très simple et ne cache aucun piège."]
          
          (navigation-block page-number)]
    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])
