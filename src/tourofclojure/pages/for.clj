(ns tourofclojure.pages.for
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/for.clj"))

(defn desc
  [page-number lang]
  (condp = lang
    "fr" [:div
          [:h2 "for"]
          [:p [:b "for"] " est utilisée pour faire de la compréhension de liste."]
          [:p "Il est semblable à " (link-to {} "/pages/26" "doseq") " sauf "
           " qu'ici " [:b "for"] " construira une séquence à partir du résultat"
           " de chaque itération."]
          (navigation-block page-number)]
    [:h2 "Language not supported."]))

(defn page
  [page-number lang]
  [(desc page-number lang)
   code])
