(ns tasks.Task5TailRec (:gen-class))

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

(lcm-tail (range 1 21))

;; Ответ: 232792560
;; Время выполнения (мс): 2