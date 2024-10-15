(ns tasks.Task5Rec (:gen-class))

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(defn lcm-recur [nums]
  (if (= (count (seq nums)) 1)
    (first nums)
    (lcm (first nums) (lcm-recur (rest nums)))))


(lcm-recur (range 1 21))

;; Ответ: 232792560
;; Время выполнения (мс): 4