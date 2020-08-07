(ns tourofclojure.pages.while
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/while.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "while"]
          [:p [:b "while"] " permet de répéter une action (généralement un effet de "
           " bord) tant qu'une condition est vraie. Avant de lire cette page,"
           " prenez un peu d'avance et regardez comment les " (link-to {} "/pages/atom" "atoms") " fonctionnent"]
          [:pre [:code "(def state (atom [1 2 3 4 5]))

(while (not-empty @state)
  (println (last @state))
  (swap! state pop))
"]]
          [:p "Dans cet exemple, nous définissons un atom contenant un "
           "vector de 5 éléments. Nous appelons ensuite " [:b "while"] " avec"
           " une condition d'arrêt (qui est ici le fait que le vector soit"
           " vide)."]
          [:p "A chaque itération, " [:b "println"] " est appelé avec comme"
           " paramètre la dernière valeur du vector, puis celle ci est supprimée"
           " en appelant " [:b "pop"] " sur l'atom."]
          [:p "Une fois le vector contenu dans l'atom vide, " [:b "while"]
           " retourne " [:b "nil"] "."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
