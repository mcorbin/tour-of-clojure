(ns tourofclojure.views.header
  (:require [hiccup.element :refer [image]]
            [hiccup.element :refer [link-to]]))

(def header
  [:div {:id "header"
         :class "container-fluid"}
   [:span {:id "header-wrapper" :class "row header"}
    [:span {:id "clojure-logo"}
       (image {} "/images/clojure-logo.png" "Clojure logo")]
    [:span {:id "clojure-title"}
       (link-to {} "/"
         [:h1 "A Tour of Clojure"])]
    [:span {:id "menu"}
     (link-to {:id "menu-button"
               :class "btn btn-primary"
               :role "button"} "/menu" "Menu")]]])
