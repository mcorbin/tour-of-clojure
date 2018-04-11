(ns tourofclojure.pages.fn-map-second
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/fn_map_second.clj"))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Opérations sur les Map: partie 2"]
          [:p "Il existe un grand nombre de fonctions simplifiant la manipulation"
           " complexe de Map en Clojure."]
          [:p "En voici quelques unes permettant notamment"
           " de manipuler des maps imbriquées de façon simple."]

          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
