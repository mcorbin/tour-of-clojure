(ns tourofclojure.pages.fn-map-first
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/fn_map_first.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Opérations sur les Maps: partie 1"]
          [:p "Voici quelques opérations sur les Maps."]
          [:p "On voit ici tout l'intérêt des " [:b "keywords"] " présentés"
           " précédemment. En effet, les clés des Maps sont généralement des"
           " keywords."]
          [:h3 "get"]
          [:p "Une Map peut avoir des clés de tout type, et il est possible"
           " de récupérer la valeur d'une clé via la fonction " [:b "get"] "."]
          [:p "Si la clé est un keyword, il n'est pas nécessaire d'appeler "
           [:b "get"] ", on peut directement utiliser le keyword pour récupérer"
           " la valeur associée."]
          [:p "Par exemple, les codes suivants sont équivalents (et retourneront"
           " comme résultat " [:b "1"] ")"]
          [:pre [:code "(get {:foo 1} :foo) ;; with the get function
(:foo {:foo 1})     ;; with the keyword"]]
          [:p "Vu que la clé " [:b "foo"] " est un keyword, il est possible"
           " d'utiliser cette clé comme une fonction et de se passer de " [:b "get"]
           "."]
          [:p "Il est possible de spécifier une valeur par défaut à retourner"
           " si la clé n'existe pas. Sinon, " [:b "nil"] " sera retourné."]
          [:pre [:code "(get {:foo 1} :bar 2)
(:bar {:foo 1} 2)"]]
          [:p "Les deux expressions précédentes retourneront " [:b "2"] " car la"
           " clé " [:b "bar"] " n'existe pas dans la map."]
          [:h3 "update"]
          [:p "La fonction " [:b "update"] " est intéressante, elle prend comme"
           " paramètre une map, une clé, et une fonction à un argument. Cette"
           " fonction sera appelée avec comme paramètre la valeur associée à la"
           " clé, et le résultat sera associé dans la map à la clé."]
          [:pre [:code "(update {:foo 1} :foo inc)"]]
          [:p "Ce code appliquera à la valeur associée à la clé " [:b "foo"]
           " la fonction " [:b "inc"] ". La valeur retournée sera donc "
           [:b "{:foo 2}"] "."]
          [:p "La fonction peut aussi être utilisée d'une autre façon:"]
          [:pre [:code "(update {:foo 1} :foo + 10 100)"]]
          [:p "On voit que l'on ne passe pas en dernier paramètre une"
           " fonction. Ici, ce code appellera " [:b "+"] " comme cela : "
           [:b "(+ 1 10 100)"] ", 1 étant la valeur de " [:b ":foo"] "."]
          [:p "On passe donc la valeur à mettre à jour et les autres paramètre"
           " de " [:b "update"] " à la fonction " [:b "+"] "."]
          [:h3 "contains?"]
          [:p "La fonction " [:b "contains?"] " permet de tester si une clé"
           " est présente dans une map. Rien de bien compliqué ici ;)"]
          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
