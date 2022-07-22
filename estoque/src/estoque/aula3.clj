(ns estoque.aula3)

; PREDICATE
(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

 (defn valor-descontado
[valor-bruto]
(if (aplica-desconto? valor-bruto)
  (let [taxa-de-desconto (/ 10 100)
        desconto         (* valor-bruto taxa-de-desconto)]
    (println "CALCULANDO DESCONTO DE " desconto)
    (- valor-bruto desconto))
  valor-bruto))



(defn aplica?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (println "CALCULANDO DESCONTO DE " desconto)
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado aplica? 1000))
(println (valor-descontado aplica? 100))

(println "Função sem nome, é uma função anonima")
(fn [valor-bruto] (> valor-bruto 100))
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 1000))
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 100))

; Quanto mais comprimido o código, maior a complexidade
(println (valor-descontado (fn [v] (> v 100)) 1000))
(println (valor-descontado (fn [v] (> v 100)) 100))

; As vezes chamado de lambda
(println (valor-descontado #(> %1 100) 1000))
(println (valor-descontado #(> %1 100) 100))

(println (valor-descontado #(> % 100) 1000))
(println (valor-descontado #(> % 100) 100))



