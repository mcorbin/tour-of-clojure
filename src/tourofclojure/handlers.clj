(ns tourofclojure.handlers
  ;; wtf is this giant require
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
            [tourofclojure.pages.fn-nb :as fn-nb]
            [tourofclojure.pages.sequences :as page-sequences]
            [tourofclojure.pages.fn-vector :as page-vector]
            [tourofclojure.pages.fn-map-first :as page-map-first]
            [tourofclojure.pages.fn-map-second :as page-map-second]
            [tourofclojure.pages.fn-set :as page-set]
            [tourofclojure.pages.fn-list :as page-list]
            [tourofclojure.pages.lazy :as page-lazy]
            [tourofclojure.pages.variable :as page-variable]
            [tourofclojure.pages.functions :as page-functions]
            [tourofclojure.pages.fn-firstclass :as page-firstclass]
            [tourofclojure.pages.let :as page-let]
            [tourofclojure.pages.destructuring-vector :as page-destructuring-vec]
            [tourofclojure.pages.destructuring-map :as page-destructuring-map]
            [tourofclojure.pages.if :as page-if]
            [tourofclojure.pages.when-do :as page-when-do]
            [tourofclojure.pages.if-let :as page-if-let]
            [tourofclojure.pages.cond :as page-cond]
            [tourofclojure.pages.condp :as page-condp]
            [tourofclojure.pages.case :as page-case]
            [tourofclojure.pages.error :as page-error]
            [tourofclojure.pages.loop :as page-loop]
            [tourofclojure.pages.doseq :as page-doseq]
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
             "2" (page-forms/page 2 lang)
             "3" (fn-nb/page 3 lang)
             "4" (page-datastructures/page 4 lang)
             "5" (page-vector/page 5 lang)
             "6" (page-map-first/page 6 lang)
             "7" (page-map-second/page 7 lang)
             "8" (page-set/page 8 lang)
             "9" (page-list/page 9 lang)
             "10" (page-sequences/page 10 lang)
             "11" (page-lazy/page 11 lang)
             "12" (page-variable/page 12 lang)
             "13" (page-functions/page 13 lang)
             "14" (page-firstclass/page 14 lang)
             "15" (page-let/page 15 lang)
             "16" (page-destructuring-vec/page 16 lang)
             "17" (page-destructuring-map/page 17 lang)
             "18" (page-if/page 18 lang)
             "19" (page-when-do/page 19 lang)
             "20" (page-if-let/page 20 lang)
             "21" (page-error/page 21 lang)
             "22" (page-cond/page 22 lang)
             "23" (page-condp/page 23 lang)
             "24" (page-case/page 24 lang)
             "25" (page-loop/page 25 lang)
             "26" (page-doseq/page 26 lang)
             ))))

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
