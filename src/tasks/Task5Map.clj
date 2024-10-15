(ns tasks.Task5Map (:gen-class))

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn lcm-map [n]
  (reduce lcm 1 (map identity (range 1 (inc n)))))

(lcm-map 20)

;; Ответ: 232792560
;; Время выполнения (мс): 2