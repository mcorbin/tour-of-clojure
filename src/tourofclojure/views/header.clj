(ns tourofclojure.views.header
  (:require [hiccup.element :refer [image]]
            [hiccup.element :refer [link-to]]))

(def header
  [:div {:id "header"
         :class "container-fluid"}
   [:div {:class "row"}
    [:div {:class "col-sm"}
     [:div {:class "float-left"}
      (image {} "/images/clojure-logo.png" "Clojure logo")
      (link-to {} "/"
               [:h1 "A tour of Clojure (Alpha version)"])]]
    [:div {:class "clear"}]
    [:div {:class "col-sm"}
     [:div {:class "float-right"}
      (link-to {:class "btn btn-primary"
                :role "button"} "/menu" "Menu")]]]])
