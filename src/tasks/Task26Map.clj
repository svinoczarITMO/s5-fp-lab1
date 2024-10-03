(ns tasks.Task26Map (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn calculate-cycle-length [d]
  (loop [numerator 1 position 0 remainders {}]
    (if (zero? numerator)
      0
      (if-let [pos (get remainders numerator)]
        (- position pos)
        (recur (mod (* numerator 10) d) (inc position) (assoc remainders numerator position))))))

(defn longest-recurring-cycle-map [limit]
  (reduce (fn [longest d]
            (let [cycle-length (calculate-cycle-length d)]
              (if (> cycle-length (:length longest))
                {:length cycle-length :d d}
                longest)))
          {:length 0 :d 0}
          (range 2 limit)))

(println (:d (longest-recurring-cycle-map 1000)))

(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 983
;; Время выполнения (мс): 53