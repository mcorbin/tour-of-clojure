(ns tourofclojure.pages.fn-vector
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/fn_vector.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Opérations sur les Vector"]
          [:p "Je présente ici quelques opérations sur les Vector, qui est"
           " une structure de donnée énormément utilisée en Clojure."]
          [:p "Par exemple, la fonction " [:b "conj"] " permet d'ajouter "
           " un élément à un vector:"]
          [:pre [:code "(conj [1 2 3] 4)"]]
          [:p "donnera comme résultat " [:b "[1 2 3 4]"] "."]
          [:p "Comme vous pouvez le constater, de nombreuses fonctions manipulant"
           " des structures de données en Clojure peuvent prendre un nombre"
           " variable d'arguments. C'est par exemple le cas de " [:b "conj"]
           " pour les vector."]
          [:p "N'hésitez pas à consulter la documentation des fonctions pour voir"
           " lesquelles peuvent prendre un nombre variable de paramètres."]
          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
