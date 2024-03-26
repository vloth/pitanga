(ns pitanga.body
  (:require [pitanga.scad :refer [render]]
            [pitanga.vars :refer [facets-number]]
            [scad-clj.model :as m]))

;; dead
;; (defn model []
;;   (m/minkowski
;;     (m/difference
;;       (m/with-fn 4 (m/cylinder [20 0] 20 :center false))
;;       ;; (m/minkowski
;;       ;;   (m/with-fn 4 (m/cylinder [20 0] 20 :center false))
;;       ;;   (m/sphere 3))
;;       (m/translate [0 0 20] (m/sphere 20)))
;;     (m/sphere 1)))

;; (defn model []
;;   (m/difference
;;     (m/with-fn 4 (m/cylinder [20 0] 20 :center false))
;;     ;; (m/minkowski
;;     ;;   (m/with-fn 4 (m/cylinder [20 0] 20 :center false))
;;     ;;   (m/sphere 3))
;;     (m/translate [0 0 20] (m/sphere 25))))

;; (defn main-body [s]
;;   [(m/intersection
;;     (m/color [0 0 0.25 0.5] ; b
;;              (m/translate [0 0 3] (m/sphere s)))
;;     (m/color [0 0.25 0 0.5] ; g
;;              (m/translate [s 0 3] (m/sphere s)))
;;     (m/color [0.25 0 0 0.5] ; r
;;              (m/translate [(/ s 2) 0 s] (m/sphere s)))
;;     (m/color [0.25 0.25 0 0.5] ; y
;;              (m/translate [(/ s 2) (/ s 2) s] (m/sphere s)))
;;     (m/color [0 0.25 0.25 0.5] ; bg
;;              (m/translate [(/ s 2) (- (/ s 2)) s] (m/sphere s))))])

;; (defn model []
;;   (m/call "polyRoundExtrude"
;;           [[10 0 0] [20 20 0] [8 7 0] [0 7 0] [5 3 0] [-4 0 0]]
;;           2
;;           0.5
;;           -0.9))

;; (defn model []
;;   (m/call "polyRoundExtrude"
;;           [[10 0 10] [20 20 1.1] [8 7 10] [0 7 0] [5 3 0.1] [-4 0 1]]
;;           2
;;           0.5
;;           -0.9))

;; (defn model []
;;   (m/difference
;;     (m/extrude-linear {:height 15 :center false :scale 0.1}
;;       (m/offset 5
;;         (m/square 10 10)))
;;     (m/translate [0 0 10] (m/sphere 10))))

(defn model []
  (m/difference
    (m/extrude-linear {:height 15 :center false :scale 0}
      (m/offset 5
        (m/square 10 10)))
    (m/translate [0 0 15] (m/cube 20 20 20))
    (m/translate [0 0 12] (m/sphere 10))))

; height
; rouding top
; rouding bottom / negative bleeds

(render [(m/fn! facets-number)
         (m/include "lib/round-anything/polyround.scad")
         (model)])
