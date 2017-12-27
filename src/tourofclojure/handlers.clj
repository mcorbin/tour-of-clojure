(ns tourofclojure.handlers
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.cookies :refer [wrap-cookies]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :refer [response content-type redirect]]
            [tourofclojure.views.app :as app-view]
            [tourofclojure.views.page :as page]
            [tourofclojure.pages.index :as index]
            [tourofclojure.pages.menu :as menu]
            [tourofclojure.pages.datastructures :as page-datastructures]
            [tourofclojure.pages.forms :as page-forms]
            [tourofclojure.pages.primitives-types :as page-types]
            ))

(defn get-lang
  [cookies]
  (:value (get cookies "lang") "fr"))

(defn get-page
  [params cookies]
  (let [id (:id params)
        lang (get-lang cookies)]
    (apply page/page
           (condp = id
             "1" (page-types/page 1 lang)
             "2" (page-datastructures/page 2 lang)
             "3" (page-forms/page 3 lang)))))

(defroutes app-routes
  (GET "/" {cookies :cookies} (app-view/app (apply page/page
                                                   (index/index (get-lang cookies)))))
  (GET "/pages/:id" {cookies :cookies
                     params :params} (app-view/app (get-page params cookies)))
  (GET "/menu" {cookies :cookies} (app-view/app (menu/menu (get-lang cookies))))
  (GET "/lang/:lang" [lang] (assoc (redirect "/")
                                   :cookies {"lang"
                                             {:value lang
                                              :path "/"
                                              :max-age 1000000
                                              :http-only true}}))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (wrap-defaults app-routes site-defaults)
       wrap-cookies))

(defn get-handler
  []
  app)
