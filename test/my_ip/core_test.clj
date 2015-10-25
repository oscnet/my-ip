(ns my-ip.core-test
  (:require [clojure.test :refer :all]
            [my-ip.core :refer :all]))

(deftest ip-test
  (testing "ip"
    (is (= true (ip? (my-ip))))))
