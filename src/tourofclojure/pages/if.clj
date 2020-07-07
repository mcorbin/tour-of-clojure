(ns tourofclojure.pages.if
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))


(def code
  (slurp (io/resource "public/pages/code/if.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "If"]
          [:p "Faire un if en Clojure est simple. La syntaxe est "
           [:pre [:code {:class "clojure"} "(if condition form-executée-si-vrai form-exécutée-si-faux)"]] "."
           "Et c'est à peu près tout. La syntaxe de Clojure étant très cohérente,"
           " un if n'a pas de syntaxe spéciale."]
          [:h3 "Vrai et faux"]
          [:p "Une petite subtilité de Clojure est dans la réponse à la question"
           " \"qu'est ce qui est interprété comme vrai ou faux dans une condition ?\""]
          [:p "Ici aussi, ia règle est simple. Le booléen " [:b "false"] " vaut"
           " bien évidemment faux, " [:b "nil"] " est également considéré comme"
           " faux en clojure, et enfin " [:b "tout le reste"] " est considéré comme"
           " vrai."]
          [:p "Dans la condition d'un if, une fonction, une structure de données, "
           " un keyword, un entier... Tout sera vrai, à part le booléen false et nil."]
          [:p "Dernier détail sur " [:b "if"] ": la branche exécutée si la"
           " condition est fausse est optionnelle. En cas de condition fausse et"
           " sans de branches associée, " [:b "if"] " retournera " [:b "nil"] "."]
          [:h3 "or et and"]
          [:p [:b "or"] " sert à vérifier si au moins un de ses paramètres est "
           " évalué comme vrai. Si oui, ce paramètre sera retourné. Si non, " [:b "or"]
           " retournera son dernier paramètre. La valeur retournée peut ensuite"
           " être utilisée dans la condition d'un if par exemple."]
          [:p "De la même manière, " [:b "and"] " retournera le premier de ses"
           " paramètres valant faux, ou bien retournera son dernier paramètre."]
          (navigation-block previous next)]
    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
