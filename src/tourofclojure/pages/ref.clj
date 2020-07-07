(ns tourofclojure.pages.ref
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/ref.clj")))

(def code-result
  (slurp (io/resource "public/pages/code/ref-result.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Ref"]
          [:p "Une " [:b "ref"] " est une identité englobant une valeur. Au même titre qu'un atom, il s'agit d'une référence sur cette dernière.
          Les refs peuvent être modifiées mais uniquement au travers d'une transaction dans la Sofware Transactional Memory (STM)."]
          [:p "Elles remplacent les atoms lorsquent des modifications " [:b "coordonnées"] " sur plusieurs éléments sont requises."]
          [:h3 "Opérations de base"]
          [:p "Une ref se définit via le symbole " [:b "ref"] ", qui prend en paramètre l'état de la ref."]
          [:pre [:code "(def account (ref 1000))"]]
          [:p "Pour intéragir avec une ref, il est nécessaire de se trouver dans une transaction dans la STM. Ceci s'effectue grâce à "
           [:b "dosync"] ". L'utilisation de la STM n'a de sens que si l'on tente de manipuler plusieurs refs et que ces opérations doivent être réalisées de manière atomiques."]
          [:pre [:code "(dosync
  (alter account1 #(+ % 100))
  (alter account2 #(- % 100)))"]]
          [:p "La modification de la ref se fait avec " [:b "alter"] " qui prend en premier paramètre la ref et comme second paramètre une fonction à appliquer.
           Si une autre transaction venait à modifier account1 ou account2 avant que celle-ci se termine, la transaction sera automatiquement relancée."]
          [:p "Si l'ordre dans lequel s'effectue les opérations n'a pas d'importance, il est alors possible d'utiliser " [:b "commute"]]
          [:pre [:code "(dosync
  (commute account1 #(+ % 100))
  (commute account2 #(- % 100)))"]]
          [:p "Une ref peut-être réinitialisé (toujours dans une transaction) grâce à " [:b "ref-set"] "."]
          [:pre [:code "(dosync
  (ref-set account1 0)
  (ref-set account2 0))"]]
          [:h3 "Attention"]
          [:p "Les transactions pouvant potentiellement se relancer plusieurs fois, leur utilisation n'est pas recommandée pour les opérations qui provoquent des effets de bord (I/O)."]
          (navigation-block previous next)]

    [:h2 "Language not supported."]))


(defn page
  [previous next lang]
  [(desc previous next lang)
   code
   code-result])
