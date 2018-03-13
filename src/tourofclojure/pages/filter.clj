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
          [:p [:b "filter"] ", comme son nom l'indique, permet de filtrer des séquences."]
          [:p "Le premier paramètre de " [:b "filter"] " est une fonction prenant"
           " un paramètre que nous appelerons " [:b "f"] ", le second la séquence"
           " à filtrer."]
          [:p [:b "(f elem)"] " sera appelé pour chaque élément de la séquence."
           " Seul les éléments dont le résultat de cet appel est " [:b "true"]
           " (pour Clojure, donc ni nil ni false) seront conservés."]
          [:p [:b "filter"] " retourne une séquence lazy."]
          (navigation-block page-number)]
    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])

