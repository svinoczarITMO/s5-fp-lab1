(ns tasks.Task26Module (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn length-of-longest-repeating-cycle [d]
  (loop [numerator 1 remainders {} index 0]
    (let [remainder (mod numerator d)]
      (if (zero? remainder)
        0
        (if (contains? remainders remainder)
          (- index (remainders remainder))
          (recur (* remainder 10) (assoc remainders remainder index) (inc index)))))))

(defn longest-repeating-cycle-module [limit]
  (reduce (fn [acc d]
            (let [cycle-length (length-of-longest-repeating-cycle d)]
              (if (> cycle-length (second acc))
                [d cycle-length]
                acc)))
          [0 0] (range 2 limit)))


(println (first (longest-repeating-cycle-module 1000)))

(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 983
;; Время выполнения (мс): 69