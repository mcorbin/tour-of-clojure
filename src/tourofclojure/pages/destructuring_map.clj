(ns tourofclojure.pages.destructuring-map
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/destructuring_map.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Destructuring - Map et defn"]
          [:p "Destructuring map"]
          [:p (link-to {} "https://clojure.org/guides/destructuring" "documentation Clojure")]
          (navigation-block page-number)]
    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])


