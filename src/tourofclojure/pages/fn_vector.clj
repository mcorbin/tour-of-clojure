(ns tourofclojure.pages.fn-vector
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/fn_vector.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Opérations sur les Vector"]
          [:p "Voici quelques opérations sur les Vector."]
          [:p "Les Vector sont une structure de donnée très utilisée en Clojure."]
          [:p "Un grand nombre de fonctions peuvent manipuler et retourner des"
           " Vector, en voici un certain nombre."]
          [:p "Comme vous pouvez le constater, de nombreuses fonctions manipulant"
           " des structures de données en Clojure peuvent prendre un nombre"
           " variable d'arguments. C'est par exemple le cas de " [:b "conj"]
           " pour les vector."]
          [:p "N'hésitez pas à consulter la documentation des fonctions pour voir"
           " lesquelles peuvent prendre un nombre variable de paramètres."]
          (navigation-block page-number)]

    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])
