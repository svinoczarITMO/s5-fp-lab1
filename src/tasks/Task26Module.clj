(ns tasks.Task26Module (:gen-class))

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


(first (longest-repeating-cycle-module 1000))

;; Ответ: 983
;; Время выполнения (мс): 69