(ns tourofclojure.pages.map
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/map.clj"))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "map"]
          [:p [:b "map"] " prend comme premier paramètre une fonction prenant "
           " un paramètre, puis une séquence. La fonction sera appelée pour chaque"
           " élément de la séquence, et une nouvelle séquence avec les résultats"
           " sera retournée"]
          [:p "Par exemple, le code suivant:"]
          [:pre [:code "(map inc [1 2 3 4])"]]
          [:p " permet d'incrémenter chaque élément du vector passé en paramètre."]
          [:p "Attention, le résultat de " [:b "map"] " est une séquence lazy."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])

