(ns tourofclojure.pages.reduce
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/reduce.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "reduce"]
          
          (navigation-block page-number)]
    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])


