(ns tourofclojure.pages.cond
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/cond.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "cond"]
          [:p [:b "cond"] " associe une condition à une valeur. Chaque condition"
           " sera évaluée séquentiellement, et si la condition est vraie, cond"
           " retournera la valeur associée."]
          [:p "Rappelez vous, en Clojure, à part " [:b "nil"] " et " [:b " false"]
           ", tout vaut vrai. Vous pouvez donc facilement définir une clause par"
           " défaut, toujours évaluée à vrai, via un keyword par exemple."]
          [:p "Si aucune clause n'est vraie, cond retourne "  [:b "nil"]]
          (navigation-block page-number)]

    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])

