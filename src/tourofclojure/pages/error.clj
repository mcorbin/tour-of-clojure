(ns tourofclojure.pages.error
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))
(def code
  (slurp "resources/public/pages/code/error.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Gestion des erreurs"]
          [:p "Exception"]
          (navigation-block page-number)]

    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])

