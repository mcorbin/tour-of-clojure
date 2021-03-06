(ns tourofclojure.pages.remove
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/remove.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "remove"]
          [:p [:b "remove"] " est très semblable à " [:b "filter"] ". Ce dernier"
           " permettait de conserver les éléments validant une condition dans une"
           " séquence. " [:b "remove"] " permet de supprimer d'une séquence les"
           " éléments validant une condition."]
          [:p "Le code suivant:"]
          [:pre [:code "(remove even? [1 2 3])"]]
          [:p " supprimera tous les élémants pairs du vector passé en paramètre."]
          [:p [:b "remove"] " retourne une séquence lazy."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])


