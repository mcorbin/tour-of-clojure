(ns tourofclojure.pages.variable
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/variable.clj"))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Définir une variable"]
          [:p]
          [:p "Une variable globale se définit avec le mot clé " [:b "def"] "."]
          [:pre [:code "(def foo 1)"]]
          [:p "Le code précédent assigne à " [:b "foo"] " la valeur " [:b "1"]
           ". Cette variable peut ensuit être utilisée."]
          [:p "Toutes les variables Clojure (list, set, vector, map...) sont "
           [:b "immuables"] ". Cela est une des grande force de Clojure."]
          [:p "Lorsque vous modifiez une variable (par exemple un vector avec"
           " la fonction " [:b "conj"] "), vous pouvez considérer que vous "
           "obtenez une nouvelle version de cette variable. L'ancienne version"
           " de la variable sur lequel vous avez appelé la fonction n'a pas"
           " changée."]
          [:pre [:code "(def bar [1 2 3])
(conj bar 4)
(println bar)"]]
          [:p "Dans cet exemple, on définit une variable " [:b "bar"] " contenant"
           " la valeur " [:b "[1 2 3]"] ". On ajoute ensuite un élément à cette"
           " variable via " [:b "conj"] ". Le résultat retourné par cette fonction"
           " sera " [:b "[1 2 3 4]"] "."]
          [:p "Si vous utilisez maintenant " [:b "println"] " pour afficher la "
           "valeur de la variable " [:b "bar"] ", vous verrez que sa valeur n'a"
           " pas changée et est toujours " [:b "[1 2 3]"] "."]
          [:p "En Clojure, vous n'aurez donc (presque) jamais à vous inquiéter des"
           " effets de bord, ou de savoir quelle partie de votre programme"
           " possède une référence à une variable, car ces dernieres sont"
           " toujours immuables."]
          (navigation-block previous next)]
    [:h2 "language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])

