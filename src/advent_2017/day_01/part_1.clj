(ns advent-2017.day-01.part-1
  "The captcha requires you to review a sequence of digits (your puzzle input) 
  and find the sum of all digits that match the next digit in the list. The list 
  is circular, so the digit after the last digit is the first digit in the list.")

; Test values (and answers) presented in the problem text
(def tests [[1122 3] 
            [1111 4] 
            [1234 0] 
            [91212129 9]])

(defn get-pairs [input]
  (let [a (->> input str seq vec)
        b (conj (subvec a 1) (first a))]
    (->> b (concat a) (partition 2))))

(defn filter-pairs [pairs]
  (filter (fn [[a b]] (= a b)) pairs))

(defn sum-pairs [pairs]
  (->> pairs
       (map first)
       (map #(Character/digit % 10))
       (reduce +)))

(defn calculate [code] (->> code get-pairs filter-pairs sum-pairs))

(defn split-and-test [[code expected]]
  (let [actual (calculate code)
        match? (= expected actual)]
    (println "Does" code "yield" expected "?" match?)))

(map split-and-test tests)
