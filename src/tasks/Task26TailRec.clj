(ns tasks.Task26TailRec (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn calculate-cycle-length [d]
  (loop [numerator 1
         position 0
         remainders {}]
    (if (zero? numerator)
      0
      (if-let [pos (get remainders numerator)]
        (- position pos)
        (recur (mod (* numerator 10) d) (inc position) (assoc remainders numerator position))))))

(defn longest-recurring-cycle-tail [limit]
  (loop [d 2
         longest {:length 0 :d 0}]
    (if (>= d limit)
      longest
      (let [cycle-length (calculate-cycle-length d)
            new-longest (if (> cycle-length (:length longest))
                          {:length cycle-length :d d}
                          longest)]
        (recur (inc d) new-longest)))))

(println (:d (longest-recurring-cycle-tail 1000)))



(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 983
;; Время выполнения (мс): 60