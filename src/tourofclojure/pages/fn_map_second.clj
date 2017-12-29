(ns tourofclojure.pages.fn-map-second
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/fn_map_second.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Opérations sur les Map : partie 2"]
          [:p "Il existe un grand nombre de fonctions simplifiant la manipulation"
           " complexe de Map en Clojure."]
          [:p "En voici quelques unes permettant notamment"
           " de manipuler des maps imbriquées de façon simple."]

          (navigation-block page-number)]

    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])
