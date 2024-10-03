(ns tasks.Task5Inf (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn smallest-multiple-inf [n]
  (some (fn [current]
          (when (every? #(zero? (mod current %)) (range 1 (inc n)))
            current))
        (iterate inc 1)))

(println (smallest-multiple-inf 20))

(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 232792560
;; Время выполнения (мс): 13896