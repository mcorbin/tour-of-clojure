(ns tourofclojure.pages.fn-firstclass
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/fn_firstclass.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Fonctions first class"]
          [:p "En Clojure, vous pouvez stocker des fonctions dans des variables,"
           " des structures de données, les passer en paramètre de fonctions,"
           " créer des fonctions retournant des fonctions... Bref, les fonctions"
           " sont des variables comme les autres."]
          [:p "Ces exemples simples montrent quelques façons de manipuler des"
           " fonctions. Des techniques plus puissantes seront présentées dans la"
           " suite de ce tutoriel."]
          [:h3 "Fonctions dans une structure de données"]
          [:pre [:code "(def a-map {:foo (fn [a] (+ a 5))
            :bar *})

((:foo a-map) 10)
((:bar a-map) 9 5)
"]]
          [:p "Dans cet exemple, " [:b "a-map"] " contient une map avec deux clés, "
           " chacune contenant une fonction. Je peux ensuite récupérer la valeur"
           " associée à ces clés, et l'utiliser comme une fonction en lui passant"
           " des paramètres."]
          [:h3 "Fonction retournant une fonction"]
          [:p "Les fonctions retournant des fonctions sont extrêmement courantes"
           " en Clojure. Voici un exemple:"]
          [:pre [:code "(defn add-n
  [n]
  (fn [m]
    (+ n m)))

(def add-5 (add-n 5))
(add-5 30)
"]]
          [:p "Ici, la fonction " [:b "add-n"] " prend un paramètre " [:b "n"] " et "
           " retourne une autre fonction prenant également un paramètre " [:b "m"]
           " qui réalisera la somme de " [:b "n"] " et de " [:b "m"] "."]
          [:p "Par exemple, si " [:b "add-n"] " est appelé avec 5 comme paramètre,"
           " la fonction retournée ajoutera 5 à son paramètre variable."]
          [:h3 "Passer une fonction en paramètre d'une fonction"]
          [:p "Les fonctions peuvent être passées en paramètre d'autres fonctions:"]
          [:pre [:code "(defn call-f
  [f arg1 arg2]
  (f arg1 arg2))

(call-f * 10 10)"]]
          [:p "Dans cet exemple, la fonction " [:b "call-f"] " prend en paramètre"
           " une fonction et deux autres arguments. " [:b "(call-f * 10 10)"]
           " exécutera donc " [:b "(* 10 10)"] ", ce qui donnera 100."]
          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])

