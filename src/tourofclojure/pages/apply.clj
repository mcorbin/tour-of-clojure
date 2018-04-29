(ns tourofclojure.pages.apply
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]
            [clojure.java.io :as io]))

(def code
  (slurp (io/resource "public/pages/code/apply.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "apply"]
          [:p [:b "apply"] " permet de passer à une fonction ses paramètres"
           " sous forme de liste. Par exemple:"]
          [:pre [:code "(apply + [1 2 3 4 5])"]]
          [:p " est équivalent à :"]
          [:pre [:code "(+ 1 2 3 4 5)"]]
          [:p "Les paramètres, ici sous forme de vector, sont passées à la fonction "
           [:b "+"] "."]
          [:p "Là aussi, l'utilisation de " [:b "partial"] " peut avoir son utilité:"]
          [:pre [:code "(apply (partial conj [1 2 3]) [4 5 6 7])"]]
          [:p "Ce code utilise " [:b "partial"] " pour créer une fonction"
           " qui ajoutera au vector " [:b "[1 2 3]"] " les paramètres passées."
           "On peut ensuite appeler cette fonction avec " [:b "apply"] "."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])


