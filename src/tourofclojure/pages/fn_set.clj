(ns tourofclojure.pages.fn-set
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/fn_set.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Opérations sur les Sets"]
          [:p "Voici quelques opérations sur les Sets."]
          [:p "Je ne présente ici que les fonctions de base pour manipuler les sets."]
          [:p "Comme vous pouvez le constater, je préfixe certaines fonctions"
           " par " [:b "clojure.set"] ", car certaines fonctions spécifiques aux"
           " sets ne sont pas présentes dans le core de Clojure mais dans un "
           [:b "namespace"] " spécifique."]
          [:p "Je reviendrai dans un autre chapitre sur les namespaces et"
           " l'importation de fonctions présentes dans un autre namespace."]
          [:p "Vous pouvez retrouver "
           (link-to {} "https://clojure.github.io/clojure/clojure.set-api.html" "ici")
           " d'autres fonctions pour manipuler les sets."]
          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
