(ns tourofclojure.pages.fn-nb
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/fn_nb.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Opérations sur les nombres"]
          [:p "Voici quelques opérations sur des nombres."]
          [:p "Un certains nombre de ces fonctions acceptent un nombre indéfini de"
           " paramètres."]
          [:p "Des spécificités peuvent exister selon la plateforme sur lequel"
           " vous faites"
           " tourner Clojure (JVM, ClojureScript), car Clojure s'appuie sur les"
           " types de la plateforme hôte."]
          (navigation-block page-number)]
    
    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])
