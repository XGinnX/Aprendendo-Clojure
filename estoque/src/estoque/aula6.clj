(ns estoque.aula6)

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             })

(defn imprime-e-15 [valor]
  (println "Valor" (class valor) valor)
  15)

(println (map imprime-e-15 pedido))

; Os parametros definidos são dois valores
; (defn imprime-e-15 [chave valor]
; (println chave "e" valor)
;  15)
;(println (map imprime-e-15 pedido))

(defn imprime-e-15 [[chave valor]]
  (println chave "<e>" valor)
  15)
(println (map imprime-e-15 pedido))

(defn preco-dos-produtos
  [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
; Utiliza o map pra passar por todos os pedidos buscando o valor total de cada um e somando
(println "TOTAL" (reduce + (map preco-dos-produtos pedido)))

; Formas de definir o total do pedido
; 1ª forma
(defn total-do-pedido
  [pedido]
  (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))


(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

;2ª forma THREAD LAST
(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +))
  (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))

; THEAD FIRST (->) LAST (->>)

(def pedido {:mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1}
             })

; Variações de filtragem
(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))
(println "Filtrando gratuitos Variação 1")
(println (filter gratuito? (vals pedido)))


(defn gratuito?
  [[_ item]]
  (<= (get item :preco 0) 0))

(println "Filtrando gratuitos Variação 2")
(println (filter gratuito? pedido))

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println "Filtrando gratuitos")
(println (filter (fn [[chave item]] (gratuito? item)) pedido))

(println (filter #(gratuito? (second %)) pedido))


(defn pago?
  [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))
(println (pago? {:preco 0}))

(println ((comp not gratuito?) {:preco 50}))

(def pago? (comp not gratuito?))
(println (pago? {:preco 50}))
(println (pago? {:preco 0}))
