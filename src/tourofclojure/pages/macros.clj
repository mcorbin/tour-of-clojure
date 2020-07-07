(ns tourofclojure.pages.macros
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/macros.clj")))

(def code-result
  (slurp (io/resource "public/pages/code/macros-result.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Macros"]
          [:p "Clojure dispose d'un système de macro permettant de créer des abstractions complexes pouvant servir notamment à ajouter des fonctionnalités au langage.
           En réalité, beaucoup d'éléments présentés dans ce tutoriel sont des macros et non pas des fonctions ("[:b "cond"] ", "[:b "condp"]", "[:b "for"]", "[:b "when"]"...) et certaines librairies comme "[:a {:href "/pages/core-async" } "core.async"] " est majoritement écrite avec des macros."]
          [:p "Une macro se définit avec " [:b "defmacro"] ". La différence entre une fonction et une macro est que dans cette dernière les arguments ne sont pas évalués avant d'être transformés par la macro.
          La macro traite les données reçues en argument afin de produire des nouvelles forms."]
          [:p "Imaginons que nous souhaitions réaliser une notation infix sous forme de fonction : " [:code "(infix (2 + 3))"] ". Ce ne serait pas possible car Clojure va d'abord évaluer " [:code "(2 + 3)"] " qui retournera une exception."]
          [:p "Maintenant, sous forme de macro :"]
          [:pre [:code "(defmacro infix [coll]
  (list (second coll) (first coll (last coll))))

(infix (2 + 3))"]]
          [:p
            "La macro reçoit en paramètre une liste contenant " [:code "(2 + 3)"]
            " puis réécrit une form valide" [:code "(+ 2 3)"] "."]
          [:p "Grâce à " [:b "macroexpand"] " on comprend aisément comment une macro est évaluée."]
          [:pre [:code "(macroexpand '(infix (2 + 3)))
(+ 2 3)"]]
          [:p "La philosophie des Lisp \"data as code\" prend avec les macros tout son sens. On prend une structure de données, on la transforme en une autre structure de données qui correspond maintenant à du code à exécuter."]


           (navigation-block previous next)]


    [:h2 "Language not supported."]))


(defn page
  [previous next lang]
  [(desc previous next lang)
   code
   code-result])
