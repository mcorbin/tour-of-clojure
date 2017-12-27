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
           "Pourtant, celle-ci est très simple et ne cache aucun piège."]
          [:p "La règle est simple : "]
          [:pre [:code {:class "clojure"} "(operation param1 param2 ...)"]]
          [:p "Et c'est à peu près tout. On ouvre une parenthèse, on a un nom"
           " de fonctions ou autre, et une suite de paramètre. On imbrique ensuite"
           " les forms pour construire un programme."]
          [:p "Par exemple, " [:b "str"] " prend un nombre indéfini de"
           " paramètres et va retourner la concaténation de ces paramètres."
          " Dans un autre langage, on écrirait quelque chose comme:"]
          [:pre [:code {:class "java"} "str(\"Hello\", \" world\", \" !!!\")"]]
          [:p "En clojure, on déplace juste la première parenthèse pour englober"
           " le nom de fonction."]
          [:p "De la même façon, " [:b "println"] " prend également un nombre"
           " indéfini de paramètres et retourne " [:b "nil"] "."]
          (navigation-block page-number)]
    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])
