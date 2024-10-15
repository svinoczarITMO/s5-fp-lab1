(ns tasks.Task26TailRec (:gen-class))

(defn length-of-repeating-cycle [d]
  (let [calculate-cycle (fn calculate-cycle [numerator index remainders]
          (let [new-remainder (mod numerator d)]
            (if (zero? new-remainder)
              0
              (if-let [seen-index (get remainders new-remainder)]
                (- index seen-index)
                (recur (* new-remainder 10) (inc index) 
                        (assoc remainders new-remainder index))))))]
    (calculate-cycle 1 0 {}))) 

(defn longest-repeating-cycle-tail [limit]
    (loop [d 2
           max-length 0
           result 0]
      (if (< d limit)
        (let [cycle-length (length-of-repeating-cycle d)]
          (if (> cycle-length max-length)
            (recur (inc d) cycle-length d)
            (recur (inc d) max-length result)))
        result)))

(longest-repeating-cycle-tail 1000)


;; Ответ: 983
;; Время выполнения (мс): 62