(ns core
  (:require [pitanga.scad :refer [render]]
            [pitanga.vars :refer [facets-number spacing-factor support-radius
                                  trackball-radius z-position-deg]]
            [scad-clj.model :as m]))

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
