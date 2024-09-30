(ns tasks.Task26Rec (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn calculate-cycle-length [d numerator position remainders]
  (if (zero? numerator)
    0
    (if-let [pos (get remainders numerator)]
      (- position pos)
      (calculate-cycle-length d (mod (* numerator 10) d) (inc position) (assoc remainders numerator position)))))

(defn longest-recurring-cycle-rec [limit]
  (letfn [(helper [d longest]
            (if (>= d limit)
              longest
              (let [cycle-length (calculate-cycle-length d 1 0 {})
                    new-longest (if (> cycle-length (:length longest))
                                  {:length cycle-length :d d}
                                  longest)]
                (helper (inc d) new-longest))))]
    (helper 2 {:length 0 :d 0})))

(println (:d (longest-recurring-cycle-rec 1000)))


(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 983
;; Время выполнения (мс): 63