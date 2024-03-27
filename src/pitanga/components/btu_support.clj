(ns pitanga.components.btu-support
  (:require [pitanga.scad :refer [render]]
            [pitanga.vars :refer [facets-number]]
            [scad-clj.model :as m]))

(defn countersunk
  [{:keys [top-w countersunk-h bottom-w]}]
  (->> [[0 0] [(/ bottom-w 2) 0] [(/ top-w 2) countersunk-h] [0 countersunk-h]]
       (m/polygon)
       (m/extrude-rotate {:angle 360})))

(defn countersunk->
  [{:keys [r ball-out-h countersunk-h]}]
  [0 0 (- r ball-out-h countersunk-h)])

(defn hex
  [{:keys [inner-t hex-d hex-w]}]
  (->> (m/with-fn 6 (m/circle (/ hex-w 2)))
       (m/extrude-linear {:height (+ hex-d inner-t)})))

(defn hex->
  [{:keys [inner-t hex-d h ball-out-h countersunk-h]}]
  [0 0 (- (+ (/ (- (- h ball-out-h countersunk-h) hex-d) 2) (/ inner-t 2)))])

(defn thread
  [{:keys [h countersunk-h ball-out-h]}]
  (m/call "ScrewThread" 6 (- h ball-out-h countersunk-h)))

(defn thread->
  [{:keys [h countersunk-h ball-out-h]}]
  [0 0 (/ (- (- h ball-out-h countersunk-h)) 2)])

(defn thread-body
  [params]
  (m/difference
   (m/translate (thread-> params) (thread params))
   (m/translate (hex-> params) (hex params))))

(defn thread-body->
  [{:keys [r h ball-out-h countersunk-h]}]
  [0 0 (-> (- h ball-out-h countersunk-h)
           (/ 2)
           (- (- r ball-out-h countersunk-h))
           -)])

(def default-params
  {:top-w         3.5
   :bottom-w      6
   :countersunk-h 1
   :inner-t       0.2
   :hex-d         2.5
   :hex-w         3
   :h             12
   :r             1.59
   :ball-out-h    0.9})

(defn btu-support
  ([] (btu-support default-params))
  ([{:keys [:r] :as params}]
   (m/union (m/translate (countersunk-> params) (countersunk params))
            (m/translate (thread-body-> params) (thread-body params))
            (m/sphere r))))

(comment
  (render [(m/fn! facets-number)
           (m/use "lib/threads-scad/threads.scad")
           (btu-support)]))
