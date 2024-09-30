(ns tasks.Task26Loop (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn calculate-cycle-length [d]
  (loop [numerator 1 position 0 remainders {}]
    (if (zero? numerator)
      0
      (if-let [pos (get remainders numerator)]
        (- position pos)
        (recur (mod (* numerator 10) d) (inc position) (assoc remainders numerator position))))))

(defn longest-recurring-cycle-loop [limit]
  (let [results (for [d (range 2 limit)]
                  [d (calculate-cycle-length d)])]
    (reduce (fn [longest [d cycle-length]]
              (if (> cycle-length (:length longest))
                {:length cycle-length :d d}
                longest))
            {:length 0 :d 0}
            results)))

(println (:d (longest-recurring-cycle-loop 1000)))


(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 983
;; Время выполнения (мс): 57