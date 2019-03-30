(ns tourofclojure.pages.lazy
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/lazy.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Evaluation lazy"]
          [:p "Clojure supporte les séquences lazy. D'ailleurs, "
           "un certain nombre de fonctions (comme " [:b "map"] " par "
           "exemple, présenté plus loin dans ce tutoriel) retournent des "
           "séquences lazy."]
          [:pre [:code "(defn numbers
  [n]
  (lazy-seq (cons (do (println n \"!\") n) (numbers (inc n)))))
"]]
          [:p "La fonction récursive " [:b "numbers"] " prend un paramètre et retourne une "
           "séquence lazy contenant tous les entiers supérieurs ou égal à " [:b "n"] "."
           " La fonction appelle également " [:b "println"] " pour chaque entier."]
          [:p "La variable " [:b "s"] " contient le résultat de la fonction "
           [:b "numbers"] ". A ce moment, on voit que " [:b "println"] " n'a"
           " jamais été appelé. La séquence est créée, mais aucun calcul"
           " n'a été exécuté."]
          [:p "Rajoutez dans l'interpréteur " [:b "(take s 4)"] " pour "
           "obtenir les 4 premières valeurs de la séquence. Vous pouvez voir que "
           [:b "println"] " est appelé pour ces valeurs, la séquence s'est"
           " donc réalisée pour ces 4 valeurs."]
          [:p "Il est possible de forcer la réalisation d'une séquence lazy"
           " via la fonction " [:b "dorun"] ". Essayez par exemple "
           [:b "(dorun 10 s)"] " pour réaliser la séquence pour ses 10 premières"
           " valeurs. Si vous réalisez plusieurs fois le même appel à dorun,"
           " vous verrez que " [:b "println"] " n'est pas appelé. Ceci est normal,"
           " cette partie de la séquence lazy a déjà été réalisée."]
          [:p "Vous pouvez aussi forcer la réalisation de l'entièreté d'une"
           " séquence lazy via " [:b "doall"] ". Attention, sur une séquence infinie,"
           " cela peut vous causer des problèmes, la réalisation étant également"
           " infinie."]

          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])

