(ns tourofclojure.pages.for
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/for.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "for"]
          [:p [:b "for"] " est utilisée pour faire de la compréhension de liste."]
          [:p "Il est semblable à " (link-to {} "/pages/doseq" "doseq") " sauf "
           " qu'ici " [:b "for"] " construira une séquence à partir du résultat"
           " de chaque itération."]
          [:pre [:code "(for [value [0 1 2 3 4]]
  (* value 10))"]]
          [:p "Dans cet exemple, on appelle " [:b "for"] " avec un vector"
           " d'entiers. On multiplie ensuite " [:b "value"] " (qui représente "
           "l'élément en cours de traitement) par 10. Le résultat sera"
           " le vector initial avec chaque élément multiplié par 10."]
          [:p "De manière générale, préférez utiliser "
           (link-to {} "/pages/map" "map") " à la place de " [:b "for"]
           " pour ce genre de traitements simples, ou "
           (link-to {} "/pages/filter" "filter") " à la place de " [:b ":when"] "."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
