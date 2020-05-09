(ns tourofclojure.views.page-non-interactive)


(defn page
  [desc-content code-content code-result]
  [:div {:class "container-fluid"}
   [:div {:class "row"}
    [:div {:class "col-sm"}
     desc-content]
    [:div {:class "col-sm"}
     [:div
      [:textarea {:id "code"}
        code-content]
      [:textarea {:id "code-result"}
       code-result]]]]])
