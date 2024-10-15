(ns tasks.Task26Rec (:gen-class))


(defn length-of-repeating-cycle [d]
  (letfn [(recur-helper [numerator remainders index]
            (let [new-remainder (mod numerator d)]
              (if (zero? new-remainder)
                0
                (if-let [seen-index (get remainders new-remainder)]
                  (- index seen-index)
                  (recur-helper (* new-remainder 10) 
                    (assoc remainders new-remainder index) (inc index))))))]
    (recur-helper 1 {} 0)))

(defn longest-repeating-cycle-recur [limit]
    (loop [d 2 max-length 0 result 0]
      (if (< d limit)
        (let [cycle-length (length-of-repeating-cycle d)]
          (if (> cycle-length max-length)
            (recur (inc d) cycle-length d)
            (recur (inc d) max-length result)))
        result)))

(longest-repeating-cycle-recur 1000)


;; Ответ: 983
;; Время выполнения (мс): 59