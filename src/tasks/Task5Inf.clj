(ns tasks.Task5Inf (:gen-class))

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn lcm-inf [n]
  (let [nums (take n (iterate inc 1))]
    (reduce lcm 1 nums)))

(lcm-inf 20)


;; Ответ: 232792560
;; Время выполнения (мс): 2