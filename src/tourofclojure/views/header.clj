(ns tourofclojure.views.header
  (:require [hiccup.element :refer [image]]))

(def header
  [:div {:id "header"
         :class "container-fluid"}
   (image {} "/images/clojure-logo.png" "Clojure logo")
   [:h1 "A tour of Clojure"]])
