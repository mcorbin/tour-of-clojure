(ns tourofclojure.pages.condp
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/condp.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "condp"]
          [:p "Une autre construction intéressante est " [:b "condp"] "."]
          [:p "Le premier paramètre de " [:b "condp"] " est une fonction que l'on appellera " [:b "f"] "."
           " Le second paramètre un valeur que l'on appellera " [:b "v"] ". "
           [:b "condp"] " prend ensuite une série de clauses où une valeur "
           [:b "c"] " est associée à un résultat " [:b "r"] "."
           ]
          [:p "Pour chaque clause de façon séquentielle, " [:b "condp"] " appellera"
           [:b "(f c v)"] " et retournera " [:b "r"] " si le résultat est vrai."]
          [:p "Ici aussi, il est possible de donner une valeur par défaut si aucune"
           " clause ne match. Cela se fait en indiquant simplement en dernier paramètre"
           " la valeur par défaut."]
          [:p [:b "Attention"] ", contrairement à " [:b "cond"] " vu précédemment, "
           [:b "condp"] " retournera une exception si aucune clause ne match et "
           "qu'aucune valeur par défaut n'est fournie."]
          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])

