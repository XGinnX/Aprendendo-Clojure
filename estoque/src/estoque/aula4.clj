(ns estoque.aula4)

(def precos [30 700 1000])

(println (precos 0))
;Fução get faz o tratamento do vetor
(println (get precos 0))
(println (get precos 2))
(println (get precos 17))

;Update altera o valor da posição solucionado, não do vetor origal
(println (update precos 0 inc))

(println (update precos 0 dec))

(defn soma-3
  [valor]
  (println "estou somando 3 em" valor)
  (+ valor 3))

(println (update precos 0 soma-3))

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

;MAP passa por todas as posições do vetor
(println(map valor-descontado precos))

(println (range 10))
;Filter passa por cada elemento, e verifica se é verdadeiro, caso seja mantem o numero
(println (filter even? (range 10)))

(println "vetor trabalhado" precos)
(println "filter" (filter aplica-desconto? precos))
; utilizando o MAP apos o filter
(println "map apos o filter" (map valor-descontado (filter aplica-desconto? precos)))
;Soma os numeros do vetor
(println (reduce + precos))

(defn minha-soma
  [valor-1 valor-2]
  (println "somando" valor-1 valor-2)
  (+ valor-1 valor-2)
  )
(println (reduce minha-soma precos))

(println (reduce minha-soma (range 10)))
(println (reduce minha-soma [15]))
(println (reduce minha-soma [15]))
(println (reduce minha-soma 0 precos))
(println (reduce minha-soma 0 precos))
; retorna um erro, por não passarmos nenhum valor
(println (reduce minha-soma []))