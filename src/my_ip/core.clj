(ns my-ip.core
  (:use [net.cgrand.enlive-html]))


(defn ip?
  "check it is ip address?"
  [ip]
  (boolean (re-matches
            #"^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$"
            ip)))

(defn my-ip
  "get the public IP address of your computer"
  []
  (->
   "http://www.ip.cn"
   clojure.java.io/as-url
   html-resource
   (select [:div#result :code])
   first
   :content
   first))
