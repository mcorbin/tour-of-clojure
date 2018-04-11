(ns tourofclojure.pages.filter
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/filter.clj"))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "filter"]
          [:p [:b "filter"] ", comme son nom l'indique, permet de filtrer des séquences."]
          [:p "Le premier paramètre de " [:b "filter"] " est une fonction prenant"
           " un paramètre que nous appelerons " [:b "f"] ", le second la séquence"
           " à filtrer."]
          [:p [:b "(f elem)"] " sera appelé pour chaque élément de la séquence."
           " Seul les éléments dont le résultat de cet appel est " [:b "true"]
           " (pour Clojure, donc ni nil ni false) seront conservés. Par exemple:"]
          [:pre [:code "(filter even? [1 2 3])"]]
          [:p "filtrera tous les éléments impairs (" [:b "even?"] " sera appelé"
           " pour chaque élément du vector passé en paramètre)."]
          [:p [:b "filter"] " retourne une séquence lazy."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])

