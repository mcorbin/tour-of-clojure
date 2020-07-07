(ns tourofclojure.pages.fn-map-second
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/fn_map_second.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Opérations sur les Maps: partie 2"]
          [:p "Il existe un grand nombre de fonctions simplifiant la manipulation"
           " complexe de Maps en Clojure."]
          [:p "En voici quelques unes permettant notamment"
           " de manipuler des maps imbriquées de façon simple."]
          [:p "En Clojure on se retrouve souvent face à des structures"
           " de données qui peuvent s'avérer complexes. Heureusement, la librairie"
           " standard est généralement assez riche pour travailler sur ces"
           " données sans complications inutiles."]
          [:h3 "assoc-in"]
          [:p "La fonction " [:b "assoc-in"] " permet d'associer une clé à "
           " une valeur (comme " [:b "assoc"] ") dans une map "
           "imbriquée dans une ou plusieurs autres maps."]
          [:pre [:code "{:foo {:bar {:hello \"hello\"}}}"]]
          [:p "La structure de données précédente est une imbrication de trois"
           " maps. Comment mettre à jour facilement la map la plus imbriquée (celle"
           " contenant la clé " [:b ":hello"] ") ?"]
          [:pre [:code "(assoc-in {:foo {:bar {:hello \"hello\"}}}
          [:foo :bar :goodbye] \"goodbye\")"]]
          [:p "Le code précédent traversera les deux premières map en utilisant"
           " les clés " [:b ":foo"]  " et " [:b ":bar"] " et ensuite associera à la dernière"
           " clé du vector passée en paramètre (" [:b ":goodbye"] ") la valeur "
           [:b "goodbye."]]
          [:h3 "get-in"]
          [:p "Cette fonction permet de récupérer une valeur présente dans"
           " plusieurs maps imbriquées. Par exemple, pour récupérer la valeur de la "
           "clé " [:b ":hello"] " dans la map précédente, on pourra faire:"
           [:pre [:code "(get-in {:foo {:bar {:hello \"hello\"}}}
        [:foo :bar :hello])"]]]
          [:h3 "update-in"]
          [:p "Cette fonction permet de mettre à jour une valeur dans une map"
           " imbriquée. Par exemple:"]
          [:pre [:code "(update-in {:foo {:bar {:hello 1}}}
          [:foo :bar :hello] inc"]]
          [:p "incrémentera la valeur de la clé " [:b "hello"] "."]

          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
