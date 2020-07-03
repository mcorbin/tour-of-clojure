(ns tourofclojure.views.footer
  (:require [hiccup.element :refer [link-to]]))

(def footer
  [:div {:class "footer,container-fluid"}
   [:center
    [:p [:b "Powered by "
         (link-to {} "https://mcorbin.fr" "mcorbin")]
     [:b " - Available on "
         (link-to {} "https://github.com/mcorbin/tour-of-clojure" "Github")]
     ]]])
