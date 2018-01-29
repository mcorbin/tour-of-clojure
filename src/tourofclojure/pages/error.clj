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
          [:p "De la même façon que sa plateforme hôte, la gestion des erreurs"
           " en Clojure se base sur des exceptions."]
          [:p "Une exception peut être capturée via un block " [:b "try-catch"]
           " terminé eventuellement d'un block " [:b "finally"] "."]
          [:p "Une opération illégale où le mot clé " [:b "throw"] " lèvera"
           " une exception."
           ]
          (navigation-block page-number)]

    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])

