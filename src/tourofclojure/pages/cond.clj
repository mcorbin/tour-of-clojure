(ns tourofclojure.pages.cond
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/cond.clj")))

(defn desc
  [previous next lang]
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
          (navigation-block previous next)
          [:h2 "Un exemple"]
          [:pre [:code
                 "(println (cond
           (= 1 2) \"1 == 2 ?!\"
           (= 1 3) \"1 == 3 ?!\"
           :default \"A default value\"))"]]
          [:p "On voit ici que l'on teste plusieurs conditions. Aucune condition"
           " n'est valide, ce sera donc la condition par défaut qui sera "
           "exécutée et cette expression retournera la chaîne "
           [:b "A default value"] "."]
          [:p "En effet, comme vu précédemment, un keyword est considéré"
           " comme " [:b "true"] ". Le résultat serait le même avec ue chaîne,"
           " un nombre ... excepté " [:b "nil"] " et " [:b " false"] "."]
          ]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])

