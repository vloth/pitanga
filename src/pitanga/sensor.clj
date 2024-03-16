(ns pitanga.sensor
  (:require [pitanga.scad :refer [render]]
            [pitanga.vars :refer [facets-number]]
            [scad-clj.model :as m]
            [scad-clj.scad :refer [indent write-expr]]))

;;  overwrites
(defmethod write-expr :import [depth [_form file]]
  (list (indent depth) "import (\"" file "\", center=true);\n"))

(defn sensor []
  (m/difference (m/import "svg/sensor-board-outline.svg")
                (m/import "svg/sensor-mount.svg")
                (m/import "svg/sensor-pmw.svg")))

(render [(m/fn! facets-number)
         (m/color [0 0.5 0.255]
                  (m/translate [0 18.5 0]
                               (m/extrude-linear {:height 2} (m/circle 1.6))))
         (m/color [0 0.5 0.255]
                  (m/translate [0 -18.5 0] (m/extrude-linear {:height 2} (m/circle 1.6))))
         (m/color [0.255 0 0 0.4] (sensor))])
