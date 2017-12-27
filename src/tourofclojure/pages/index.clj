(ns tourofclojure.pages.index
  (:require [hiccup.element :refer [link-to]]))

(def code
  (slurp "resources/public/pages/code/index.clj"))

(defn desc
  [lang]
  (condp = lang
    "fr" [:div
          [:h2 "Bonjour !"]
          [:p]
          [:p "Bienvenue pour une introduction sur le langage "
           (link-to {} "http://clojure.org" "Clojure") "."]

          [:p "Clojure est un langage fonctionnel de la famille des LISP"
           ", dynamiquement typé, fonctionnant dans la machine virtuelle Java, le "
           "Common Language Runtime de Microsoft et compilant en Javascript via "
           (link-to {} "https://clojurescript.org/" "ClojureScript") "."]

          [:p "Ce tutoriel est interactif (via "
           (link-to {} "https://github.com/viebel/klipse" "klipse")
           "), n'hésitez pas à tester et modifier le code !"]

          [:p "Vous pouvez accéder aux pages du tutoriel via le "
           (link-to {} "/menu" "menu") "."]

          [:center
           [:p
            (link-to {} "/pages/1" "Commencer le tutoriel")]] "."]
    [:h2 "Language not supported."]))

(defn index
  [lang]
  [(desc lang)
   code])
