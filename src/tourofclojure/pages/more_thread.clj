(ns tourofclojure.pages.more-thread
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/more_thread.clj")))

(def code-result
  (slurp (io/resource "public/pages/code/more_thread-result.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Multithreadisme: Pour aller plus loin"]
          [:p "Clojure propose beaucoup d'autres éléments afin de simplifier la programmation concurrente et parralèle.
          De plus, on peut toujours utiliser les primitives de la plateforme hôte grâce à l'interopérabilité Java."]
          [:h3 "Future"]
          [:p "Une future permet l'exécution d'un traitement dans un nouveau thread. Une fois résolue, la valeur est mise en cache."]
          [:pre [:code "(def my-future
  (future
    (Thread/sleep 10000) ;; doing some work
    4))                  ;; returns and cache the result"]]
          [:p "Elle peut être déréférencée de manière bloquante grâce à " [:b "deref"] " ou " [:b "@"] "."]
          [:pre [:code "(deref my-future) ;; dereferences the future - blocking"]]
          [:h3 "Promise"]
          [:p "Une promise est une primitive qui peut être lue que lorsque sa valeur lui a été fournie grâce à "[:b "deliver"]" (par un autre thread)."]
          [:pre [:code "(def my-promise (promise))
(deliver my-promise 12)"]]
          [:p "Elle peut être déréférencée de manière bloquante grâce à " [:b "deref"] " ou " [:b "@"] "."]
          [:pre [:code "(deref my-promise) ;; deferences the promise - blocking until a value has been delivered"]]
          [:h3 "Java Interop"]
          [:p "La langage Java continue de fournir des éléments intéressants dans son package " [:b "java.util.concurrent"] ". On retrouve par exemple les Executors et le ForkJoin framework."]
          [:p "L'intéropérabilité avec le langage Java est très simple : "]
          [:ul
            [:li "Le " [:code "."] " ajouté au nom de la classe permet d'instancier un objet "]
            [:li "Le " [:code "/"] " permet d'appeler une méthode statique sur une classe "]
            [:li "Le " [:code "."] " ajouté au début du nom de la méthode permet de l'invoquer"]]
          [:pre [:code
";; Calls the constructor
(def queue (java.util.concurrent.ArrayBlockingQueue.))

;; Calls a static method
(def executor (java.util.concurrent.Executors/newFixedThreadPool 10))

;; Calls a method on an object
(.submit executor #(println \"Hello\"))"]]
  (navigation-block previous next)]


    [:h2 "Language not supported."])
  )

(defn page
  [previous next lang]
  [(desc previous next lang)
   code
   code-result])
