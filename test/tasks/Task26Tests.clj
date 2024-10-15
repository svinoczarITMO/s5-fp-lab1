(ns tasks.Task26Tests
  (:require [clojure.test :refer [deftest is run-tests]]
            [tasks.Task26TailRec :refer [longest-repeating-cycle-tail]]
            [tasks.Task26Rec :refer [longest-repeating-cycle-recur]]  
            [tasks.Task26Module :refer [longest-repeating-cycle-module]]
            [tasks.Task26Map :refer [longest-repeating-cycle-map]]
            [tasks.Task26Loop :refer [longest-repeating-cycle-loop]]))

(deftest test-longest-repeating-cycle-tail
  (is (= (longest-repeating-cycle-tail 1000) 983)))

(deftest test-longest-repeating-cycle-recur
  (is (= (longest-repeating-cycle-recur 1000) 983)))

(deftest test-longest-repeating-cycle-module
  (is (= (first (longest-repeating-cycle-module 1000)) 983)))

(deftest test-longest-repeating-cycle-map
  (is (= (longest-repeating-cycle-map 1000) 983)))

(deftest test-longest-repeating-cycle-loop
  (is (= (longest-repeating-cycle-loop 1000) 983)))

(run-tests)