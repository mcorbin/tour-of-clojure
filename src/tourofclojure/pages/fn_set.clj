(ns tourofclojure.pages.fn-set
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/fn_set.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "Opérations sur les Set"]
          [:p "Voici quelques opérations sur les Set."]
          [:p "Je ne présente ici que les fonctions de base pour manipuler les set."]
          [:p "Comme vous pouvez le constater, je préfixe certaines fonctions"
           " par " [:b "clojure.set"] ", car certaines fonctions spécifiques au"
           " set ne sont pas présentes dans le core de Clojure mais dans un "
           [:b "namespace"] " spécifique."]
          [:p "Je reviendrais dans un autre chapitre sur les namespaces et"
           " l'importation de fonctions présentes dans un autre namespace."]
          [:p "vous pouvez retrouver "
           (link-to {} "https://clojure.github.io/clojure/clojure.set-api.html" "ici")
           " d'autres fonctions pour manipuler les set."]
          (navigation-block page-number)]

    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])
