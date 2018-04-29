(ns tourofclojure.pages.loop
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/loop.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "loop"]
          [:p "La récursivité en Clojure pose le même problème qu'en Java ou"
           " en JavaScript: la stack overflow."]
          [:p [:b "loop"] " permet de réaliser de manière sûre ce genre de"
           " récursion. Tout d'abord, " [:b "loop"] " ressemble à " [:b "let"]
           " car la même syntaxe est utilisée pour définir une ou des valeurs"
           " initiales."]
          [:p "Ensuite, loop prendra une form. Cette form contiendra"
           " généralement une condition d'arrêt, et le mot clé " [:b "recur"] "."]
          [:p [:b "recur"] " fera revenir l'exécution au début de " [:b "loop"] ","
           " sauf que les valeurs par des variables déclarés vaudront maintenant"
           " les paramètres passés à " [:b "recur"] " et non les valeurs initiales."]
          [:p "La condition d'arrêt est là pour arrêter l'exécution et retourner un"
           " résultat."]
          [:h3 "Exemple détaillé"]
          [:p "Prenons par exemple le code suivant:"]
          [:pre [:code "(loop [counter 5
       result []]
  (if (= counter 0)
    (println result "\n")
    (recur (dec counter)
           (conj result counter))))"]]

          [:p "L'exécution peut être visualisée comme suit:"]
          [:ul
           [:li [:p "Au début, les variables " [:b "counter"] " et " [:b "result"]
                 " valent respectivement " [:b "5"] " et " [:b "[]"] "."]]
           [:li [:b "counter"] " n'est pas égal à " [:b "0"] ", " [:b "recur"] " est"
            " donc appelé avec les résultats de " [:b "(dec counter)"] " et "
            [:b "(conj result counter)"] ", c'est à dire " [:b "(recur 4 [5])"] "."]
           [:li [:b "recur"] " ayant été appelé, nous revenons au début de "
            [:b "loop"] " sauf que maintenant " [:b "counter"] " vaudra " [:b "4"]
            " et " [:b "result"] " vaudra " [:b "[5]"] "."]
           [:li [:b "counter"] " n'est toujours pas égal à " [:b "0"] ", "
            [:b "recur"] " est donc rappelé avec les nouveaux résultats "
            "de " [:b "(dec counter)"] " et " [:b "(conj result counter)"] ", c'est"
            " à dire " [:b "(recur 3 [5 4])"] "."]
           [:li "L'itération se répète jusqu'à ce que " [:b "counter"] " soit"
            " à " [:b "0"] ". A ce moment là, " [:b "recur"] " n'est pas appelé"
            ", on appelle " [:b "println"] " et l'on sort de la loop."]]
          [:p [:b "loop"] " est une construction intéressante, mais en Clojure"
           " son utilisation est très limitée. Il est plus intéressant d'utiliser"
           " des fonctions comme " [:b "map"] ", " [:b "reduce"] " ou " [:b "filter"]
           " que nous verrons dans la suite de ce tutoriel."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
