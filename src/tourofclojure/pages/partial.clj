(ns tourofclojure.pages.partial
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/partial.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "partial"]
          [:p "Comme son nom l'indique, " [:b "partial"] " permet de définir une"
           " fonction partielle. "]
          [:p [:b "partial"] " prend en paramètre une fonction"
           " et un certain nombre de paramètres (qui doit être inférieur ou égal"
           " au nombre de paramètre de la fonction). Une fonction sera retournée."
           " Cette fonction peut ensuite être appelée avec des paramètres additionels."]
          [:p "Prenons l'exemple suivant:"]
          [:pre [:code "(def add-one (partial + 1))"]]
          [:p "Nous appliquons ici " [:b "partial"] " sur la fonction " [:b "+"]
           " suivi du paramètre " [:b "1"] "."]
          [:p [:b "add-one"] " contiendra une fonction qui une fois appelée"
           " rajoutera ces paramètres à la form " [:b "(+ 1)"] "."]
          [:p "Par exemple, "[:b "(add-one 2 3)"] " est équivalent à "
           [:b "(+ 1 2 3)"]]
          [:p [:b "partial"] " est donc utilisée pour créer une nouvelle fonction"
           " à partir d'une fonction existante, en ajoutant des valeurs définies"
           " pour un certain nombre de paramètres."]
          (navigation-block page-number)]
    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])

