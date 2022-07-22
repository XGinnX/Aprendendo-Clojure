(ns estoque.aula5)

(def estoque {"Mochila" 10, "Camiseta"5})
(println estoque)

(println "Temos" (count estoque) "Elementos")

(println "Chaves são: " (keys estoque))
(println "Valores são: " (vals estoque))

; :keyword
; :mochila
(def estoque {:mochila 10
               :camiseta 5})
; Assoc associa uma chave e um valor
(println (assoc estoque :cadeira 3))

(println (update estoque :mochila inc))

(defn tira-um
   [valor]
  (println "Tirando um de " valor)
  (- valor 1))

(println (update estoque :mochila tira-um))

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             })
(println "-----------------------------")
(println pedido)
(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))
(println pedido)

(println (pedido :mochila))
(println (get pedido :mochila))

(println (get pedido :cadeira))
(println (get pedido :cadeira 0))
(println (get pedido :cadeira {}))

; Como acessar a chave dentro da chave
(println (:quantidade (:mochila pedido)))

(println (update-in pedido [:mochila :quantidade] inc))

;THREADING FIRST
;1. Forma  acessar os pedidos
(println (-> pedido
             :mochila
             :quantidade))
;2. Forma
(-> pedido
    :mochila
    :quantidade
    println)

;pedido.get (mochila).get (quantidade)