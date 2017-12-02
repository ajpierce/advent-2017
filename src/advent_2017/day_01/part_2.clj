(ns advent-2017.day-01.part-2
  "Now, instead of considering the next digit, it wants you to consider the
  digit halfway around the circular list. That is, if your list contains 10
  items, only include a digit in your sum if the digit 10/2 = 5 steps forward
  matches it. Fortunately, your list has an even number of elements."
  (:require
    [advent-2017.day-01.core :as core :refer [split-and-test str->digits tests2]]))

(defn calculate [input]
  (let [code (str->digits input)
        len (count code)
        groups (partition (/ len 2) code)]
    (->> groups
         (map vec)
         (apply interleave)
         (partition 2)
         (filter (fn [[a b]] (= a b)))
         flatten
         (reduce +))))

(map #(split-and-test calculate %) tests2)
