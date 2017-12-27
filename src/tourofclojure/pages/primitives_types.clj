(ns tourofclojure.pages.primitives-types
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/primitives-types.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Types primitifs"]
          [:p]
          [:p "Clojure utilise les types primitifs de sa plateforme hôte."]
          [:p "Les nombres en Clojure sur la JVM sont dérivés de "
           [:b java.lang.Number]
           ", alors qu'en ClojureScript seuls les primitives JavaScript"
           "  (integer et float) sont supportés."]
          [:p "Sur la JVM (et n'existant pas en ClojureScript), le type " [:b "ratio"]
           " permet de conserver la précision lors de divisons."]
          [:p "Le type " [:b "keyword"] " est un type spécial dont la valeur s'identifie elle même. Nous reparlerons des keywords dans la suite de ce tutoriel."]
          (navigation-block page-number)]
    [:h2 "language not supported."]
    ))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])
