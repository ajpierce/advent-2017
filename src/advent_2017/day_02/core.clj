(ns advent-2017.day-02.core
  (:require [clojure.java.io :as io]
            [clojure.string :as s]
            [advent-2017.day-01.core :refer [str->digits]]))

(defn read-input [filename]
  (-> filename io/resource io/file slurp))

(defn make-rows [filename]
  (-> filename
      read-input
      (s/split #"\s") ))
