(ns tasks.Task26Tests
  (:require [clojure.test :refer [deftest is run-tests]]
            [tasks.Task26TailRec :refer [longest-recurring-cycle-tail]]
            [tasks.Task26Rec :refer [longest-recurring-cycle-rec]]  
            [tasks.Task26Module :refer [longest-recurring-cycle-module]]
            [tasks.Task26Map :refer [longest-recurring-cycle-map]]
            [tasks.Task26Loop :refer [longest-recurring-cycle-loop]]
            [tasks.Task26Inf :refer [longest-recurring-cycle-inf]]))

(deftest test-longest-recurring-cycle-tail
  (is (= (:d (longest-recurring-cycle-tail 1000)) 983)))

(deftest test-longest-recurring-cycle-rec
  (is (= (:d (longest-recurring-cycle-rec 1000)) 983)))

(deftest test-longest-recurring-cycle-module
  (is (= (:d (longest-recurring-cycle-module 1000)) 983)))

(deftest test-longest-recurring-cycle-map
  (is (= (:d (longest-recurring-cycle-map 1000)) 983)))

(deftest test-longest-recurring-cycle-loop
  (is (= (:d (longest-recurring-cycle-loop 1000)) 983)))

(deftest test-longest-recurring-cycle-inf
  (is (= (:d (longest-recurring-cycle-inf 1000)) 983)))

(run-tests)
