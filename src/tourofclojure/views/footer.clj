(ns tourofclojure.views.footer
  (:require [hiccup.element :refer [link-to]]))

(def footer
  [:div {:class "footer,container-fluid"}
   [:center
    [:p [:b "powered by "
         (link-to {} "https://mcorbin.fr" "mcorbin")]]]])
