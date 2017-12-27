(ns tourofclojure.pages.menu
  (:require [hiccup.element :refer [link-to]]))

(def menu
  [:div {:class "container-fluid"
         :id "page"}
   [:h3 "Types, forms, structures de données et fonctions"]
   [:ul
    [:li (link-to {} "/pages/1" "Types primitifs")]
    [:li (link-to {} "/pages/2" "Forms")]
    [:li (link-to {} "/pages/3" "Structures de données")]
    [:li (link-to {} "/pages/4" "Fonctions sur les vector")]
    [:li (link-to {} "/pages/5" "Fonctions sur les map")]
    [:li (link-to {} "/pages/6" "Fonctions sur les set")]
    [:li (link-to {} "/pages/6" "Fonctions sur les list")]]
   [:h3 "Définir des fonctions et variables"]
   [:ul
    [:li (link-to {} "/pages/6" "Définir une fonction")]
    [:li (link-to {} "/pages/6" "Définir une variable")]
    [:li (link-to {} "/pages/6" "Variables locales")]]
   [:h3 "Flow control"]
   [:ul
    [:li (link-to {} "/pages/3" "If, when, do")]
    [:li (link-to {} "/pages/3" "let")]
    [:li (link-to {} "/pages/3" "loop, ")]]
   [:h3 "Flow control"]
   ])
