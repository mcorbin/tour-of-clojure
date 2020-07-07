(ns tourofclojure.pages.namespaces
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/namespaces")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Namespaces"]
          [:p "Un namespace est une unité d'organisation pouvant contenir des déclarations de variables ("[:b "def"]"), de fonctions ("[:b "defn"]") et des ensembles d'expressions arbitraires. Nommé, il peut être défini avec " [:b "ns"] "."]
          [:pre [:code "(ns mcorbin.core)

(def one 1)
(defn add-one [x] (inc x))"]]
          [:p "Un namespace peut référencer un autre namespace et ainsi utiliser les éléments qu'il expose avec " [:b "require"] "."]
          [:pre [:code "(ns mcorbin.example1)
(require 'mcorbin.core)

(mcorbin.core/add-one 5)"]]
          [:p "Il est courant d'intégrer le require dans la form définissant le namespace :"]
          [:pre [:code "(ns mcorbin.example2)
  (:require [mcorbin.core])

(mcorbin.core/add-one 5)"]]
          [:p "Afin de ne pas avoir à utiliser le nom du namespace complet, il est possible de lui affecter un alias grâce à " [:b ":as"] "."]
          [:pre [:code "(ns mcorbin.example3)
  (:require [mcorbin.core :as core])

(core/add-one 5)"]]
          [:p "Ou d'importer uniquement quelques fonctions avec " [:b "refer"] "."]
          [:pre [:code "(ns mcorbin.example4)
  (:require [mcorbin.core :refer [add-one]])

(add-one 5)"]]
    (navigation-block previous next)]

    [:h2 "Language not supported."]))


(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
