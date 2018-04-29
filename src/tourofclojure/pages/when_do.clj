(ns tourofclojure.pages.when-do
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/when_do.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "do et when"]
          [:h3 "do"]
          [:p "Nous avons vu précédemment la syntaxe de " [:b "if"] ". "
           "Mais comment faire si nous voulons exécuter plusieurs actions dans "
           " la partie exécutée si la condition est vraie ou fausse ?"]
          [:p "Le mot clé " [:b "do"] " permet cela de façon générale. "
           [:b "do"] " prend une série de forms, et va les exécuter une à une"
           " de façon séquentielle, et retournera le résultat de la dernière."]
          [:h3 "when"]
          [:p "On a vu précédemment qu'un " [:b "if"] " peut ne prendre qu'une"
           " form après la condition, et donc ne pas avoir de branche à"
           " exécuter si la condition est fausse. "
           "Pour montrer clairement"
           " qu'une form n'est exécutée que si une condition est vraie"
           " et retourner " [:b "nil"] " si la condition est fausse, il est"
           " préférable d'utiliser " [:b "when"] ", qui est similaire à " [:b "if"]
           " mais qui ne prend que 2 forms (la condition est la form à"
           " exécuter si la condition est vraie), et qui retournera " [:b "nil"]
           " si la condition est fausse."]
          [:p "De plus, vous pouvez enchainer comme dans un " [:b "do"]
           " les forms à l'intérieur d'un " [:b "when"] "."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])

