(ns tasks.Task5TailRec (:gen-class))

(let [start-time (System/currentTimeMillis)]

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn lcm-tail [nums]
  (let [lcm-helper (fn lcm-helper [acc nums]
                     (if (empty? nums)
                       acc
                       (recur (lcm acc (first nums)) (rest nums))))]
    (lcm-helper 1 nums)))

(println (lcm-tail (range 1 21)))


(let [end-time (System/currentTimeMillis)
    duration (- end-time start-time)]
(println "Время выполнения (мс):" duration)))


;; Ответ: 232792560
;; Время выполнения (мс): 2