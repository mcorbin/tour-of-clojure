(ns tourofclojure.pages.functions
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/functions.clj")))
(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Définir une fonction"]
          [:h3 "defn"]
          [:p "Une fonction peut se définir de plusieurs façons."]
          [:p "La façon la plus classique est d'utiliser " [:b "defn"] "."
           " Il est possible (ainsi que sur " [:b "def"] " d'ailleurs) d'ajouter"
           " une " [:b "docstring"] ", c'est à dire une description de la fonction."
           [:br]
           "Les arguments de la fonction sont représentés par un vector."]
          [:pre [:code "(defn add-five
  \"Add 5 to the number `n`\"
  [n]
  (+ 5 n))

(add-five 5)
"]]
          [:p "La fonction précédente est nommée add-five, prend un paramètre "
           " nommé n, et ajoute à ce paramètre 5 et retourne le résultat."
           "Par exemple, " [:b "(add-five 5) " ] "donnera " [:b "10"] "."]
          [:p "Il n'y a pas de mot clé " [:b "return"] " en Clojure. La valeur"
           "  retournée sera la dernière "
           (link-to {} "/pages/forms" "form")
           " de la fonction."]
          [:h3 "def et fn"]
          [:pre [:code "(def multiply)
  \"multiply the 2 parameters\"
  (fn [n m]
    (+ n m)                                 ;; do nothing
    (str \"Hello \" \"world\" \"!\")              ;; do nothing
    (println \"Side effects\")                ;; i/o
    (* m n))                               ;;returned value
"]]
          [:p "La fonction " [:b "multiply"] " est elle définie en utilisant les"
           " mots clés " [:b "def"] " (que nous avons vu précédemment) et "
           [:b "fn"] "."
           " Cette syntaxe est équivalente à " [:b "defn"] ". On assigne avec "
           [:b "def"] " à la variable " [:b "multiply"] " une fonction définie"
           " avec " [:b "fn"] "."]
          [:p "On remarque également dans cette fonction que c'est bien la"
           " dernière form qui est retournée par la fonction."]
          [:h3 "#(...)"]
          [:p "Il est aussi possible de définir des fonctions avec la syntaxe "
           [:b "#(...)"] ". Le " [:b "%"] " sera le paramètre de la fonction, et"
           " si la fonction possède plusieurs paramètres, on utilise "
           [:b "%1, %2, %3..." " pour les représenter."]]
          [:pre [:code "(def add #(+ %1 %2))
(add 10 5)"]]
          [:p "Ce code définit une fonction nommée " [:b "add"] ", prenant deux"
           " paramètres et les additionnant."]
          (navigation-block previous next)]
    [:h2 "language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
