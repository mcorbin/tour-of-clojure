(ns tourofclojure.pages.while
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/while.clj"))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "while"]
          [:p [:b "while"] " permet de répéter une action (généralement un effet de "
           " bord) tant qu'une condition est vraie."]
          [:p ""]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])

