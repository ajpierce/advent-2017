(ns advent-2017.day-02.part-1
  (:require [advent-2017.day-02.core :refer [make-rows]]
            [advent-2017.day-01.core :refer [str->digits]]))

(defn calc-checksum [row]
  (- (apply max row) (apply min row)))

(->> "02.dat"
     make-rows
     (map calc-checksum)
     (reduce +))
