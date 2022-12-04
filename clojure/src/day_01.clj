(ns day_01
  (:require
    [clojure.string :as str]
    [utils :as aoc]))

(def input (aoc/read-file 1))
(def example "1000
2000
3000

4000

5000
6000

7000
8000
9000

10000")


(defn sum-elf [elf]
  (reduce + (map aoc/to-int (str/split elf #"\n"))))


(defn part-1 [input]
  (->>
    (str/split input #"\n\n")
    (map sum-elf)
    (apply max))
  )

(defn part-2 [input]
  (->>
    (str/split input #"\n\n")
    (map sum-elf)
    (sort)
    (take-last 3)
    (apply +))
  )


(part-1 input)
(part-2 input)

