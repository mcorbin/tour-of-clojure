(ns tourofclojure.pages.sequences
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/sequences.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "L'abstraction séquence"]
          [:p]
          [:p "Un grand nombre de fonctions peuvent prendre en paramètre"
           " tout type de collections (vector, des list, map, set)."
           "Cela fonctionne grâce"
           " à une abstraction nommée séquence."]
          [:p "Toutes les séquences sont des collections."]
          [:p "Cette abstraction définit une façon d'accéder et d'itérer"
           " de façon ordonnée et optimisée sur une structure de donnée."]
          [:p "les collections Clojure peuvent être converties en séquence via la fonction "]
          [:b "seq"] "."
          (navigation-block page-number)]
    [:h2 "language not supported."]
    ))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])
