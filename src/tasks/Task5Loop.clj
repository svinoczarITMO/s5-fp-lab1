(ns tasks.Task5Loop (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn smallest-multiple-loop [n]
  (loop [current 1
         found false]
    (if found
      current
      (let [divisible? (every? #(zero? (mod current %)) (range 1 (inc n)))]
        (recur (inc current) (if divisible? true found))))))

(println (smallest-multiple-loop 20))

(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 232792560
;; Время выполнения (мс): 8695