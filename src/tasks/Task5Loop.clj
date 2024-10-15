(ns tasks.Task5Loop (:gen-class))

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn lcm-loop [n]
  (loop [acc 1 nums (range 1 (inc n))]
    (if (empty? nums)
      acc
      (recur (lcm acc (first nums)) (rest nums)))))

(lcm-loop 20)

;; Ответ: 232792560
;; Время выполнения (мс): 4