(ns tourofclojure.pages.menu
  (:require [hiccup.element :refer [link-to]]))

(defn menu
  [lang]
  (condp = lang
    "fr" [:div {:class "container-fluid"
                :id "page"}
          [:h3 "Types, forms, structures de données et fonctions"]
          [:ul
           [:li (link-to {} "/pages/1" "Types primitifs")]
           [:li (link-to {} "/pages/2" "Forms et l'appel de fonctions")]
           [:li (link-to {} "/pages/3" "Fonctions sur les nombres")]
           [:li (link-to {} "/pages/4" "Structures de données")]
           [:li (link-to {} "/pages/5" "Fonctions sur les séquences")]
           [:li (link-to {} "/pages/5" "Evaluation lazy")]
           [:li (link-to {} "/pages/6" "Fonctions sur les vector")]
           [:li (link-to {} "/pages/7" "Fonctions sur les set")]
           [:li (link-to {} "/pages/8" "Fonctions sur les list")]
           [:li (link-to {} "/pages/5" "Fonctions sur les map")]]
          [:h3 "Définir des fonctions et variables"]
          [:ul
           [:li (link-to {} "/pages/6" "Définir une variable")]
           [:li (link-to {} "/pages/6" "Définir une fonction")]
           [:li (link-to {} "/pages/6" "Fonctions first class")]
           [:li (link-to {} "/pages/6" "Variables locales")]]
          [:h3 "Flow control"]
          [:ul
           [:li (link-to {} "/pages/3" "If, when, do")]
           [:li (link-to {} "/pages/3" "loop, while")]
           [:li (link-to {} "/pages/3" "doseq")]
           ]
          [:h3 "Programmation fonctionnelle"]
          [:ul
           [:li (link-to {} "/pages/3" "Fonctions first class")]
           [:li (link-to {} "/pages/3" "Récursion")]
           [:li (link-to {} "/pages/3" "map, reduce, filter")]
           [:li (link-to {} "/pages/3" "Threading macro")]
           [:li (link-to {} "/pages/3" "Composition de fonctions")]
           ]]
    [:h2 "Language not supported"]))
