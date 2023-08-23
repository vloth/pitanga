(ns core
  (:require [pitanga.scad :refer [render]]
            [scad-clj.model :as m]))

(def facets-number 100)

(def trackball-radius 17)
(def support-radius 2)
(def spacing-factor -0.01)
(def z-position-deg -30)

(defn support-location
  [angle]
  [(* (Math/cos (m/deg->rad angle)) (+ trackball-radius (* support-radius spacing-factor)))
   (* (Math/sin (m/deg->rad angle)) (+ trackball-radius (* support-radius spacing-factor)))
   (* (Math/sin (m/deg->rad z-position-deg)) trackball-radius)])

(defn support-spheres []
  (->> [0 120 240]
       (map #(m/translate (support-location %)
                          (m/sphere support-radius)))))

(defn model []
  (m/union
   (m/sphere trackball-radius)
   (support-spheres)))

(render [(m/fn! facets-number)
         (model)])
