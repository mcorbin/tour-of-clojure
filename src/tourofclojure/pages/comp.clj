(ns tourofclojure.pages.comp
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))


(def code
  (slurp (io/resource "public/pages/code/comp.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "comp"]
          [:p "Comme son nom l'indique, " [:b "comp"] " est utilisé pour faire de"
           " la composition de fonctions. " [:b "comp"] " prend en paramètre une"
           " série de fonctions, et retourne la composition de ces fonctions."
           " Prenons l'exemple suivant:"
           [:pre [:code "(def get-bar-foo (comp :foo :bar))

(println (get-bar-foo {:bar {:foo 1}}))
"]]
           [:p "La fonction " [:b "get-bar-foo"] " est la composition des"
            " fonctions " [:b ":bar"] " et " [:b "foo"] " (rappelez vous, les"
            " keywords se comportent comme des fonctions et sont utiles pour"
            " récupérer des valeurs dans une map)."]
           [:p "Le résultat de l'appel à " [:b "get-bar-foo"] " dans l'exemple"
            " précédent sera " [:b "1"] ". En effet, on applique à la map passée"
            " en paramètre " [:b ":bar"] " puis " [:b ":foo"] ". Cela est donc équivalent à:"]
           [:pre [:code "(:foo (:bar {:bar {:foo 1}}))"]]]
          [:p [:b "partial"] " prend tout son sens lorsque combiné avec " [:b "comp"]
           ". Il devient facile de définir des fonctions avec " [:b "partial"]
           " puis de les combiner avec " [:b "comp"] "."
           ]
          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
