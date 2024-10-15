(ns tasks.Task5Module (:gen-class))

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn generate [n]
  (range 1 (inc n)))

(defn filter-lcm [nums]
  (reduce lcm 1 nums))

(defn lcm-module [n]
  (-> (generate n)
      (filter-lcm)))

(lcm-module 20)

;; Ответ: 232792560
;; Время выполнения (мс): 2