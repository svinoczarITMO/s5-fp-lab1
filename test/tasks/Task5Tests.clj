(ns tasks.Task5Tests
  (:require [clojure.test :refer [deftest is run-tests]]
            [tasks.Task5TailRec :refer [lcm-tail]]  
            [tasks.Task5Rec :refer [lcm-recur]]      
            [tasks.Task5Module :refer [lcm-module]]   
            [tasks.Task5Map :refer [lcm-map]]      
            [tasks.Task5Loop :refer [lcm-loop]]     
            [tasks.Task5Inf :refer [lcm-inf]]))     

(deftest test-lcm-tail
  (is (= (lcm-tail (range 1 21)) 232792560)))

(deftest test-lcm-recur
  (is (= (lcm-recur (range 1 21)) 232792560)))

(deftest test-lcm-module
  (is (= (lcm-module 20) 232792560)))

(deftest test-lcm-map
  (is (= (lcm-map 20) 232792560)))

(deftest test-lcm-loop
  (is (= (lcm-loop 20) 232792560)))

(deftest test-lcm-inf
  (is (= (lcm-inf 20) 232792560)))

(run-tests)