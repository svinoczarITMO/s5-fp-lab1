(ns tasks.Task5TailRec (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn smallest-multiple-tail [n]
  (loop [multiple 1]
    (if (every? #(zero? (mod multiple %)) (range 1 (inc n)))
      multiple
      (recur (inc multiple)))))

(println (smallest-multiple-tail 20))


(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 232792560
;; Время выполнения (мс): 21118