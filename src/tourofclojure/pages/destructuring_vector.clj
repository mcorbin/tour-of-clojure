(ns tourofclojure.pages.destructuring-vector
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/destructuring_vector.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Destructuring - Vector"]
          [:p "Il arrive souvent que vous ayez besoin de récupérer des valeurs"
           " présentes dans des structures de données. Parfois, ces structures de"
           " données sont même imbriquées les unes dans les autres."
           "De plus, si la valeur"
           " n'existe pas (comme par exemple si une clé est absente d'une map),"
           " vous voulez peut être obtenir une valeur par défaut."]
          [:p "Comme nous l'avons vu précédemment, la librairie standard de"
           " Clojure fournit un grand nombre de fonctions pour réaliser cela. Une"
           " autre technique est le destructuring, qui est présenté ici sur des"
           " vectors."]
          [:p "Le destructuring permet de facilement assigner à des variables des"
           " valeurs présentes dans une structure de données."]
          [:p "Prenons par exemple le code suivant:"]
          [:p [:pre [:code {:class "clojure"}
                     "(let [string-vec [\"first-string\" \"second-string\"]
      s1 (first string-vec)
      s2 (second string-vec)]
  (println s1 s2 \"\\n\"))"]]]
          [:p "Voici le code équivalent en destructuring:"]
          [:p [:pre [:code {:class "clojure"}
                     "(let [[s1 s2] [\"first-string\" \"second-string\"]]
  (println s1 s2 \"\\n\"))"]]]
          [:p "On remarque qu'en wrappant s1 et s2 dans un vector, et en lui"
           " assignant comme valeur le vector contenant les deux string, Clojure"
           " assignera automatiquement à s1 et s2 les deux premiers éléments du"
           " vectors."]
          [:p "De la même façon, il est possible d'assigner une partie des éléments"
           " d'un vector à des variables, et tout le reste du vector dans une autre"
           " variable. Par exemple, la syntaxe " [:b "[n1 n2 & nrest]"] " assignera"
           " à n1 et n2 les deux premiers éléments du vector, et nrest sera un"
           " vector contenant le reste des éléments."]
          [:p "Il est également possible d'assigner dans des variables des valeurs"
           " présentes dans des structures de données imbriquées. C'est ce qui est"
           " réalisé dans l'exemple numéro 3."]
          [:p "Le destructuring marche sur des vectors, mais plus généralement sur"
           " tout ce qui est indexé (list, set, string)."]
          [:p "Enfin, le mot clé " [:b ":as"] " permet d'assigner à une variable"
           " la valeur complète étant déstructurée. Par exemple, dans"]
          [:p [:pre [:code {:class "clojure"} "(let [[c1 c2 c3 :as full-string] \"Hello world!\"])"]]]
          [:p "c1 vaudra " [:b "H"] ", c2 " [:b "e"] ", c3 " [:b "l"] ", et "
           "full string la chaîne complète " [:b "Hello world!"] "."]
          [:p "Dans la suite de ce tutoriel, je présenterais le destructuring sur"
           " les maps. Vous pouvez également consulter le "
           (link-to {} "https://clojure.org/guides/destructuring" "guide de Clojure")
           " pour un tutoriel plus complet sur le destructuring."]
          (navigation-block previous next)
          ]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
