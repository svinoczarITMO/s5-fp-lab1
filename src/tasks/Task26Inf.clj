(ns tasks.Task26Inf (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn calculate-cycle-length [d]
  (let [remainders (atom {})
        numerator (atom 1)
        position (atom 0)]
    (loop []
      (if (zero? @numerator)
        0
        (if-let [pos (get @remainders @numerator)]
          (- @position pos)
          (do
            (swap! remainders assoc @numerator @position)
            (swap! numerator #(mod (* % 10) d))
            (swap! position inc)
            (recur)))))))

(defn longest-recurring-cycle-inf [limit]
  (reduce (fn [longest d]
            (let [cycle-length (calculate-cycle-length d)]
              (if (> cycle-length (:length longest))
                {:length cycle-length :d d}
                longest)))
          {:length 0 :d 0}
          (range 2 limit)))

(println (:d (longest-recurring-cycle-inf 1000)))



(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 983
;; Время выполнения (мс): 86