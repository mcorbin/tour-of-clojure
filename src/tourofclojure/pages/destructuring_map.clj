(ns tourofclojure.pages.destructuring-map
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/destructuring_map.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Destructuring - Map et defn"]
          [:p "En Clojure, vous pouvez aussi destructurer des maps."]
          [:p "Dans le premier exemple, on voit que l'on peut déstructurer une"
           " map en définissant via la syntaxe " [:b "{name1 key1 name2 key2}"] "."
           " Dans cet exemple, les variables f1, f2, et f3 auront comme valeur les"
           " clés correspondantes."]
          [:p "Il est possible de faire la même chose de façon plus concise via le"
           " mot clé " [:b ":keys"] ", qui suivi d'un vector permet de récupérer"
           " les variables associées à ces clés."
           [:b " Attention, le nom de la variable doit être identique à la clé "
            " sous forme de keyword"] ". Par exemple " [:b "s1"] " pour une clé"
           " nommée " [:b ":s1"] "."
           [:br]
           "Il existe d'autres mot clé de ce type, comme " [:b ":strs"] " qui"
           " fonctionne de la même manière mais pour des clés de type string."
           " Vous pouvez trouver plus de détails à ce propos dans la "
           (link-to {} "https://clojure.org/guides/destructuring" "documentation officielle") "."]
          [:p "Comme pour les vectors, " [:b ":as"] " permet de récupérer la"
           " valeur complète d'une map déstructurée. Vous pouvez bien sûr également"
           " utiliser le destructuring sur des maps imbriquées."]
          [:p "Chose très intéressante, le mot clé " [:b ":or"] " permet lui de"
           " définir des valeurs par défaut si la clé est absente de la map."]
          [:h3 "Et les fonctions ?"]
          [:p "Le destructuring ne s'utilise pas que dans les clauses " [:b "let"]
           ". Vous pouvez aussi l'utiliser dans les paramètres de fonctions !"]
          [:p "C'est d'ailleurs comme cela que vous pouvez écrire des fonctions"
           " prenant en paramètre un nombre indéfini d'éléments (en déstructurant"
           " le vector des paramètres)."
           ]
          [:h3 "Conclusion"]
          [:p "Le destructuring est un outil très puissant. Vous pouvez combiner"
           " toutes les façons que nous avons vu pour destructurer des structures"
           " de données ensemble pour accéder à leur contenu de façon concise."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
