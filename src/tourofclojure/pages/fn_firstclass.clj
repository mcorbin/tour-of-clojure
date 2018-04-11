(ns tourofclojure.pages.fn-firstclass
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/fn_firstclass.clj"))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Fonctions first class"]
          [:p "En Clojure, vous pouvez stocker des fonctions dans des variables,"
           " des structures de données, les passer en paramètre de fonctions,"
           " créer des fonctions retournant des fonctions... Bref, les fonctions"
           " sont des variables comme les autres."]
          [:p "Ces exemples simples montrent quelques façons de manipuler des"
           " fonctions. Des techniques plus puissantes seront présentées dans la"
           " suite de ce tutoriel."]
          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])

