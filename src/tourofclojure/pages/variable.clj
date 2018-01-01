(ns tourofclojure.pages.variable
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/variable.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Définir une variable"]
          [:p]
          [:p "Une variable globale se définit avec le mot clé " [:b "def"] "."]
          [:p "Toutes les variables Clojure (list, set, vector, map...) sont "
           [:b "immuables"] ". Cela est une des grande force de Clojure."]
          [:p "Lorsque vous modifiez une variable (par exemple un vector avec"
           " la fonction " [:b "conj"] "), vous pouvez considérer que vous "
           "obtenez une nouvelle version de cette variable. L'ancienne version"
           " de la variable sur lequel vous avez appelé la fonction n'a pas"
           " changée."]
          [:p "En Clojure, vous n'aurez donc jamais à vous inquiéter des"
           " effets de bords, ou de savoir quelle partie de votre programme"
           " possède une référence à une variable, car ces dernieres sont"
           " toujours immuables."]
          (navigation-block page-number)]
    [:h2 "language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])

