(ns tourofclojure.pages.functions
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/functions.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Définir une fonction"]
          [:p]
          [:p "Une fonction peut se définir de plusieurs façons."]
          [:p "La façon la plus classique est d'utiliser " [:b "defn"] "."
           " Il est possible (ainsi que sur " [:b "def"] " d'ailleurs) d'ajouter"
           " une " [:b "docstring"] ", c'est à dire une description de la fonction."
           [:br]
           "Les arguments de la fonction sont représentés par un vector."]
          [:p "Il n'y a pas de mot clé " [:b "return"] " en Clojure. La valeur"
           "  retournée sera la dernière "
           (link-to {} "/pages/2" "form")
           " de la fonction."]
          [:p "La fonction " [:b "multiply"] " est elle définie en utilisant les"
           " mots clés " [:b "def"] " (que nous avons vu précédemment) et "
           [:b "fn"] "."
           " Cette syntaxe est équivalente à " [:b "defn"] ". On assigne avec "
           [:b "def"] " à la variable " [:b "multiply"] " une fonction définie"
           " avec " [:b "fn"] "."]
          [:p "On remarque également dans cette fonction que c'est bien la"
           " dernière form qui est retournée par la fonction."]
          [:p "Il est aussi possible de définir des fonctions avec la syntaxe "
           [:b "#(...)"] ". Le " [:b "%"] " sera le paramètre de la fonction, et"
           " si la fonction possède plusieurs paramètres, on utilise "
           [:b "%1, %2, %3..." " pour les représenter."]]
          (navigation-block page-number)]
    [:h2 "language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])

