(ns tourofclojure.pages.filter
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/filter.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "filter"]
          (navigation-block page-number)]
    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])

