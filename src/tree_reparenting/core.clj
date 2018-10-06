(ns tree-reparenting.core)

(defn reparent-tree
  "Grab one node of a tree and drag it up to the root position, leaving all connections intact."
  [new-root tree]
  (reduce
    (fn [first second]
      (concat second
              (list (remove (partial = second) first))))
    (filter #(and (seq? %) (some (fn [x] (= x new-root)) (flatten %)))
            (tree-seq seq? seq tree))))
