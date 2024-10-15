(ns tasks.Task26TailRec (:gen-class))

(let [start-time (System/currentTimeMillis)]

  (defn length-of-repeating-cycle [d]
    (let [remainders (atom {})
          calculate-cycle (fn calculate-cycle [numerator index]
                            (let [new-remainder (mod numerator d)]
                              (if (zero? new-remainder)
                                0
                                (if-let [seen-index (get @remainders new-remainder)]
                                  (- index seen-index)
                                  (do
                                    (swap! remainders assoc new-remainder index)
                                    (recur (* new-remainder 10) (inc index)))))))]
      (calculate-cycle 1 0))) ;; убедитесь, что здесь правильно закрыты все скобки

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

  (println (longest-repeating-cycle-tail 1000))

  (let [end-time (System/currentTimeMillis)
        duration (- end-time start-time)]
    (println "Время выполнения (мс):" duration)))




;; Ответ: 983
;; Время выполнения (мс): 62