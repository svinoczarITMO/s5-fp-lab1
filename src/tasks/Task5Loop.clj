(ns tasks.Task5Loop (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn lcm-loop [n]
  (loop [acc 1 nums (range 1 (inc n))]
    (if (empty? nums)
      acc
      (recur (lcm acc (first nums)) (rest nums)))))

(println(lcm-loop 20))


(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 232792560
;; Время выполнения (мс): 4