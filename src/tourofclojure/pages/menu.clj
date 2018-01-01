(ns tourofclojure.pages.menu
  (:require [hiccup.element :refer [link-to]]))

(defn menu
  [lang]
  (condp = lang
    "fr" [:div {:class "container-fluid"
                :id "page"}
          [:div {:class "row"}
           [:div {:class "col-sm"}
            [:h3 (link-to {} "/" "Introduction")]
            [:h3 "Types, forms, structures de données et fonctions"]
            [:ul
             [:li (link-to {} "/pages/1" "Types primitifs")]
             [:li (link-to {} "/pages/2" "Forms et l'appel de fonctions")]
             [:li (link-to {} "/pages/3" "Opérations sur les nombres")]
             [:li (link-to {} "/pages/4" "Structures de données")]
             [:li (link-to {} "/pages/5" "Opérations sur les Vector")]
             [:li (link-to {} "/pages/6" "Opérations sur les Map: partie 1")]
             [:li (link-to {} "/pages/7" "Opérations sur les Map: partie 2")]
             [:li (link-to {} "/pages/8" "Opérations sur les Set")]
             [:li (link-to {} "/pages/9" "Opérations sur les List")]
             [:li (link-to {} "/pages/10" "L'abstraction séquence")]
             [:li (link-to {} "/pages/11" "Evaluation lazy")]]
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
             ]]]]
    [:h2 "Language not supported"]))
