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
            [tourofclojure.pages.for :as page-for]
            [tourofclojure.pages.while :as page-while]
            [tourofclojure.pages.partial :as page-partial]
            [tourofclojure.pages.comp :as page-comp]
            [tourofclojure.pages.apply :as page-apply]
            [tourofclojure.pages.map :as page-map]
            [tourofclojure.pages.filter :as page-filter]
            [tourofclojure.pages.remove :as page-remove]
            [tourofclojure.pages.reduce :as page-reduce]
            [tourofclojure.pages.thread-macro :as page-thread-macro]
            [tourofclojure.pages.atom :as page-atom]
            [tourofclojure.pages.ref :as page-ref]
            [tourofclojure.pages.agent :as page-agent]
            [tourofclojure.pages.core-async :as page-core-async]
            [tourofclojure.pages.more-thread :as page-more-thread]
            [tourofclojure.pages.namespaces :as page-namespaces]
            [tourofclojure.pages.macros :as page-macros]
            [tourofclojure.pages.repl-driven :as page-repl]
            [tourofclojure.pages.ide :as page-ide]
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
             "types" (page-types/page nil "forms" lang)
             "forms" (page-forms/page "types" "fn-nb" lang)
             "fn-nb" (fn-nb/page "forms" "datastructures" lang)
             "datastructures" (page-datastructures/page "fn-nb" "vector" lang)
             "vector" (page-vector/page "datastructures" "map1" lang)
             "map1" (page-map-first/page "vector" "map2" lang)
             "map2" (page-map-second/page "map1" "set" lang)
             "set" (page-set/page "map2" "list" lang)
             "list" (page-list/page "set" "sequences" lang)
             "sequences" (page-sequences/page "list" "lazy" lang)
             "lazy" (page-lazy/page "sequences" "variable" lang)
             "variable" (page-variable/page "lazy" "function" lang)
             "function" (page-functions/page "variable" "firstclass" lang)
             "firstclass" (page-firstclass/page "function" "let" lang)
             "let" (page-let/page "firstclass" "destr-vec" lang)
             "destr-vec" (page-destructuring-vec/page "let" "destr-map" lang)
             "destr-map" (page-destructuring-map/page "destr-vec" "if" lang)
             "if" (page-if/page "destr-map" "when-do" lang)
             "when-do" (page-when-do/page "if" "if-let" lang)
             "if-let" (page-if-let/page "when-do" "error" lang)
             "error" (page-error/page "if-let" "cond" lang)
             "cond" (page-cond/page "error" "condp" lang)
             "condp" (page-condp/page "cond" "case" lang)
             "case" (page-case/page "condp" "loop" lang)
             "loop" (page-loop/page "case" "doseq" lang)
             "doseq" (page-doseq/page "loop" "for" lang)
             "for" (page-for/page "doseq" "while" lang)
             "while" (page-while/page "for" "partial" lang)
             "partial" (page-partial/page "while" "comp" lang)
             "comp" (page-comp/page "partial" "apply" lang)
             "apply" (page-apply/page "comp" "map" lang)
             "map" (page-map/page "apply" "filter" lang)
             "filter" (page-filter/page "map" "remove" lang)
             "remove" (page-remove/page "filter" "reduce" lang)
             "reduce" (page-reduce/page "remove" "thread-macro" lang)
             "thread-macro" (page-thread-macro/page "reduce" "atom" lang)
             "atom" (page-atom/page "thread-macro" "ref" lang)
             "ref" (page-ref/page "atom" "agent" lang)
             "agent" (page-agent/page "ref" "core-async" lang)
             "core-async" (page-core-async/page "agent" "more-thread" lang)
             "more-thread" (page-more-thread/page "agent" "namespaces" lang)
             "namespaces" (page-namespaces/page "more-thread" "macros" lang)
             "macros" (page-macros/page "namespaces" "repl" lang)
             "repl" (page-repl/page "macros" "ide" lang)
             "ide" (page-ide/page "repl" nil lang)
             )
           )))

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
