(ns advent-2017.day-01.part-2
  "Now, instead of considering the next digit, it wants you to consider the 
  digit halfway around the circular list. That is, if your list contains 10 
  items, only include a digit in your sum if the digit 10/2 = 5 steps forward 
  matches it. Fortunately, your list has an even number of elements.")

; Test values (and answers) presented in the problem text
(def tests [[1212 6] 
            [1221 0] 
            [123425 4] 
            [12131415 4] 
            [123123 12]])

(defn get-pairs [input]
  (let [code (->> input str seq)
        len (count code)
        groups (partition (/ len 2) code)]
  (->> groups
       (map vec)
       (apply interleave)
       (partition 2)
       (filter (fn [[a b]] (= a b))) )))

(defn sum-pairs [pairs]
  (->> pairs
       flatten
       (map #(Character/digit % 10))
       (reduce +) ))

(defn calculate [code] (->> code get-pairs sum-pairs))

(defn split-and-test [[code expected]]
  (let [actual (calculate code)
        match? (= expected actual)]
    (println "Does" code "yield" expected "?" match?)))

(map split-and-test tests)
