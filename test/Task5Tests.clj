(ns Task5Tests
  (:require [clojure.test :refer [deftest is run-tests]]
            [tasks.Task5TailRec :refer [smallest-multiple-tail]]  ; Хвостовая рекурсия
            [tasks.Task5Rec :refer [smallest-multiple-rec]]      ; Рекурсия
            [tasks.Task5Module :refer [smallest-multiple-module]]   ; Модульное решение
            [tasks.Task5Map :refer [smallest-multiple-map]]      ; Использование map
            [tasks.Task5Loop :refer [smallest-multiple-loop]]     ; Циклическое решение
            [tasks.Task5Inf :refer [smallest-multiple-inf]]))     ; Бесконечная последовательность))

(deftest test-smallest-multiple-tail
  (is (= (smallest-multiple-tail 20) 232792560)))

(deftest test-smallest-multiple-rec
  (is (= (smallest-multiple-rec 20) 232792560)))

(deftest test-smallest-multiple-module
  (is (= (smallest-multiple-module 20) 232792560)))

(deftest test-smallest-multiple-map
  (is (= (smallest-multiple-map 20) 232792560)))

(deftest test-smallest-multiple-loop
  (is (= (smallest-multiple-loop 20) 232792560)))

(deftest test-smallest-multiple-inf
  (is (= (smallest-multiple-inf 20) 232792560)))

(run-tests)
