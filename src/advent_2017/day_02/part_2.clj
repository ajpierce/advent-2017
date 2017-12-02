(ns advent-2017.day-02.part-2
  (:require [advent-2017.day-02.core :refer [make-rows]]))

(defn calc-checksum [row]
  (for [x row
        y row
        :when (and (<= y (/ x 2))
                   (= 0 (mod x y)))]
    (/ x y)))

(->> "02.dat"
     make-rows
     (map calc-checksum)
     flatten
     (reduce +))
