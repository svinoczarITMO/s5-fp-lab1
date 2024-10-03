(ns tasks.Task5Rec (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn smallest-multiple-rec [n]
  (letfn [(helper [current max]
            (if (= current max)
              (reduce lcm 1 (range 1 (inc max)))
              (if (every? #(zero? (mod current %)) (range 1 (inc n)))
                current
                (recur (inc current) max))))]
    (helper 1 n)))

(println (smallest-multiple-rec 20))


(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 232792560
;; Время выполнения (мс): 3