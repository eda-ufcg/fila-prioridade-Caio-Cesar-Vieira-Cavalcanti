# Identificação

* Nome: Caio Cesar Vieira Cavalcanti
* Email (@ccc): <caio.cesar.vieira.cavalcanti@ccc.ufcg.edu.br>
* Matrícula: 123110825

# Roteiro: Fila de Prioridade

## O template

> Não altere o arquivo build.gradle

> O código java estará (ou você terá que colocar) no diretório **/src/main/java/**

> Os testes estarão (ou você terá que incluir) no diretório **/src/test/java/**

> Seu código é tão bom quanto seus testes. Eu vou executar meus testes quando você submeter.

> Não mude nenhuma assinatura de método, nome de classe ou localização dos arquivos. Mas você pode/deve criar outros métodos e classes, desde que passem nos testes.

> Compilando: `gradle compileJava` na raiz do projeto.

> Executando os testes: `gradle test` na raiz do projeto.

## A tarefa

Uma fila de prioridade é aquela em que a política de acesso é dada por um valor inteiro, a prioridade. Nós vimos em sala de aula 3 maneiras de implementar essa estratégia: i) adicionando no final (O(1)) e buscando o de maior prioridade O(n); ii) inserindo ordenado (O(n)) e retirando do início
da fila (O(1)) e iii) usando um heap (O(logn)).

Você deve implementar essas 3 estratégias nesse roteiro. Veja a interface FilaPrioridade para entender a semântica dos métodos.

O objeto Pair é uma dupla com o elemento e sua respectiva prioridade.

Importante: você vai ter que alterar a classe Heap também para que ela possa armazenar objetos do tipo Pair, não somente inteiros.

## Entregando o lab

> Passo 0. Modifique o arquivo README. Coloque seu nome, email @ccc e matrícula nos lugares indicados. Se você não fizer isso, não considero que sua prova foi assinada e, portanto, não vou corrigir. Não mude a formatação da linha. Apenas inclua seus dados.

> Passo 1. Certifique-se **NO TERMINAL** de que sua solução compila e passa nos testes. Isso deve ser feito com os comandos do gradle (compileJava e test).

> Passo 2. Certifique-se de que você respondeu as perguntas teóricas onde foi indicado aqui no README.

> Passo 3. Submeta as suas modificações para o repositório

* `git pull`
* `git commit -m "entregando o lab de algoritmos recursivos"`
* `git push origin main`
