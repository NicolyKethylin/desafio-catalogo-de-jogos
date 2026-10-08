# Catálogo de Jogos

Projeto em Java que demonstra conceitos de orientação a objetos por meio de um catálogo de jogos. Cada jogo tem informações comuns, pode ser iniciado e encerrado, e recebe um desconto calculado conforme a forma de pagamento.

## Requisitos

- JDK 26, conforme a configuração atual do projeto (`.idea/misc.xml`).
- IntelliJ IDEA (opcional; o projeto também pode ser aberto em outra IDE compatível com Java).

O `Main.java` usa o formato de arquivo-fonte compacto do Java, sem declarar explicitamente uma classe `Main`. Por isso, é necessário executar com uma versão do Java que suporte esse formato.

## Como executar

Abra o projeto na IDE, confirme que o SDK configurado é o JDK 26 e execute `src/Main.java`.

## Estrutura

| Arquivo | Responsabilidade |
| --- | --- |
| `Main.java` | Cria os jogos e a forma de pagamento, executa o fluxo e exibe os dados e valores. |
| `Jogo.java` | Classe base com os dados compartilhados pelos jogos e seus getters. |
| `JogoDigital.java` | Tipo de jogo digital; define mensagens próprias ao iniciar e encerrar. |
| `JogoFisico.java` | Tipo de jogo físico; define mensagens próprias ao iniciar e encerrar. |
| `JogoOnline.java` | Tipo de jogo on-line; define mensagens próprias ao iniciar e encerrar. |
| `Jogando.java` | Contrato das operações e informações disponíveis para um jogo no fluxo principal. |
| `Descontavel.java` | Contrato para calcular desconto a partir de um preço. |
| `Cartao.java` | Calcula desconto de 5%. |
| `Dinheiro.java` | Calcula desconto de 3%. |
| `Pix.java` | Calcula desconto de 10%. |

## Conceitos de orientação a objetos

### Herança

`Jogo` concentra atributos comuns: nome, categoria, descrição e preço. `JogoDigital`, `JogoFisico` e `JogoOnline` herdam dessa classe usando `extends Jogo`, reaproveitando esses dados e os métodos de acesso em vez de redefini-los.

Cada subclasse chama `super(nome, categoria, descricao, preco)` no construtor. Isso encaminha os valores para o construtor de `Jogo`, que inicializa a parte comum do objeto.

### Interfaces e abstração

`Jogando` define operações que o programa espera de um jogo: `iniciarJogo()` e `encerrarJogo()`, além dos métodos que fornecem os dados do jogo. As três subclasses implementam essa interface com `implements Jogando`.

`Descontavel` define uma operação para calcular desconto. `Cartao`, `Dinheiro` e `Pix` implementam esse contrato, cada um com sua própria regra. A interface descreve *o que* a forma de pagamento faz; as classes concretas definem *como*.

### Polimorfismo

No `Main`, a lista é declarada como `List<Jogando>`, mas contém objetos de tipos diferentes: `JogoDigital`, `JogoFisico` e `JogoOnline`. O laço pode tratar todos pelo contrato comum `Jogando`.

Quando o programa chama `iniciarJogo()` ou `encerrarJogo()`, Java executa a implementação sobrescrita correspondente ao tipo real do objeto. Por exemplo, um `JogoOnline` exibe as mensagens específicas de jogo on-line. Essa seleção em tempo de execução é polimorfismo.

O mesmo princípio aparece nas formas de pagamento: todas podem ser usadas como `Descontavel`, mas cada classe calcula uma porcentagem diferente. No fluxo atual, `Main` instancia `Cartao`, então o desconto aplicado é de 5%.

### Sobrescrita

As classes de jogo sobrescrevem `iniciarJogo()` e `encerrarJogo()`, e as formas de pagamento sobrescrevem `calcularDesconto()`. A anotação `@Override` indica que o método implementa ou redefine um método declarado no contrato, ajudando o compilador a identificar incompatibilidades.

### Encapsulamento

`Jogo` disponibiliza os dados por getters (`getNome()`, `getCategoria()`, `getDescricao()` e `getPreco()`). No estado atual, porém, os atributos não são `private`: têm visibilidade de pacote. Portanto, o encapsulamento é parcial. Uma evolução possível seria torná-los `private final` e manter o acesso somente pelos getters.

## Fluxo executado

1. `Main` cria uma lista imutável com três jogos de tipos diferentes, usando `List.of(...)`.
2. Define `Cartao` como forma de pagamento.
3. Para cada jogo, chama `iniciarJogo()`, calcula o desconto sobre o preço, subtrai o desconto, imprime os dados e os valores e chama `encerrarJogo()`.
4. Exibe uma linha separadora antes de processar o próximo jogo.

O cálculo é feito em duas etapas: `desconto = preço × percentual` e `preço final = preço − desconto`. Os percentuais implementados são 5% para cartão, 3% para dinheiro e 10% para Pix.
