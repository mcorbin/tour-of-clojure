(ns tourofclojure.handlers
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [tourofclojure.views.app :as app-view]
            [tourofclojure.views.page :as page]
            [tourofclojure.pages.index :as index]
            [tourofclojure.pages.menu :as menu]
            [tourofclojure.pages.datastructures :as page-datastructures]
            [tourofclojure.pages.forms :as page-forms]
            [tourofclojure.pages.primitives-types :as page-types]
            ))

(defn get-page
  [id]
  (apply page/page
         (condp = id
           "1" (page-types/page 1)
           "2" (page-datastructures/page 2)
           "3" (page-forms/page 3))))

(defroutes app-routes
  (GET "/" [] (app-view/app (apply page/page index/index)))
  (GET "/pages/:id" [id] (app-view/app (get-page id)))
  (GET "/menu" [] (app-view/app menu/menu))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(defn get-handler
  []
  app)
