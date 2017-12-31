(ns tourofclojure.pages.fn-map-first
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/fn_map_first.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Opérations sur les Map: partie 1"]
          [:p "Voici quelques opérations sur les Map."]
          [:p "On voit ici tout l'intérêt des " [:b "keywords"] " présentés précédemment."]
          [:p "Une Map peut avoir des clés de tout type, et il est possible"
           " de récupérer la valeur d'une clé via la fonction " [:b "get"] "."]
          [:p "Si la clé est un keyword, il n'est pas nécessaire d'appeler "
           [:b "get"] ", on peut directement utiliser le keyword pour récupérer"
           " la valeur associée."]
          [:p "La fonction " [:b "update"] " est intéressante, elle prend comme"
           " paramètre une map, une clé, et une fonction à un argument. Cette"
           " fonction sera appelée avec comme paramètre la valeur associée à la"
           " clé, et le résultat sera associé dans la map à la clé. C'est pour cela"
           " que dans cet exemple " [:b ":foo"] " est équal à 2."]
          [:p "Nous reparlerons de cela dans un chapitre consacré aux manipulations"
           " de fonctions."]
          (navigation-block page-number)]

    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])
