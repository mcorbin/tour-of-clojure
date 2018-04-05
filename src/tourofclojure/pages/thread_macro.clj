(ns tourofclojure.pages.thread-macro
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/thread_macro.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Threading macros"]
          [:p "En clojure, on se retrouve facilement à imbriquer les expresions."
           "A force, Cela peut nuire à la lisibilité. Prenons l'exemple suivant:"]
          [:pre [:code "(reduce + (map inc (filter even? (range 10))))"]]
          [:p "On voit 4 expressions imbriquées dans ce code. Voyons comment"
           " rendre cela plus lisible."]
          [:h3 "->>"]
          [:p "Le code précédent est équivalent au code suivant:"]
          [:pre [:code "(->> (range 5)
     (filter even?)
     (map inc)
     (reduce +))"]]
          [:p "Le symbole " [:b "->>"] ", aussi appelé thread-last, est une"
           " macro qui agira sur ses paramètres comme suit:"]
          [:ul
           [:li "le résultat de " [:b "(range 5)"] " est calculé, ce qui"
            " donne " [:b "(0 1 2 3 4)"] "."
            ]
           [:li "Ce résultat est placé à la fin de l'expression suivante, qui"
            " vaudra maintenant donc " [:b "(filter even? '(0 1 2 3 4))"] "."
            "Le résultat de cette expression est calculé, et vaut " [:b "(0 2 4)"]
            "."]
           [:li "De la même manière, le résultat précédent est placé à la fin de "
            "l'expression suivante, qui vaudra " [:b "(map inc '(0 2 4))"]
            " et donnera comme résultat " [:b "(1 3 5)"]]
           [:li "Encore une fois, le résultat est passé à l'expression suivante"
            " qui vaudra " [:b "(reduce + '(1 3 5))"] ". Le résultat final sera"
            " 9."]
           ]
          ]

    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])




