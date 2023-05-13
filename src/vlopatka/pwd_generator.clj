(ns vlopatka.pwd-generator
  (:require [vlopatka.password :refer [generate-password]]
            [vlopatka.clipboard :refer [copy]]
            [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def cli-options
  [["-l" "--length LENGTH" "Password length"
    :default 12
    :parse-fn #(Integer/parseInt %)
    :validate [#(< 0 % 100) "Must be a number between 0 and 100"]] 
   ["-h" "--help"]])

(defn generate-new-password [length]
  (let [pwd (generate-password length)]
    (copy pwd)
    (println pwd)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [arguments (parse-opts args cli-options)
        options (:options arguments)
        summary (:summary arguments)]
    
    (if (:help options)
      (println summary)
      (generate-new-password (:length options)))))

