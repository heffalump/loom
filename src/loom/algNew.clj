(in-ns 'loom.graph)


;; currently working on the function below; not finished
(defn pre-order-seq
  "Returns a sequence of vertices in depth-first pre-order.  The argument G may be
   a graph, digraph, or simply a function which takes a vertex and returns "
  [G start & {:keys [seen] :or {seen #{}}}]
  (letfn [(step [stack seen]
            (when-let [node (peek stack)]
              (cons node (lazy-seq (let [nbrs (remove seen (neighbors node))]
                                     (step (into (pop stack) nbrs)
                                           (into seen nbrs)))))))]
    
    (step [start] (conj seen start)))))
