(ns tourofclojure.pages.error
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))
(def code
  (slurp (io/resource "public/pages/code/error.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Gestion des erreurs"]
          [:p "De la même façon que sa plateforme hôte, la gestion des erreurs"
           " en Clojure se base sur des exceptions."]
          [:p "Une exception peut être capturée via un block " [:b "try-catch"]
           " terminé eventuellement d'un block " [:b "finally"] "."
           " Une opération illégale où le mot clé " [:b "throw"] " lèvera"
          " une exception."]
          [:p "En Clojure sur la JVM, les exceptions sont des exceptions Java:"
           [:pre [:code {:class "clojure"}
                  "(try
  (/ 1 0)
  (catch ArithmeticException e
    (str e)))"]]]
          [:p "Il est bien sûr possible d'enchaîner plusieurs catch, avec"
           " différents types d'exceptions:"
           [:pre [:code "(try
  (/ 1 0)
  (catch IndexOutOfBoundsException e
    (str e))
  (catch Exception e
    (str e)))"]]]
          [:p "En ClojureScript (donc dans l'interpréteur à droite de la page),"
           " il est possible de throw tout type de valeurs (comme en JavaScript)."
           " La syntaxe " [:b "catch :default"] " permet de catch l'exception"
           " quelle que soit son type. Attention, cette syntaxe n'existe pas en"
           " Clojure sur la JVM."]
          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
