(ns tourofclojure.pages.datastructures
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/datastructures.clj"))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Structures de données"]
          [:p "La puissance de Clojure réside dans ses structures de données."
           " Nous pésentons ici les principales structures de données utilisées"
           " dans Clojure. Dans la section suivante, nous verrons les opérations"
           " possibles sur ces structures de données."]
          [:p "Je présenterais dans la suite de ce tutoriel les fonctions de base"
           " pour manipuler des structures de données. Mais il en existe de"
           " nombreuses autres, la librairie standard de Clojure étant très riche."]
          [:h4 "Vector"]
          [:p "Les vector sont définis entre " [:b "[]"] " ou via la fonction " [:b "vector"]"."
           " Un vector peut être vu comme un array grandissant sur la droite"
           " (ce qu'on appelle communément une liste dans d'autres langages)."]
          [:p "Clojure étant dynamiquement typé, vous pouvez mixer les types"
           " dans un vector (la chose est d'ailleurs vraie pour les autres structures de"
           " données)."]

          [:h4 "Map"]
          [:p "Les map, définies entre " [:b "{}"] " ou via la fonction "
           [:b "hash-map"]
           ", sont des dictionnaires associant une clé à une valeur."]
          [:p "Les clés et valeurs peuvent être de tout type, mais par convention"
           " on utilise les " [:b "keywords"] " comme clé dans les map."]

          [:h4 "Set"]
          [:p "Les set se définissent entre " [:b "#{}"] " ou via la fonction "
           [:b "hash-set"]
           ", et sont des collections de valeurs uniques."]
          [:p "Il existe aussi des " [:b "des set triés"] ", pouvant être créé"
           " via la la fonction " [:b "sorted-set"] "."]

          [:h4 "List"]
          [:p "Les listes se définissent entre " [:b "'()"] " ou via la fonction "
           [:b "list"] "."
           "Les listes ont des caractéristiques différentes des Vector que nous"
           " découvrirons plus loin."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
