(ns tourofclojure.pages.if-let
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/if_let.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "if-let et when-let"]
          [:p "Il arrive souvent en Clojure de vouloir vérifier si une valeur"
           " est par exemple non égale à " [:b "nil"] ", et que si c'est le cas"
           " utiliser cette valeur pour la suite du programme."]
          [:p "Par exemple, nous pourrions écrire le code suivant pour vérifier si"
           " une clé est présente dans une map, et si oui imprimer sa valeur:"]
          [:pre [:code "(def my-map {:foo \"bar\"})

(if (:foo my-map)
  (println (:foo my-map))
  (println \"the key does not exists\"))
"]]
          [:p "Rappelez vous qu'en Clojure, une map retourne " [:b "nil"] " si"
           " on demande une valeur associée à une clé n'existant pas, et " [:b "nil"]
           " vaut faux dans un " [:b "if"] "."]
          [:p "Le code précédent fonctionne, mais peut être raccourci grâce à "
           [:b "if-let"] ":"]
          [:pre [:code "
(def my-map {:foo \"bar\"})

(if-let [value (:foo my-map)]
  (println value)
  (println \"the key does not exists\"))
"]]
          [:p [:b "if-let"] " commence comme " [:b "let"] " avec une déclaration"
           " de variable, mais un if est également réalisé: si la variable est"
           " évaluée comme fausse, on exécute la première form, sinon la"
           " seconde."]
          [:p [:b "when-let"] " est exactement la même chose que " [:b "if-let"]
           " pour " [:b "when"] "."]
          (navigation-block previous next)
          ]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
