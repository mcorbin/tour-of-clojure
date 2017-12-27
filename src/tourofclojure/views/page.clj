(ns tourofclojure.views.page)

(defn page
  [desc-content code-content]
  [:div {:class "code,container-fluid"}
   [:div {:class "row"}
    [:div {:class "col-sm"}
     desc-content]
    [:div {:class "col-sm"}
     [:div
      [:pre
       [:code {:class "language-klipse"}
        code-content]]]]]])
