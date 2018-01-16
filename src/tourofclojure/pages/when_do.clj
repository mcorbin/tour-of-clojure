(ns tourofclojure.pages.when-do
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))



(def code
  (slurp "resources/public/pages/code/when_do.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "do et when"]
          [:h3 "do"]
          [:p "Nous avons vu précédemment la syntaxe de " [:b "if"] ". "
           "Mais comment faire si nous voulons exécuter plusieurs actions dans "
           " la partie exécutée si la condition est vraie ou fausse ?"]
          [:p "Le mot clé " [:b "do"] " permet cela de façon générale. "
           [:b "do"] " prend une série d'expressions, et va les exécuter une à une"
           " de façon séquentielle, et retournera le résultat de la dernière."]
          [:h3 "when"]
          [:p "On a vu précédemment qu'un " [:b "if"] " peut ne pas prendre"
           " d'expressions si la condition est fausse. Pour montrer clairement"
           " qu'une expression n'est exécutée que si une condition est vraie"
           " et retourner " [:b "nil"] " si la condition est fausse, il est"
           " préférable d'utiliser " [:b "when"] ", qui est similaire à " [:b "if"]
           " mais qui ne prend que 2 expressions (la condition est l'expression à"
           " exécuter si la condition est vraie), et qui retournera " [:b "nil"]
           " si la condition est fausse."
           ]
          (navigation-block page-number)]
    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])

