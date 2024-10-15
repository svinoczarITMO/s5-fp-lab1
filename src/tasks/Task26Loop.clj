(ns tasks.Task26Loop (:gen-class))

(defn length-of-longest-repeating-cycle [d]
  (loop [numerator 1 remainders {} index 0]
    (let [new-remainder (mod numerator d)]
      (if (zero? new-remainder)
        0
        (if (contains? remainders new-remainder)
          (- index (remainders new-remainder))
          (recur (* new-remainder 10) (assoc remainders new-remainder index) (inc index)))))))

(defn longest-repeating-cycle-loop [limit]
  (loop [d 2 max-length 0 result 0]
    (if (< d limit)
      (let [cycle-length (length-of-longest-repeating-cycle d)]
        (if (> cycle-length max-length)
          (recur (inc d) cycle-length d)
          (recur (inc d) max-length result)))
      result)))


(longest-repeating-cycle-loop 1000)

;; Ответ: 983
;; Время выполнения (мс): 55