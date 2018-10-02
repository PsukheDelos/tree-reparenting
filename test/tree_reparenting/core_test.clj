(ns tree-reparenting.core-test
  (:require [clojure.test :refer :all]
            [tree-reparenting.core :refer :all]))

(deftest a-test
  (testing "Test Tree Reparenting."

    (is (= '(n)
           (reparent-tree 'n '(n))))

    (is (= '(a (t (e)))
           (reparent-tree 'a '(t (e) (a)))))

    (is (= '(e (t (a)))
           (reparent-tree 'e '(a (t (e))))))

    (is (= '(a (b (c)))
           (reparent-tree 'a '(c (b (a))))))

    (is (= '(d
              (b
                (c)
                (e)
                (a
                  (f
                    (g)
                    (h)))))
           (reparent-tree 'd '(a
                     (b
                       (c)
                       (d)
                       (e))
                     (f
                       (g)
                       (h))))))

    (is (= '(c
              (d)
              (e)
              (b
                (f
                  (g)
                  (h))
                (a
                  (i
                    (j
                      (k)
                      (l))
                    (m
                      (n)
                      (o))))))
           (reparent-tree 'c '(a
                     (b
                       (c
                         (d)
                         (e))
                       (f
                         (g)
                         (h)))
                     (i
                       (j
                         (k)
                         (l))
                       (m
                         (n)
                         (o)))))))
    ))
