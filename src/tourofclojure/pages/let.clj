(ns tourofclojure.pages.let
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/let.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Let et variables locales"]
          [:p "Nous avons vu précédemment " [:b "def"] " pour définir des variables"
           " globales. Il est également possible de définir des variables localement"
           " (dans une fonction par exemple) en utilisant " [:b "let"] "."]
          [:p "Les variables se déclarent entre " [:b "[]"] ", et sont des paires"
           " nom/valeur. Plus précisément, la syntaxe de " [:b "let"]
           " peut être décrite comme "
           [:b "[name1 value1 name2 value2 ...]"] "."]
          [:p "Il est possible d'utiliser le symbole " [:b "_"] " à la place"
           " du nom. Dans ce cas, la form suivante sera exécutée mais son résultat"
           " ne sera assigné à aucune variable. Dans l'exemple de la fonction "
           [:b "bar"] ", on voit que " [:b "println"] " est appelé."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
