(let [start-time (System/currentTimeMillis)]

(defn gcd [a b] ;; НОД
  (if (zero? b)
    a
    (recur b (mod a b))))  

(defn lcm [a b] ;; НОК
  (/ (* a b) (gcd a b)))  

(defn lcm-for-range [start end]
  (reduce lcm start (range start end)))

(let [result (lcm-for-range 11 21)]
  (println result))

(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 232792560
;; Среднее время выполнения (в мс): 1.8