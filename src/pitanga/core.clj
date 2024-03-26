(ns core
  (:require [pitanga.btu :refer [btu]]
            [pitanga.scad :refer [render]]
            [pitanga.vars :refer [facets-number spacing-factor support-radius
                                  trackball-radius z-position-deg]]
            [scad-clj.model :as m]))

(defn support-location
  [angle]
  [(* (Math/cos (m/deg->rad angle)) (+ trackball-radius (* support-radius spacing-factor)))
   (* (Math/sin (m/deg->rad angle)) (+ trackball-radius (* support-radius spacing-factor)))
   (* (Math/sin (m/deg->rad z-position-deg)) trackball-radius)])

(defn support-spheres []
  (map
   (fn [angle]
     (m/translate
      (support-location angle)
      (m/rotate [0 (m/deg->rad -60) (m/deg->rad angle)] (btu))))
   [0 120 240]))

(defn model []
  (m/union
   (m/sphere trackball-radius)
   (support-spheres)))

(render [(m/fn! facets-number)
         (m/use "lib/threads-scad/threads.scad")
         (model)])
