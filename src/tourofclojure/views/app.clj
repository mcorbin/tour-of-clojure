(ns tourofclojure.views.app
  (:require [hiccup.page :refer [html5 include-css include-js]]
            [tourofclojure.views.header :refer [header]]
            [tourofclojure.views.footer :refer [footer]]))

(defn app
  [content]
  (html5
   [:head
    [:meta {:content "text/html;charset=utf-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1, shrink-to-fit=no"}]
    [:title "A tour of Clojure"]
    (include-css "/css/bootstrap.min.css")
    (include-js "/js/jquery-3.2.1.slim.min.js")
    (include-js "/js/popper.min.js")
    (include-js "/js/bootstrap.min.js")
    (include-css "/css/style.css")

    (include-css "/css/codemirror.css")
    (include-js "/js/klipse_selector.js")

    [:body
     header
     [:div {:class "clear"}]
     [:div  content]
     (include-js "/js/klipse_plugin.js")
     footer]]))
