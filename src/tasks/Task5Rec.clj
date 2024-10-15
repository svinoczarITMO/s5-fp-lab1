(ns tasks.Task5Rec (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn lcm-recur [nums]
  (if (= (count (seq nums)) 1)
    (first nums)
    (lcm (first nums) (lcm-recur (rest nums)))))


(println (lcm-recur (range 1 21)))


(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 232792560
;; Время выполнения (мс): 4