(ns tourofclojure.handlers
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [tourofclojure.views.app :as app-view]
            [tourofclojure.views.page :as page]
            [tourofclojure.pages.index :as index]
            [tourofclojure.pages.welcome :as welcome]
            ))

(defn get-page
  [id]
  (apply page/page
         (condp = id
           "1" welcome/welcome1
         )))

(defroutes app-routes
  (GET "/" [] (app-view/app (apply page/page index/index)))
  (GET "/welcome/:id" [id] (app-view/app (get-page id)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(defn get-handler
  []
  app)
