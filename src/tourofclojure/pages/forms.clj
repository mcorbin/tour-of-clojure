(ns tourofclojure.pages.forms
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/forms.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Forms et l'appel de fonctions"]
          [:p "La syntaxe de Clojure peut sembler déroutante aux premiers abords."
           " Pourtant, celle-ci est très simple et ne cache aucun piège."]
          [:p "La règle est simple. Clojure est composé de forms."
           " Voici un exemple de form:"]
          [:pre [:code {:class "clojure"} "(operation param1 param2 ...)"]]
          [:p "Et c'est à peu près tout. On ouvre une parenthèse, on a une"
           " opération, et une suite de paramètres. On imbrique ensuite"
           " les forms pour construire un programme."]
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
           " appels de " [:b "println"] " dans mes exemples, dans le but de formater l'affichage."
           ]
          [:p "Evidemment, si l'élement juste après la parenthèse d'une form"
           " n'est pas une fonction, une erreur se produira, comme dans:"]
          [:pre [:code {:class "java"} "(1 2 3)"]]
          [:p "Cette form produira une erreur, car " [:b "1"] " n'est pas une"
           " fonction."]
          (navigation-block page-number)]
    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])
