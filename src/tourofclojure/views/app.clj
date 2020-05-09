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
    (include-css "/css/highlight.css")
    (include-js "/js/highlight.pack.js")

    (include-css "/css/codemirror.css")
    (include-js "/js/script.js")

    [:body
     header
     [:div {:class "clear"}]
     [:div {:id "page"} content]
     (include-js "/js/klipse_plugin.js")
     (include-js "/js/clojure.min.js")
     (include-js "/js/script-non-interactive.js")
     footer]]))
