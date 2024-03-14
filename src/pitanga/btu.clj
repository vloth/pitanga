(ns pitanga.btu
  (:require [pitanga.scad :refer [render]]
            [pitanga.vars :refer [facets-number support-radius]]
            [scad-clj.model :as m]))

(do (def L  12)
    (def L1 0.9)
    (def H  1)   ; approximate
    (def D  3.5)
    (def D2 6)
    (def S  3)
    (def t  2.5)
    (def inner-tol 0.2)
    (def -cbtuh (- support-radius L1 H)))

(defn countersunk
  []
  (m/extrude-rotate {:angle 360}
                    (m/polygon [[0 0] [(/ D2 2) 0] [(/ D 2) H] [0 H]])))

(defn mkey
  []
  (m/extrude-linear {:height (+ t inner-tol)} (m/with-fn 5 (m/circle (/ S 2)))))

(defn body
  []
  (m/difference
   (m/extrude-linear {:height (- L L1 H)} (m/circle (/ D2 2)))
   (m/translate [0 0 (- (+ (/ (- (- L L1 H) t) 2) (/ inner-tol 2)))] (mkey))))

(defn model
  []
  (m/union (m/translate [0 0 -cbtuh] (countersunk))
           (m/translate [0 0
                         (-> (- L L1 H)
                             (/ 2)
                             (- -cbtuh)
                             -)]
                        (body))
           (m/sphere support-radius)))

(render [(m/fn! facets-number) (model)])
