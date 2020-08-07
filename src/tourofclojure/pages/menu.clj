(ns tourofclojure.pages.menu
  (:require [hiccup.element :refer [link-to]]))

(defn menu
  [lang]
  (condp = lang
    "fr" [:div {:class "container-fluid"
                :id "page"}
          [:div {:class "row"}
           [:div {:class "col-sm"}
            [:h3 (link-to {} "/" "Introduction")]
            [:h3 "Types, forms, structures de données et fonctions"]
            [:ul
             [:li (link-to {} "/pages/types" "Types primitifs")]
             [:li (link-to {} "/pages/forms" "Forms et l'appel de fonctions")]
             [:li (link-to {} "/pages/fn-nb" "Opérations sur les nombres")]
             [:li (link-to {} "/pages/datastructures" "Structures de données")]
             [:li (link-to {} "/pages/vector" "Opérations sur les Vectors")]
             [:li (link-to {} "/pages/map1" "Opérations sur les Maps: partie 1")]
             [:li (link-to {} "/pages/map2" "Opérations sur les Maps: partie 2")]
             [:li (link-to {} "/pages/set" "Opérations sur les Sets")]
             [:li (link-to {} "/pages/list" "Opérations sur les Lists")]
             [:li (link-to {} "/pages/sequences" "L'abstraction séquence")]
             [:li (link-to {} "/pages/lazy" "Evaluation lazy")]]
            [:h3 "Définir des fonctions et variables"]
            [:ul
             [:li (link-to {} "/pages/variable" "Définir une variable")]
             [:li (link-to {} "/pages/function" "Définir une fonction")]
             [:li (link-to {} "/pages/firstclass" "Fonctions first class")]
             [:li (link-to {} "/pages/let" "Let et variables locales")]
             [:li (link-to {} "/pages/destr-vec" "Destructuring: Vector")]
             [:li (link-to {} "/pages/destr-map" "Destructuring: Map et defn")]]
            [:h3 "Flow control"]
            [:ul
             [:li (link-to {} "/pages/if" "If, vrai et faux, or et and")]
             [:li (link-to {} "/pages/when-do" "do et when")]
             [:li (link-to {} "/pages/if-let" "if-let et when-let")]
             [:li (link-to {} "/pages/error" "Gestion des erreurs")]
             [:li (link-to {} "/pages/cond" "cond")]
             [:li (link-to {} "/pages/condp" "condp")]
             [:li (link-to {} "/pages/case" "case")]
             [:li (link-to {} "/pages/loop" "loop")]
             [:li (link-to {} "/pages/doseq" "doseq")]
             [:li (link-to {} "/pages/for" "for")]
             [:li (link-to {} "/pages/while" "while")]
             ]
            [:h3 "Programmation fonctionnelle"]
            [:ul
             [:li (link-to {} "/pages/partial" "partial")]
             [:li (link-to {} "/pages/comp" "comp")]
             [:li (link-to {} "/pages/apply" "apply")]
             [:li (link-to {} "/pages/map" "map")]
             [:li (link-to {} "/pages/filter" "filter")]
             [:li (link-to {} "/pages/remove" "remove")]
             [:li (link-to {} "/pages/reduce" "reduce")]
             [:li (link-to {} "/pages/thread-macro" "Threading macros")]
             ]
            [:h3 "Programmation concurrente et parallèle"]
            [:ul
             [:li (link-to {} "/pages/atom" "atom")]
             [:li (link-to {} "/pages/ref" "ref")]
             [:li (link-to {} "/pages/agent" "agent")]
             [:li (link-to {} "/pages/core-async" "core.async")]
             [:li (link-to {} "/pages/more-thread" "Pour aller plus loin")]]
            [:h3 "Namespaces et macros"]
            [:ul
             [:li (link-to {} "/pages/namespaces" "Namespaces")]
             [:li (link-to {} "/pages/macros" "Macros")]]
            ;[:h3 "Développer en Clojure"]
            ;[:ul
             ;[:li (link-to {} "/pages/repl" "Repl Driven Development")]
             ;[:li (link-to {} "/pages/ide" "IDE")]]
            ]]]
    [:h2 "Language not supported"]))
