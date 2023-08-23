(ns pitanga.scad
  (:require [scad-clj.scad :refer [write-scad]]))

(defn render [m]
  (spit "render.scad" (write-scad m)))
