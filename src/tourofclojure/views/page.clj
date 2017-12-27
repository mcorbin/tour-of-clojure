(ns tourofclojure.views.page)

(defn page
  [desc-content code-content]
  [:div {:class "container-fluid"
         :id "page"}
   [:div {:class "row"}
    [:div {:class "col-sm"}
     desc-content]
    [:div {:class "col-sm"}
     [:pre
      [:code {:class "language-klipse"}
       code-content]]]]])
