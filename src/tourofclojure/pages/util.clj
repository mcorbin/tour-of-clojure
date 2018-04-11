(ns tourofclojure.pages.util
  (:require [hiccup.element :refer [link-to]]))

(defn navigation-block
  [previous next]
   [:center
    [:p
     (if previous
       (link-to {} (str "/pages/" previous) "Précédent")
       "")
     " - "
     (if next
       (link-to {} (str "/pages/" next) "Suivant")
       "")
     " - "]])
