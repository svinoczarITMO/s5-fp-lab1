(ns tasks.Task26Map (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn length-of-longest-repeating-cycle [d]
  (loop [n 1 rem 1 seen {} idx 0]
    (if (zero? rem)
      0
      (if (contains? seen rem)
        (- idx (seen rem))
        (recur (inc n) (mod (* rem 10) d) (assoc seen rem idx) (inc idx))))))

(defn longest-repeating-cycle-map [limit]
  (let [lengths (map length-of-longest-repeating-cycle (range 2 limit))]
    (first (reduce (fn [m len] 
                     (if (> (second len) (second m))
                       len 
                       m))
                   [0 0]
                   (map vector (range 2 limit) lengths)))))


(println (longest-repeating-cycle-map 1000))

(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 983
;; Время выполнения (мс): 52