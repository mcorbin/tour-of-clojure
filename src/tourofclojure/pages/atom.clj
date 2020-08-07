(ns tourofclojure.pages.atom
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]
            [clojure.java.io :as io]))

(def code
  (slurp (io/resource "public/pages/code/atom.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Atom"]
          [:p "Un atom est un type englobant une valeur, c'est à dire qu'il"
           " est une référence vers cette dernière. Les atoms permettent de "
           " modifier cette valeur, ce qui est donc utile pour avoir une variable "
           " que l'on peut modifier."]
          [:p "De plus, les atoms sont thread-safe, via un mecanisme de compare and"
           " set. J'expliquerai plus loin ce que cela signifie"]
          [:h3 "Opérations de base"]
          [:p "Un atom se définit via le symbole " [:b "atom"] ", qui prend en"
           " paramètre l'état initial de l'atom. Il est ensuite possible d'intéragir"
           " avec l'atom via la fonction " [:b "swap!"] "."
           ]
          [:pre [:code "(def my-atom (atom []))

(swap! my-atom conj 10)

(swap! my-atom (fn [old-state] (conj old-state 20)))
"]]
          [:p "Ici, on définit un atom qui sera stocké dans la variable "
           [:b "my-atom."] " On intéragit ensuite avec lui via la fonction "
           [:b "swap!"] ", qui permet de mettre à jour la valeur de l'atom."]
          [:p "On remarque que " [:b "swap!"] " peut prendre comme paramètre"
           " l'atom ainsi qu'une fonction et une suite d'arguments (exemple 1). "
           "Dans ce cas, la valeur de l'atom sera passée comme premier"
           "  paramètre de cette fonction."
           " les autres arguments étant passés à la suite. Dans l'exemple 1, cela"
           " donne donc " [:b "(conj atom-value 10)"] "."
           " Le résultat sera la nouvelle valeur de l'atom."]
          [:p "Il est aussi possible de passer à swap l'atom et directement une"
           " fonction prenant un paramètre (exemple 2). Dans ce cas, la valeur de l'atom"
           " sera le paramètre de cette fonction, et le résultat la nouvelle valeur"
           " de l'atom."]
          [:p "Une autre opération intéressante est " [:b "reset!"] ", qui permet"
           " d'assigner à un atom une valeur:"]
          [:pre [:code "(reset! my-atom [100])"]]
          [:p "Ici, la nouvelle valeur de l'atom sera " [:b "100"] "."]
          [:h3 "Concurrence"]
          [:p "Comme mentionné précédemment, un atom est thread-safe en implémentant un mécanisme de compare and set, soit:"]
          [:ol
            [:li "La valeur de l'atom est lue"]
            [:li "La fonction soumise via " [:b "swap!"] " ou " [:b "reset!"] " est appliquée"]
            [:li "La nouvelle valeur est mise dans l'atom si celle-ci n'a pas changée depuis sa lecture (modifiée par un autre thread).
            Dans le cas contraire, les opérations sont réeffectuées. C'est pourquoi il est important d'éviter les side-effects dans une fonction appliquée à un atom, car cette fonction pourrait être éventuellement rejouée."]
            ]
          (navigation-block previous next)
          ]

    [:h2 "Language not supported."])
  )

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
