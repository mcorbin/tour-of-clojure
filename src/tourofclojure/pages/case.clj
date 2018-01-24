(ns tourofclojure.pages.case
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/case.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "case"]
          [:p [:b "case"] " prend en paramètre une valeur, puis une suite de"
           " clause associant une valeur " [:b "vn"] " à un résultat " [:b "rn"]
           ". Si le premier paramètre de " [:b "case"] " est égal à"
           " une des valeurs d'une clause, le résultat associé sera retourné."]
          [:p "Contrairement à " [:b "cond"] " et " [:b "condp"] " vu précédemment, "
           [:b "case"] " n'évalue pas chaque clause l'une après l'autre."
           " De plus, les valeurs dans les clauses ne sont pas évaluées et donc"
           " ne peuvent pas être des expressions (cela doit être donc des valeurs"
           " litéralles comme des entiers, des string...)."]
          [:p "Comme " [:b "condp"] ", " [:b "case"] " produira une exception"
           " si aucune clause ne match."]
          (navigation-block page-number)]

    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])

