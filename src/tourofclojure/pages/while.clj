(ns tourofclojure.pages.while
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/while.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "while"]
          [:p [:b "while"] " permet de répéter une action (généralement un effet de "
           " bord) tant qu'une condition est vraie."]
          [:p ""]
          (navigation-block page-number)]
    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])
