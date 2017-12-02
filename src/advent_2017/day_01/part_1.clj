(ns advent-2017.day-01.part-1
  "The captcha requires you to review a sequence of digits (your puzzle input)
  and find the sum of all digits that match the next digit in the list. The list
  is circular, so the digit after the last digit is the first digit in the list."
  (:require
    [advent-2017.day-01.core :as core :refer [split-and-test str->digits tests1]]))

(defn get-digits [input]
  (->> input
       str->digits
       ((fn [xs] (map vector xs (rest (cycle xs)))))
       (filter (fn [[a b]] (= a b)))
       (map first)))

(defn calculate [input]
  (->> input
       get-digits
       (reduce +)))

(map #(split-and-test calculate %) tests)
