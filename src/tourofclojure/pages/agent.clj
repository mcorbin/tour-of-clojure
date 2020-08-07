(ns tourofclojure.pages.agent
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]
            [clojure.java.io :as io]))

(def code
  (slurp (io/resource "public/pages/code/agent.clj")))

(def code-result
  (slurp (io/resource "public/pages/code/agent-result.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Agent"]
          [:p "Un " [:b "agent"] " représente tout comme les " [:b "atoms"] " et les " [:b "refs"] " une identité qui référence une valeur. La particularité d'un agent est qu'il est " [:b "asynchrone"] "."]
          [:p "On peut le comparer à un acteur qui recevra un ensemble d'actions à réaliser et dont le traitement sera effectué de manière autonome sur un pool de threads."]
          [:h3 "Opérations de base"]
          [:p "Un agent se définit via le symbole " [:b "agent"] ", qui prend en paramètre son état."]
          [:pre [:code "(def my-agent (agent 0))"]]
          [:p "Il existe deux fonctions afin de transmettre des actions à un agent: " [:b "send-off"] " et " [:b "send"] "."]
          [:pre [:code "(send-off my-agent
      (fn [state]
        (doing-some-work)
        (inc state)))"]]
          [:p [:b "send-off"] " et " [:b "send"] " prennent toutes les deux en paramètre une fonction dont le premier paramètre est son état et dont la dernière expression sera le nouvel état de l'agent."]
          [:p "Un agent effectuant ses opérations de manière asynchrone mais serialisée (les actions sont faites dans l'ordre de leur insertion) est le candidat idéal si l'on souhaite permettre l'accès à une ressource partagée, comme l'écriture dans un fichier par exemple."]
          [:h3 "send-off et send"]
          [:p "La différence entre " [:b "send-off"] " et " [:b "send"] " est subtile. " [:b "send-off"] " envoie une action qui sera exécutée sur un thread dédié alors que " [:b "send"] " effectuera son opération sur un pool de threads interne à Clojure."]
          [:p "D'une manière générale: si l'opération effectue des opérations bloquantes, il faut utiliser " [:b "send-off"] " alors que les opérations non bloquantes peuvent être réalisées avec " [:b "send"]"."]
          (navigation-block previous next)]


    [:h2 "Language not supported."]))


(defn page
  [previous next lang]
  [(desc previous next lang)
   code
   code-result])
