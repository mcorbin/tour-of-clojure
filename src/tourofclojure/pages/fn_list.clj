(ns tourofclojure.pages.fn-list
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/fn_list.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Opérations sur les Lists"]
          [:p "Voici quelques opérations sur les lists."]
          [:p "Vous allez maintenant sûrement vous demander: à quoi servent les"
           " lists alors que l'on a déjà les vectors?"]
          [:p "Tout d'abord, vous pouvez voir que contrairement à un vector,"
           " les lists \"grandissent\" par la gauche. Les nouvelles valeurs sont"
           " ajoutées au début, contrairement au vector où elles sont ajoutées à"
           " la fin."]
          [:p "De la même manière, les fonctions comme " [:b "peek"] " et "
           [:b "pop"] " retournent ici le premier élément de la liste."]
          [:p "Enfin, les lists ont des performances différentes des vectors."
           " Par exemple, " [:b "nth"] " est très lent par rapport au " [:b "get"]
           " des vectors (vous pouvez voir les listes comme des listes chainées là"
           " où les vectors peuvent accéder à une valeur directement)."]
          [:p "En général, vous utiliserez rarement les lists, sauf quand vous"
           " voulez une structure de données où les valeurs sont ajoutées ou"
           " supprimées au début. Les lists sont également utilisées pour écrire des "
           [:b "macro"] ", un sujet que nous découvrirons plus tard."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
