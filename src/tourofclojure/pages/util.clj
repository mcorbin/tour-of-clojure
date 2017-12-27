(ns tourofclojure.pages.util
  (:require [hiccup.element :refer [link-to]]))

(defn navigation-block
  [page-number]
   [:center
    [:p
     (if (> page-number 1)
       (link-to {} (str "/pages/" (dec page-number)) "Précédent")
       "")
     " - "
     (link-to {} (str "/pages/" (inc page-number)) "Suivant")]])
