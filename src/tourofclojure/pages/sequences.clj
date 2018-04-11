(ns tourofclojure.pages.sequences
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/sequences.clj"))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "L'abstraction séquence"]
          [:p]
          [:p "Un grand nombre de fonctions peuvent prendre en paramètre"
           " tout type de collections (vector, des list, map, set)."
           " Cela fonctionne grâce"
           " à une abstraction nommée séquence."]
          [:p "Toutes les séquences sont des collections."]
          [:p "Cette abstraction définit une façon d'accéder et d'itérer"
           " de façon ordonnée et optimisée sur une structure de donnée."]
          [:p "les collections Clojure peuvent être converties en séquence via la fonction " [:b "seq"] "."]
          [:p "D'ailleurs, si on regarde la description de la fonction " [:b "first"]
           " dans la documentation, on remarque que la fonction utilise " [:b "seq"] ":"]
          [:pre
           [:code
            "Returns the first item in the collection. Calls seq on its argument. If coll is nil, returns nil."]]
          [:p "La chose est vraie aussi pour la fonction " [:b "rest" "."]]
          (navigation-block previous next)]
    [:h2 "language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
