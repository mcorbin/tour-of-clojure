(ns tourofclojure.pages.fn-nb
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/fn_nb.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Opérations sur les nombres"]
          [:p "Voici quelques opérations sur des nombres."]
          [:p "Un certains nombre de ces fonctions acceptent un nombre indéfini de"
           " paramètres. C'est le cas par exemple de la fonction " [:b "+"] "."]
          [:pre [:code "(+ 1 2 3 4 5)"]]
          [:p "Des spécificités peuvent exister selon la plateforme sur lequel"
           " vous faites"
           " tourner Clojure (JVM, ClojureScript), car Clojure s'appuie sur les"
           " types de la plateforme hôte."]
          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
