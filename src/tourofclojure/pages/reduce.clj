(ns tourofclojure.pages.reduce
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/reduce.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "reduce"]
          [:p [:b "reduce"] " permet d'itérer sur une séquence tout en"
           " stockant un résultat dans un accumulateur. Nous verrons ici que "
           [:b "reduce"] " permet de faire beaucoup, beaucoup de choses. Attention,"
           " comme " [:b "map"] ", " [:b "reduce"] " est lazy."
           ]
          [:h3 "Un exemple simple"]
          [:p "Prenons le code suivant:"]
          [:pre [:code "(reduce + [1 2 3 4 5])"]]
          [:p "On voit ici que " [:b "reduce"] " prend 2 paramètres: une fonction"
           "(" [:b "+"] " dans ce cas), ainsi qu'un vector. Ici, reduce retournera"
           " la somme de tous les éléments dans le vector, c'est à dire " [:b "15"]
           "."]
          [:p "Le traitement réalisé par " [:b "reduce"] " peut être décrit de"
           " la manière suivante:"]
          [:ul
           [:li [:b "reduce"] " va tout d'abord appeler la fonction " [:b "+"]
            " avec les deux premiers éléments du vector. Cela va donner donner"
            [:pre [:code "(+ 1 2)"]] "Le résultat est donc " [:b "3"] "."]
           [:li "Ensuite, " [:b "reduce"] " appellera la fonction avec comme"
            " premier paramètre le résultat précédent (3) suivi de l'élément suivant"
            " non traité du vectur, c'est à dire le troisième élément (donc de"
            " valeur 3 également). Cela donnera"
            [:pre [:code "(+ 3 3)"]]
            "Le résultat intermédiaire est donc maintenant " [:b "6"] "."]
           [:li "Le calcul va continuer, " [:b "6"] " sera additionné à l'élément"
            " suivant (4) ce qui donnera " [:b "10"] ", puis 15 lors de l'ajout"
            " du dernier élément de la liste."]
           [:li [:b "reduce"] " retourne ensuite le résultat: " [:b "15"]]]

          [:p "Le code suivant:"]
          [:pre [:code "(reduce #(+ %1 %2) [1 2 3 4 5])"]]
          [:p " est équivalent. On voit que l'on passe ici une fonction anonyme prenant"
           " deux paramètres pour réaliser la somme."]

          [:h3 "Valeur initiale"]
          [:p "Il est possible de donner à " [:b "reduce"] " une valeur initiale"
           " qui sera utilisée lors du premier calcul. Par exemple, dans le"
           " code suivant:"
           [:pre [:code "(reduce + 30 [1 2 3 4 5])"]]
           [:p "Le premier calcul sera " [:b "(+ 30 1)"] " et non " [:b "(+ 1 2)"]
            " comme précédemment, car on utilise une valeur par défaut."]]

          [:h3 "reduced"]
          [:p "Il peut être parfois utile d'arrêter la reduction à un moment"
           " donné basé sur une condition. Par exemple:"]
          [:pre [:code "(reduce (fn [acc elem] (if (> (+ acc elem) 5)
                                  (reduced elem)
                                  (+ acc elem)))
                 [1 2 3 4 5])"]]
          [:p "Ici, on vérifie dans la fonction si le nouveau résultat intermédiaire"
           " est supérieur à 5. "
           "Si oui, on arrête la réduction avec " [:b "reduced"] " et on retourne"
           " l'élément de la collection ayant provoqué la validité de la condition"
           " (le paramètre de " [:b "reduced"] " est la valeur retournée)."]
          [:p "Ici, l'élément " [:b "3"] " est retourné, car en effet "
           [:b "(+ 1 2 3)"] " est supérieur à 5."]
          [:p [:b "reduced"] " permet aussi d'appeler " [:b "reduce"] " sur "
           " des séquences lazy infinies, et de stopper le calcul à un moment donné."]
          [:h3 "Conclusion"]
          [:p [:b "reduce"] " est très utile et permet de faire beaucoup de choses."
           " D'ailleurs, essayez de réimplémenter " [:b "map"] " ou " [:b "filter"]
           " avec " [:b "reduce"] ", cela est un bon exercice."]
          (navigation-block page-number)]

    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])


