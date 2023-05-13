(ns vlopatka.password)

(def available-chars (reduce (fn [acc val] 
                               (str acc (char val))) "" (range 33 123)))

(defn generate-password [length]
  (loop [password ""]
    (if (= (count password) length)
     password
     (recur (str password (rand-nth available-chars))))))
