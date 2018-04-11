(ns tourofclojure.pages.doseq
  (:require [hiccup.element :refer [link-to]]
            [tourofclojure.pages.util :refer [navigation-block]]))

(def code
  (slurp "resources/public/pages/code/doseq.clj"))

(defn desc
  [previous next lang]
  (condp = lang
    "fr" [:div
          [:h2 "doseq"]
          [:p [:b "doseq"] " permet d'itérer sur une séquence et d'exécuter"
           " pour chaque élément une action. Une fois l'itération terminée,"
           " doseq retourne " [:b "nil"] "."]
          [:pre [:code "(doseq [value [0 1 2 3 4]]
  (println value))"]]
          [:p "On remarque que doseq commence par une déclaration semblable à "
           [:b "let"] ". Ici, on indique que l'on va itérer sur un vector de"
           " 5 éléments, et que l'on utilisera " [:b "println"] " sur chaque"
           " valeur du vector (accessible via la variable " [:b "value"] "."]
          [:p [:b "doesq"] " retournant toujours " [:b "nil"] ", il est"
           " généralement utilisé pour provoquer des effets de bords"
           " (comme dans notre exemple avec l'utilisation de " [:b "prinln"] ")."]
          [:p [:b "doseq"] " peut également être utilisé pour itérer sur"
           " plusieurs séquences, comme dans cet exemple:"]
          [:pre [:code "(doseq [v1 [0 1 2 3 4]
        v2 [10 9 8 7 6]]
  (println v1 \":\" v2))"]]
          [:p "Ici, on affichera toutes les combinaisons de v1 et v2 possibles."]
          [:p "Il est possible d'utiliser de faire un peu de magie avec "
           [:b "doseq"] ", via les keywords " [:b ":let"] ", " [:b ":when"] " et "
           [:b ":while"] ". Je ne présenterais ici que les deux premiers, "
           [:b ":while"] " étant assez complexe. Personnellement, je pense qu'il"
           " faut faire attention avec ces keywords qui peuvent parfois nuire"
           " à la lisibilité du code."]
          [:pre [:code "(doseq [v1 [0 1 2]
        v2 [10 9 8]
        :let [result (* v1 v2)]
        :when (> result 17)]
  (println result))"]]
          [:p "Ici, on déclare avec " [:b ":let"] " une variable "
           [:b "result"] " comme étant la "
           "multiplication de " [:b "v1"] " et " [:b "v2"] ", et on utilise "
           [:b ":when"] " pour filtrer tous les résultats inférieurs à 17."]
          [:p "Détail intéressant, le " (link-to {} "/pages/16" "destructuring")
           " fonctionne avec " [:b "doseq"] "."]
          (navigation-block previous next)]

    [:h2 "Language not supported."]))

(defn page
  [previous next lang]
  [(desc previous next lang)
   code])
