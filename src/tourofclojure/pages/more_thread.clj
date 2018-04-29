(ns tourofclojure.pages.more-thread
  (:require [hiccup.element :refer [link-to]]
            [clojure.java.io :as io]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp (io/resource "public/pages/code/more_thread.clj")))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "Multithreadisme: Pour aller plus loin"]
          [:p "TODO"]
          ]

    [:h2 "Language not supported."])
  )

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
