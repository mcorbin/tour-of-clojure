(ns tourofclojure.pages.core-async
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/core_async.clj")))

(def code-result
  (slurp (io/resource "public/pages/code/core_async-result.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "core-async"]
          [:p [:b "core.async"] " est une implémentation de CSP (Communicating Sequential Processes) disponible en Clojure/Clojurescript.
          Non présent au coeur de Clojure, c'est une simple librairie à intégrer."]
          [:p "Son objectif est de fournir un moyen de communiquer entre différents processus sans partager d'état. L'abstraction proposée par core.async est l'utilisation de queues (channels) entre les producteurs de données et les consommateurs."]
          [:p "Le slogan de la documentation Golang résume parfaitement cette approche :"]
          [:p [:code "Do not communicate by sharing memory; instead, share memory by communicating."]]
          [:p "Le moyen de communiquer est le channel pouvant être créé grâce à " [:code "chan"] "."]
          [:pre [:code "(def c (chan)) ; Unbuffered channel === (chan 1)
(def c (chan 10)) ; Buffered channel"]]
          [:p "L'écriture dans un channel se fait grâce aux symbols " [:code ">>!"] " (bloquant jusqu'à consommation) et " [:code ">!"] "(non bloquant)"]
          [:pre [:code "(>>! c 10) ; In one thread"]]
          [:p "La valeur peut être lu d'un channel grâce à " [:code "&lt;&lt;!"] " (bloquant) et respectivement" [:code "&lt;!"] "(non bloquant)"]
          [:pre [:code "(println (&lt;&lt;! c)) ; In another thread"]]
          [:h3 "Go blocks"]
          [:p "Les symbols non bloquants ("[:code "&lt;!"]" et " [:code ">!"] ") ne peuvent être utilisés que dans des go blocks. Un go block est unité de d'éxécution qui va être traitée par un pool de threads.
          Les symbols non bloquants ne vont pas bloquer le thread mais " [:i "\"parquer\""]" le go block en attente de traitement."]
          [:pre [:code "; Producer - Writes number 1 to 100 into the channel c each second
(go
  (doseq [v (range 100)]
    (Thread/sleep 1000)
    (>! c v)))

; Consumer - Reads number 1 to 100 from the channel c
(go
  (loop []
    (println (&lt c)) ; Do not block the thread, the go block is parked
    (recur)))"]]
          [:h3 "Attente d'un channel"]
          [:p "Dans le cas où nous avons plusieurs producteurs, il peut s'avérer utile de consommer une donnée dès que celle-ci est disponible."
          [:p [:code "alts!!"] " et respectivement " [:code "alts!"] " au sein d'un go block permettent de consommer dès que possible. "[:code "alts!"] " prend en paramètre une séquence de channels et retourne une séquence composée d'une valeur et du channel à partir duquel celle-ci a été produite."]]
          [:pre [:code "; Creates two channels
(def one-chan (chan))
(def two-chan (chan))

; Produces 1 every second
(go
  (loop []
    (Thread/sleep 1000)
    (>! one-chan 1)
    (recur)))

; Produces 2 every two seconds
(go
  (loop []
    (Thread/sleep 2000)
    (>! two-chan 2)
    (recur)))

; Consumes both channels as soon as possible
(go
  (loop []
    (let [[v c] (alts! [one-chan two-chan])]
      (prn v)
      (recur))))"]]
    [:h3 "Go blocks & I/O bloquante"]
    [:p "Comme le pool de threads à disposition des go blocks est borné, effectuer de l'I/O bloquante n'est pas particulièrement adapté.
    core.async met à disposition une fonction nommée " [:code "thread"] " qui exécute un traitement dans un nouveau thread en retournant un channel qui fournira le résultat dès résolution."]
    [:pre [:code "(defn blocking-io [])
    (thread
      (Thread/sleep 2000) ; Waiting for I/O
      \"Response!\")

(go
  (println (&lt;! (blocking-io))))"]]
    [:h3 "Aller plus loin"]
    [:p "Nous avons abordé les principales primitives de " [:b "core-async"] ", les quelques liens suivants vous permettront de creuser le sujet :"]
    [:p [:a {:href "https://clojure.org/news/2013/06/28/clojure-clore-async-channels"} "Clojure core.async Channels"]]
    [:p [:a {:href "https://github.com/clojure/core.async/blob/master/examples/walkthrough.clj"} "core.async Walkthrough"]]]
    [:h2 "Language not supported."]))


(defn page
  [previous next lang]
  [(desc previous next lang)
   code
   code-result])
