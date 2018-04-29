(ns tourofclojure.pages.for
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/for.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "for"]
          [:p [:b "for"] " est utilisée pour faire de la compréhension de liste."]
          [:p "Il est semblable à " (link-to {} "/pages/26" "doseq") " sauf "
           " qu'ici " [:b "for"] " construira une séquence à partir du résultat"
           " de chaque itération."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
