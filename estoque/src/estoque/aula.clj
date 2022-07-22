(ns estoque.aula)
; Print inicial - Olá mundo
(println "Hello World")

; Para chamar a função utilizamos o () - Parenteses


; Definindo um valor - def nome-variavel valor
(def total-de-produtos 15)

; Para exibir é necessario utilizar a função de printar
(println total-de-produtos)

; Para printar concatenando uma mensagem
(println "TOTAL" total-de-produtos)

; Para se atribuir um novo valor você deve Definindo novamente
(def total-de-produtos 13)

; Para calcular utilizamos a operação prefixa
; Operadores no clojure são funcões
; Operador(+) Numero1 (13) Numero2(3)
(+ 13 3)

; Somar função - Invocaçao de funçao
(+ total-de-produtos 3)

; Definindo o valor de uma função
(def total-de-produtos (+ total-de-produtos 3))

; Definindo um vetor
;OBS: A virgula conta como espaço, não exibirá no print, mas como boa pratica colocar para auxiliar a leitura.
(def estoque ["Mochila", "Camiseta"])

(println estoque)

;Para printar os valores em determinadas posições utilizamos (vetor posicao)
(estoque 0) ;-> Retorna mochila

;Contar é uma função, assim como soma
(count estoque)

;Cria um novo vetor adicionando mais um valor em conjunto e não altera o simbolo (Variavel) estoque
(conj estoque "Cadeira")

; Para inclementar a variavel estoque é necessário concatenas definindo novamente
(def estoque (conj estoque "Cadeira"))

; defn - Definindo uma função
; É necessário definir os parametros que serão passados
(defn imprime-mensagem []
  (println "Bem vindo(a) ao estoque!"))
* valor-bruto 0.9

;Criar uma função para calcular o desconto de um produto
(defn aplica-desconto [valor-bruto]
 (* valor-bruto 0.9))

(aplica-desconto 100)


; Boas praticas é nomear as funções como um substantivo, não como imperativo assim como o primeiro nome.
(defn valor-descontado [valor-bruto]
 (* valor-bruto 0.9))

(aplica-desconto 100)

; Outra maneira de criar o desconto de 10%"
(defn valor-descontado
 [valor-bruto]
(* valor-bruto (- 1 0.10)))

; Maneira errada de usar o desconto, visto que o symbolo pode ser semelhante a uma variavel global
; Dessa maneira eu poderia estar definindo uma simbolo que já possuia um valor
(defn valor-descontado
 [valor-bruto]
 (def desconto 0.10)
(* valor-bruto (- 1 desconto)))

; let executa apenas dentro do seu escopo - maneira de manter a imutabilidade
(defn valor-descontado
 [valor-bruto]
 (let [desconto 0.10] ;Ele cria um vetor
   (* valor-bruto (- 1 desconto))))

; Desenvolvendo a fn
(defn valor-descontado
   [valor-bruto]
 (let [taxa-de-desconto (/ 10 100)
       desconto         (* valor-bruto taxa-de-desconto)]
       (println "CALCULANDO DESCONTO DE " desconto)
       (- valor-bruto desconto)))

(valor-descontado 100)


;Condicionais
(if (> 500 100)
				(println "Maior") ;if
				(println "Menor") ;else
)

;condicionais na fn de desconto
(defn valor-descontado
   [valor-bruto]
   (if (> valor-bruto 100)
 (let [taxa-de-desconto (/ 10 100)
       desconto         (* valor-bruto taxa-de-desconto)]
       (println "CALCULANDO DESCONTO DE " desconto)
       (- valor-bruto desconto))
  valor-bruto
 ))
