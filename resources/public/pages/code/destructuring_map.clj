;; map destructuring
(let [{f1 :f1 f2 :f2 f3 :f3} {:f1 1 :f2 2 :f3 3}]
  (println "f :" f1 f2 f3 "\n"))

;; you can use :keys to have a more concise syntax
(let [{:keys [s1 s2 s3 s4]} {:s1 100 :s2 200 :s3 300}]
  (println "s :" s1 s2 s3 s4 "\n"))

;; you can use :as to get the full value
(let [{b1 :b1 :as bmap} {:b1 "b1value" :b2 "b2value"}]
  (println "b :" b1 bmap "\n"))

;; again, you can destructure nested maps
(let [{{:keys [t1 t2]} :z} {:z {:t1 "t1value" :t2 "t2value"}}]
  (println "t :" t1 t2 "\n"))

;; you can use :or to set default value of a key does not exists
(let [{a1 :a1 a2 :a2 :or {a1 "default-value"}} {:a2 "a2"}]
  (println "a :" a1 a2 "\n"))

;; destructuring works on function arguments!
(defn say-hello
  [{:keys [first-name last-name]}]
  (str "Hello " first-name " " last-name))

(println (say-hello {:first-name "Mark" :last-name "\"The Shark\" Shelton"}))

