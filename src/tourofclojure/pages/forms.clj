(ns tourofclojure.pages.forms
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/forms.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Forms et l'appel de fonctions"]
          [:p "La syntaxe de Clojure peut sembler déroutante aux premiers abords."
           " Pourtant, celle-ci est très simple et ne cache aucun piège."]
          [:p "La règle est simple. Clojure est composé de forms."
           " Voici un exemple de form:"]
          [:pre [:code {:class "clojure"} "(operation param1 param2 ...)"]]
          [:p "Et c'est à peu près tout. On ouvre une parenthèse, on a une"
           " opération, et une suite de paramètres."]
          [:p "Par exemple, " [:b "str"] " prend un nombre indéfini de"
           " paramètres et va retourner la concaténation de ces paramètres."
          " Dans un autre langage, on écrirait quelque chose comme:"]
          [:pre [:code {:class "java"} "str(\"Hello\", \" world\", \" !!!\")"]]
          [:p "En clojure, on déplace juste la première parenthèse pour englober"
           " le nom de fonction:"]
          [:pre [:code "(str \"Hello\" \" world\" \" !!!\")"]]
          [:p "De la même façon, " [:b "println"] " prend également un nombre"
           " indéfini de paramètres et retourne " [:b "nil"] "."
           " D'ailleurs, j'ajouterais souvent un saut de ligne aux différents"
           " appels de " [:b "println"] " dans mes exemples, dans le but de formater l'affichage. Par exemple, le code suivant imprimera le résultat de"
           [:b "(+ 1 2)"] " suivi d'un saut de ligne:"]
          [:pre [:code "(println (+ 1 2) \"\\n\")"]]
          [:p "Evidemment, si l'élement juste après la parenthèse d'une form"
           " n'est pas une fonction, une erreur se produira, comme dans:"]
          [:pre [:code {:class "java"} "(1 2 3)"]]
          [:p "Cette form produira une erreur, car " [:b "1"] " n'est pas une"
           " fonction."]
          [:p "Le code Clojure consiste en forms imbriquées les unes dans les autres:"]
          [:pre [:code "(+ 2 3 (* 10 10))"]]
          [:p "Ici, la form réalisant la multiplication est imbriquée dans celle de"
           " l'addition. Le résultat sera calculé de la manière suivante :"]
          [:ul
           [:li [:b "(* 10 10)"] " est calculé, ce qui donne 100."]
           [:li "Le résultat est utilisé dans l'addition, ce qui donne "
            [:b "(+ 2 3 100)"] ". Le résultat final est donc 105."]]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
