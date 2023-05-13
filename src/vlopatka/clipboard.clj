(ns vlopatka.clipboard)

(import [java.awt.datatransfer StringSelection])

(defn ^java.awt.datatransfer.Clipboard get-clipboard []
  (-> (java.awt.Toolkit/getDefaultToolkit)
      (.getSystemClipboard)))

(defn copy [text]
  (let [^java.awt.datatransfer.StringSelection selection (StringSelection. text)]
    (.setContents (get-clipboard) selection selection)))

(comment 
  (copy "vvv ttt"))

