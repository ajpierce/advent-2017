(ns advent-2017.day-02.core
  (:require [clojure.java.io :as io]
            [clojure.string :as s] ))

(defn read-input [filename]
  (-> filename io/resource io/file slurp))

(defn parse-row [raw]
  (->> raw
       (re-seq #"\d+")      ; Split on all groups of digits
       (map read-string)))  ; Cast strings to numbers

(defn make-rows [filename]
  (->> filename
       read-input
       (#(s/split % #"\n"))
       (map parse-row)))
