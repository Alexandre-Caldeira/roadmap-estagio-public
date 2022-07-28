# BOAS PRÁTICAS
<br>

## Índice
>
> - Comportamentais:
>   + [Strategy](#strategy)
>   + [Chain of Responsibility](#chain-of-responsibility)
>   + [Template](#template)
>   + [State](#state)
>   + [Command](#command)
>   + [Observer](#observer)
> - Estruturais:
>     + [Adapters](#adapters)
>     + [Decorator](#decorator)
>     + [Composite](#composite)
>     + [Facade](#facade)
>     + [Proxy](#proxy)
> - [SOLID](#solid)
>     + [OOP](#oop)
>     + [S: Coesão](#s-coesão)
>     + [O: Acoplamento](#o-acoplamento)
>     + [L: Herança indesejada](#l-herança-indesejada)
>     + [ID: Abstrações](#id-abstrações)
>     
> [⬆️ Roadmap](https://github.com/Alexandre-Caldeira/roadmap-estagio)

   
<br>

## Design Patterns 
### Strategy 
> Comportamental
>
> Resolve adição infinita de casos e condições
>
> [Refactoring Guru: Strategy](https://refactoring.guru/design-patterns/strategy)
>
> [⬆️](#boas-práticas)
<br><br>

- Contexto: Uma regra de negócios que varia dependendo de um ou mais parametros.
    - Exemplo: CalculadoradeImpostos calcula imposto dependendo do TipoDeImposto (string?int?enum?).
    - Problema: Emprega switch-case, if-else atrelado a parsing de entrada com enum, string, int, etc. de tal forma que tem-se uma classe "eternamente" crescendo e sofrendo manutenção para adaptar a novas regras de negócio.
<br><br>
- Solução: Abstrai-se a regra de negócios para uma **interface**, e cabe às classes que a implementem executar essa regra ou método em função do seu próprio contexto. 
    - Exemplo: Cada tipo de imposto é uma classe que implementa Imposto tem portanto um método .calcula() que retorna o valor calculado. Assim, a classe CalculadoraDeImpostos agora somente implementa uma chamada por polimorfismo e inversão de controle: 
        ``` java
        public BigDecimal CalculaImpostos(BigDecimal valor, Imposto imposto) {
            // IoC + polimorfismo => sem ifs!
            return imposto.calcula(valor);
        }
        ```
<br><br>
- Obs.: como um "for", tem métodos a serem aplicados e sabe-se exatamente _quando_ deve-se aplicar cada regra de negócio.

### Chain of Responsibility 
> Comportamental 
>
> Resolve checagens sequenciais para aplicar regra de negócio
>
> [Refactoring Guru: Chain of Responsability](https://refactoring.guru/design-patterns/chain-of-responsibility)
>
> [⬆️](#boas-práticas)

- Contexto: Uma regra de negócios precisa ser aplicada em diversas condições que precisam sempre ser verificadas 
    - Exemplo: um cliente pode ter descontos diferentes aplicados a depender do valor da compra, do número de itens, se for seu aniversário, etc. e precisamos sempre verificar cada um desses casos, sendo que essas condições podem ser adicionadas ou alteradas frequentemente.
    - Problema: Padrão Strategy não é suficiente, pois não lida com checagens sequenciais, mas sim com abstração da adição ou adaptação de regras de negócio em função de novos parâmetros, condições ou tipos de objetos.

- Solução: Constrói-se uma classe abstrata que possui um atributo `protected next` que aponta para a próxima classe verificadora na cadeia de checagens, além da assinatura da regra de negócios que deve ser implementada por cada filha (como no padrão Strategy). Para cada tipo de desconto condicional cria-se uma classe que herda da classe abstrata, implementa a regra de negócios e decide se deve aplicar esta regra ou passar para a próxima verificação (próxima classe filha) até atingir a classe de condição nula, condição de parada.
    - Exemplo: cada tipo de desconto herda Desconto com `next` e `calculaDesconto`, possuindo apenas 1 if em seu corpo. Assim, OU aplica o desconto e sai da cadeia de verificações OU passa para a próxima classe, até atingir a classe de condição de parada que tem next como null. Ou seja:
        ```java
        // Aplicacao
        public class CalculadoraDeDescontos{
            public BigDecimal calcular(BigDecimal valor){
                // Chain of Responsibility
                Desconto desconto = new DescontoAniversario( new DescontoValor( new SemDesconto() ) );
                return desconto.calcularDesconto(valor);
            }
        }

        // Mae
        public abstract class Desconto {
            protected Desconto next;

            public Desconto(Desconto next){
                this.next = next;
            }
            public abstract calculaDesconto(BigDecimal valor);
        }

        // Uma condicao
        public class DescontoAniversario extends Desconto {
            public DescontoAniversario(Desconto next){
                super(next);
            }

            public BigDecimal calculaDesconto(BigDecimal valor){
                // se for aniversariante nao paga
                if (anivesario){
                    return valor;
                }

                return  next.calcularDesconto(valor);
            }
        }

        // Outra condicao
        public class DescontoValor extends Desconto {
            public DescontoAniversario(Desconto next){
                super(next);
            }

            public BigDecimal calculaDesconto(BigDecimal valor){
                // se tiver valor alto recebe 10% de desconto
                if (valor > 100){
                    return valor.multiply(new BigDecimal("0.1"));
                }

                return  next.calcularDesconto(valor);
            }
        }

        // Parada
        public class SemDesconto extends Desconto {
            public SemDesconto(){
                super(null);
            }

            public BigDecimal calculaDesconto(){
                return BigDecimal.ZERO;
            }
        }
        ```

- Obs.: como um "while", não sei quando devo aplicar uma regra de negócio e preciso verificar cada uma das condições possíveis.

### Template 
> Comportamental 
>
> Resolve boilerplate através de abstrações reaproveitáveis
>
> [Refactoring Guru: Template](https://refactoring.guru/design-patterns/template-method)
>
> [⬆️](#boas-práticas)

- Contexto: Nota-se repetição de funções, classes ou passo-a-passo no código, até mesmo através de copy-paste.
    - Problema: código repetido de funcionalidade identica mas difícil refatoração por estar distribuído ao invés de centralizado, além de levar a verbosidade.

- Solução: Abstrair e herdar comportamentos repetitivos para classes abstratas (ou interfaces a depender do contexto de aplicação dos comportamentos / regras de negócio abstraídas).

### State
> Comportamental 
>
> Resolve fluxo descontrolado de estados 
>
> [Refactoring Guru: State](https://refactoring.guru/design-patterns/state)
>
> [⬆️](#boas-práticas)

- Contexto: objeto(s) possue(m) fluxo previsível de estados que deve ser garantido para devido funcionamento da aplicação.
    - Exemplo: um pedido pode estar no estado CRIADO, EM_ANALISE, APROVADO, REPROVADO ou CONCLUIDO, não podendo retornar para nenhum dos estados anteriores e sempre passando de APROVADO/REPROVADO apenas para CONCLUIDO (if-elses relacionados a estado do objeto).
    - Problema: utilizar strings, ints ou enums como tags de estado forçará implementação de diversos 

- Solução: Abstrair estados para classes que herdam de uma classe abstrata (ou interface) cujos métodos por padrão lança exceções para mudanças de estado inválidas / proibídas. Nos casos em que a transição de estados é válida, os estados envolvidos sobrescrevem os métodos que lançariam exceção e implementam tal transição.


### Command
> Comportamental 
>
> Resolve boilerplate de use-cases em classes filhas
>
> [Refactoring Guru: Command](https://refactoring.guru/design-patterns/command)
>
> [⬆️](#boas-práticas)

- Contexto: Diferentes classes filhas precisam executar ações similares a partir de gatilhos.
    - Exemplo: Tela possui vários botões e cada um precisa "detectar clique", porém cada botão age de forma diferente quando clicado, apesar de todos serem botões.
    - Problema: Código boilerplate e verboso em classes filhas para EXECUTAR um dado use-case da classe mas que tem parâmetros similares ou idênticos em todas as classes filhas.

- Solução: Abstrai-se o comando que executa o use-case para uma interface que será implementada por cada uma das classes filhas, a partir dos parâmetros bem definidos  que todas empregam para EXECUTAR este "comando" (use-case).
    - Exemplo: GeraPedido é uma classe que constrói pedidos de clientes a partir de parâmetros definidos, e possui geraPedido.executa() que de fato constrói o pedido e envia ao servidor.

- Obs.: Usa-se hoje em dia o padrão Command Handler: "Um Command Handler tem como responsabilidade, normalmente, apenas orquestrar as tarefas a serem executadas, ou seja, chamar as classes necessárias que realizam as tarefas desejadas."

### Observer
> Comportamental 
>
> Resolve acoplamento entre evento e reação de múltiplos objetos via IoC
>
> [Refactoring Guru: Observer](https://refactoring.guru/design-patterns/observer)
>
> [⬆️](#boas-práticas)

- Contexto: eventos no sistema exigem que diversos objetos executem diferentes ações (evento dispara vários ouvintes/observadores).
    - Exemplo: quando um cliente finaliza compra, gerar boleto, enviar pelo email, cadastrar compra no sistema, etc.
    - Problema: A classe Handler responsável por instanciar os objetos e pedir que executem tais ações fica volátil e "infinitamente" crescente.

- Solução: Abstrair método que chama a execução da responsabilidade de cada objeto para uma interface única, agora o Handler pode chamar uma lista de objetos que implementam essa interface e disparar todas as ações sem saber nem se preocupar com quantos objetos precisa instanciar, nem como instanciá-los e nem como executar suas responsabilidades.

- Obs.: DIFERENÇA DO COMMAND PARA O OBSERVER: Observer deals with how EventSource is coupled with EventListener (which is not solved by the Command pattern) and Command deals with how to carry on after being notified about the event (about what Observer doesn't says anything).

### Adapters
> Estrutural 
>
> Resolve incompatibilidade entre dependência existente e uso
>
> [Refactoring Guru: Adapter](https://refactoring.guru/design-patterns/adapter)
>
> [⬆️](#boas-práticas)

- Contexto: uma classe precisa aplicar um processo longo fora de sua responsabiliadde e que depende de outra(s) classe(s) incompatíveis.
    - Exemplo: para registrar um orçamento, a classe RegistroDeOrcamento possui uma função `registra(Orcamento orcamento)` que precisará salvar esse orçamento através de uma REST API e enviar um email. Para isso, precisaremos depender de classes que façam as requisições HTTP que lidam com essas preocupações e são chamadas dentro de `registra` além de que existem diferentes implementações de Hanlders e Adapters de HTTP que podemos querer usar.
    - Problema: depender de implementações (classes concretas) e de interfaces incompatíveis com a responsabilidade única do método ou do contexto da classe em questão.

- Solução: criar uma interface intermediária / adaptadora que será a dependência injetada onde precisamos usar, já a responsabilidade de implementar e instanciar a solução desejada fica em uma classe específica que resolve as incompatibilidades entre a classe/interface dependida e nosso código.

- Obs.: SEMPRE dependa de interfaces e injete a dependência, OU extenda/implemente uma classe abstrata. 

### Decorator
> Estrutural
>
> Resolve manutenção infinita de interação cumulativa (composição) entre classes
>
> [Refactoring Guru: Decorator](https://refactoring.guru/design-patterns/decorator)
>
> [⬆️](#boas-práticas)

- Contexto: 
    - Exemplo: para calcular o imposto total a ser pago preciso somar o IPVA com o IPTU. Mas e se surgir um novo imposto? Além de implementar o novo imposto, precisarei alterar o código que calcula o imposto total para somar o novo imposto que acaba de ser implementado.
    - Problema: adição de novas classes/funcionalidades exige manutenção de uma classe hierarquicamente superior.

- Solução: Decorar (compor) classes filhas com suas "irmãs", ou seja, adicionar na classe mãe a dependência de uma segunda classe idêntica no construtor e que será usada no método de responsabilidade principal da classe, implementada pelas filhas.
    - Exemplo: na classe abstrata Imposto, cria-se o atributo `Imposto outroImposto` que será passado no construtor (`this.outroImposto = outro`) de maneira que as classes filhas precisaram de uma null ou uma irmã (outro tipo de imposto) para serem construídas (Matrioska) e o cálculo do imposto implementado nas classes filhas soma ao valor final o valor calculado (anteriormente) pela classe irmã decorada, composta ("herdada/injetada/dependida").

- Obs.: [DECORATOR VS CHAIN OF RESPONSABILITY:](https://stackoverflow.com/questions/3721256/design-patterns-chain-of-resposibility-vs-decorator) "Think of decorators as a layered unit in which each layer always does pre/post processing. Chain of Responsibility is more like a linked list, and generally 1 thing handles processing." Ou seja, Chain of Responsability checa várias coisas mas aplica uma só, ao passo que Decorator compõe, acumula, comportamentos de vários objetos. 

### Composite
> Estrutural
>
> Resolve reconstrução de objetos compostos aproveitando objetos compostos antigos ou já existentes
>
> [Refactoring Guru: Composite](https://refactoring.guru/design-patterns/composite)
>
> [⬆️](#boas-práticas)

- Contexto: precisa-se (re)construir um objeto composto de vários outros objetos que podem já ter sido instanciados e deseja-se reaproveitá-los.
    - Exemplo: um item do carrinho de compras esgotou antes do cliente fechar a compra, agora precisamos recriar o carrinho aproveitando todos os itens antigos e adicionando novos itens desejados pelo cliente, sem iterar pela lista de itens (nem sempre é possível e geralmente não é performático).
    - Problema: de maneira geral não podemos de maneira performática reconstruir cada um dos objetos filhos do objeto composto (usando `for`,`while`,etc.) ou até mesmo nem sabe-se (re)instanciar os objetos necessário.

- Solução: a própria classe possui uma sobrecarga de construção utilizando uma interface que a própria classe herda, que será usada para clonar/reconstruir a nova classe (atentando para vazamento de referências) aproveitando os objetos já existentes para se construir.

- Obs.: A motivação aqui não é _PERFORMANCE_ mas sim facilidade de acesso à àrvore de objetos que compõe o objeto composto para facilitar implementações de características e responsabilidades.
    - Exemplo: Precisamos implementar uma forma de adicionar um orçamento a outro orçamento, e escolhemos a abordagem de podermos representar tanto orçamentos quanto itens de forma semelhante, através da interface Orcavel. Por que não simplesmente criamos um novo List<ItemOrcamento> na classe Orcamento?
        - Porque dessa forma, podemos percorrer toda a nossa árvore de itens "orçáveis", de forma muito simples para calcular o valor. Alternativa correta! Ao implementar uma interface que permita representar ItemOrcamentos e Orcamentos de forma semelhante, podemos percorrer essa lista de Orcavels facilmente, para calcular o valor do orçamento, que é a raiz da árvore.

### Facade
> Estrutural
>
> Resolve vazamento ou excesso de informação no cliente pelo serviço
>
> [Refactoring Guru: Facade](https://refactoring.guru/design-patterns/facade)
>
> [⬆️](#boas-práticas)

- Contexto: uma aplicação está pronta, funciona mas tem várias metodologias e processos expostos para o cliente.
    - Problema: além de vazar informações e acesso a atributos ou métodos críticos para funcionamento do sistema, dificulta a compreensão de como realmente utilizar a aplicação.

- Solução: Expor acesso através de interface de uso simples, com poucos métodos e com poucas responsabilidades (ou aplicabilidades) que são também claras/evidentes, além de empregar empregar boas práticas:
    - Usar `private` ou `protected` para todos os atributos e métodos que não precisam ser preocupações de uso do cliente;
    - Empregar encapsulamento, inversão de controle e injeção de dependência para garantir que métodos tem responsabilidades únicas, têm as dependencias para essa responsabilidade injetadas e são chamados de maneira apropriada/organizada somente quando estritamente necessário;
    - Depender de abstrações (interfaces ou classes abstratas), e não de implementações (classes concretas) com exceção apenas de classes a serem persistidas.

- Obs.: Motivação de uso
    >
    >Perg.:"Quais as vantagens de utilizar uma classe dessas, ao invés de acessar o sistema completo diretamente?" 
    >
    >Resp.: Simplicidade. Tendo acesso a parte de um sistema (módulo) através de uma única classe, temos uma interface mais simples. Alternativa correta! Uma classe desse tipo nos fornece poucos métodos públicos (um só, no nosso caso), com toda a infraestrutura necessária para realizar a tarefa.
    > <br><br>

- Exemplo:
    - BAD:
        ```java
            public static void main(String[] args) {
                //...
                Conta minhaConta = new Conta();
                Conta outraConta = new Conta();
                
                BigDecimal valorTransferencia = new BigDecimal("100");
                Transferencia transferencia = new Transferencia();

                transferencia.validarConta(minhaConta);
                transferencia.validarConta(outraConta);

                transferencia.checarSaldo(minhaConta);
                transferencia.executar(minhaConta,outraConta,valorTransferencia);
                //...
            }
        ```
    - GOOD:
        ```java
            public static void main(String[] args) {
                //...
                Transferencia transferencia = new Transferencia(
                    new Conta("Eu","150"), 
                    new Conta("Outra","0"), 
                    BigDecimal("100")
                );

                transferencia.executar();
                //...
            }
        ```

### Proxy
> Estrutural
>
> Resolve performance ruim em chamadas lentas excessivas ou vazamentos de segurança não-interceptados
>
> [Refactoring Guru: Proxy](https://refactoring.guru/design-patterns/proxy)
>
> [⬆️](#boas-práticas)

- Contexto: chamadas proibídas ou lentas estão sendo executadas em seguida e/ou de forma desnecessária repopulando campos já atribuídos ou objetos já instanciados. 
    - Exemplo: carregar um relacionamento ManyToOne exige carregar uma lista, mas pode ser que deseja-se somente um caso desse relacionamento
    - Problema: chamadas repetidas ou até mesmo proibídas não são verificadas.

- Solução: criar classe proxy ("cópia" similar à original) que verifica atributos, instanciando ou atribuindo valor à esses atributos somente quando e SE FOR necessário. Se já existe instância/valor, evita repopulação de atributos desnecessáriamente (transforma chamadas lentas em O(1)).

- Obs.: É como funcionam as chamadas LAZY em ORM, ajuda a criar camadas. Motivação de uso:
    > 
    > Quais seriam bons motivos para utilização do padrão Proxy?
    >
    > Performance e Segurança! Proxy intercepta chamadas e verifica se pode-se ou precisa-se executar a chamanda em questão.
    > <br><br>

<br><br>

## SOLID
> [OOP](#oop)
>
> [S: Coesão](#s-coesão)
>
> [O: Acoplamento](#o-acoplamento)
>
> [L: Herança indesejada](#l-herança-indesejada)
>
> [ID: Abstrações](#id-abstrações)
>
> [⬆️](#boas-práticas)

- Single Responsibility Principle
- Open Closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle

<br><br>

### OOP
> 
> Revisitando os pilares da orientação a objetos.
> 
> [⬆️ Índice SOLID](#solid)

<br>

- Coesão:
    > <br>
    > "União harmônica entre uma coisa e outra."
    >
    > <br> 
    - Código (classes) em que se tem somente os atributos e métodos estritamente necessário e _diretamente_ relacionado com seu contexto e responsabilidade.
        - GOOD: Funcionário tem Id, Nome, CPF, Cargo.
        - BAD: Funcionário tem Rua, Cidade, Estado, Id, Nome, Cpf, Cargo, `.formataEndereco()`, `.formataCpf()`, ...
    > <br>
    > Classes não-coesas tendem a crescer indefinidamente, o que as torna difíceis de manter.
    > <br>
    > "Uma classe que executa bem a sua única tarefa, de forma concisa. Cada classe deve ser responsável por apenas uma coisa, e deve executar esta tarefa muito bem."
    > <br><br>

<br>

- Encapsulamento:
    > <br>
    > "Incluir ou proteger alguma coisa em uma cápsula."
    >
    > <br>
    - Proteger, blindar, uma classe contra influências externas.
    - Nem sempre `private` = seguro, e nem sempre precisamos de usar `private`. 
        - BAD: Suponha `private double salario` com getter e setter, está seguro, encapsulado, certo? Não. E se fizermos `funcionario.setSalario(9999999999)`?
        - GOOD: Para o encapsulamento propriamente ocorrer (capsula sem furos), precisa-se que os getters e setters proíbam alteração inválida via exceção ou tratamento de entrada. 
    > <br>
    > "Classes não-encapsuladas permitem violação de regras de negócio, além de aumentarem o acoplamento."
    > <br><br>

<br>

- Acoplamento:
    > <br>
    > "Ação de acoplar, agrupamento aos pares."
    > <br><br>
    - Classes que possuem interdependencia possuirão acoplamento, e isso é inevitável, mas buscamos ter acoplamento fraco entre as classes, facilitando manutenção.
    - Acoplamento forte: "quando a conversa entre as classes se torna muito íntima".
        - BAD: 
            ```java
                Funcionario funcionario = carregarDoBancoDeDados();
                double valorTotalReajustes = 0;
                List<Reajuste> reajustes = funcionario.getReajustes();
                for(Reajuste r: reajustes){
                    valorTotalReajustes += r.getValor();
                }
            ```
            - Qualquer mudança em Reajuste ou Funcionario impactará em mudanças no código acima. Nosso código reflete que Reajuste e Funcionario estão fortemente acopladas.
        - GOOD: 
            ```java
                Funcionario funcionario = carregarDoBancoDeDados();
                double reajustes = funcionario.getValorTotalRecebidoEmReajustes;
            ```
    > <br>
    > "Classes acopladas causam fragilidades no código da aplicação, o que dificulta sua manutenção.
    > <br><br>
   
<br>
     
### S: Coesão
> <br>
> Single Responsibility Principle
> 
> [⬆️ Índice SOLID](#solid)
- Exemplo: na classe `Funcionario` temos a função `.reajustarSalario()` que causa falta de coesão. Devemos removê-la? 
    - Não necessariamente. A principio pode-se manter a classe mas a implementação do reajuste passa para uma outra classe (`ReajusteService`) cujo método estático será chamado, desacoplando, abstraindo e facilitando manutenção dos reajustes de todos os funcionários no futuro.
    - Melhor ainda seria alterar o método para `.atualizarSalario(BigDecimal NovoSalario)` que nem precisará acessar o `ReajusteService`, isso caberá a alguma outra classe de caso de uso!
        - Obs.: isso causa uma diminuição de encapsulamento pois qualquer NovoSalario pode ser passado.
    - Em outras palavras: nem sempre a coesão é atingida removendo atributos/métodos, mas sim realocando seus usos e acessos de maneira inteligente, prezando por sempre depender de abstrações!
- A alteração empregada aqui é uma refatorção do tipo "**EXTRAIR CLASSE**":
    > "É uma alteração no código que visa melhorar sua clareza e entendimento. Alternativa correta! Refatorações servem para melhorar o design do código, e não o funcionamento do sistema. Uma refatoração não deve influenciar em nada no funcionamento."
- Single Responsibility Principle:
    > <br>
    > "Uma classe deveria ter apenas um único motivo para mudar!" - Uncle Bob
    > <br><br>

- [Lei de Demeter](https://pt.wikipedia.org/wiki/Lei_de_Demeter):
    >
    >Em sua forma geral, a LoD é um caso específico de loose coupling ou acoplamento fraco. A pauta foi proposta por Ian Holland na Northeastern University no final de 1987, e pode ser sucintamente resumido nas seguintes formas:
    >   - Cada unidade deve ter conhecimento limitado sobre outras unidades: apenas unidades próximas se relacionam. 
    >   - Cada unidade deve apenas conversar com seus amigos; Não fale com estranhos. 
    >   - Apenas fale com seus amigos imediatos.
    >
    > <br>

<br>

### O: Acoplamento
> <br>
> Open-Closed Principle
> 
> [⬆️ Índice SOLID](#solid)

- Não basta que o código (classe) seja meramente coeso: precisamos que seja EXTENSÍVEL, sem interromper o funcionamento de outras partes. 

- Open-Closed Principle:
    > <br>
    > Não precisa de cirugia de peito aberto pra vestir um casaco.
    > 
    > <br>
    - O que podemos fazer para garantir que nosso sistema seja extensível da forma correta? Garantir que cada ação/responsabilidade esteja na classe correta.

- O princípio Aberto/Fechado (OCP) diz que um sistema deve ser aberto para a extensão, mas fechado para a modificação. Isso significa que devemos poder criar novas funcionalidades e estender o sistema sem precisar modificar muitas classes já existentes. Uma classe que tende a crescer "para sempre" é uma forte candidata a sofrer alguma espécie de refatoração.

<br>

### L: Herança indesejada
> <br>
>  Liskov Substitution Principle
>
> [⬆️ Índice SOLID](#solid)

<br>

- Efeitos colaterais da herança: um terceirizado que herda da classe `Funcionario` herda também a capacidade de ser promovido, o que não é realmente possível. Similarmente, não podemos `.atualizarSalario()` de um terceirizado.
    - Uma solução: sobrescrever os métodos "proibidos" para algo "inofensivo" ao sistema.
    - Solução correta: padrão Composite. não herdar, mas empregar composição. Os atributos/métodos que PRECISAM ser herdados são extraidos ou abstraídos para outra classe/interface e somente essa nova classe/interface será herdada/extendida.

- Ou seja, favorecer COMPOSIÇÃO sobre herança. Compor sempre que possível, herdar somente 

- ENUMS PODEM TER MÉTODOS ABSTRATOS! Daí, cada enum filha precisará implementar o método. Isso facilita implementação do Padrão Chain of Responsibility em alguns casos  :)

- Liskov Substitution Principle:
    > <br>
    > If it looks like a duck, quacks like a duck, but needs batteries - you probably have the wrong abstraction. (Duck vs Plastic Duck)
    >
    > <br>
    - Se q(x) é uma propriedade demonstrável dos objetos de x de tipo T, então q(y) deve ser verdadeiro para objetos y de tipo S, onde S é subtipo de T.

### ID: Abstrações
> <br>
> Interface Segregation Principle e Dependency Inversion Principle
>
> [⬆️ Índice SOLID](#solid)
- Class is temporary, interface is forever.

- Dependency Inversion Principle
    > <br>
    > Você soldaria uma lâmpada diretamente nos fios da sua casa?
    >
    > "Abstrações não devem depender de implementações, implementações devem depender de abstrações." - Uncle Bob
    > <br>


- Interface Segregation Principle:
    > <br>
    > "Uma classe não deveria ser forçada a depender de métodos que não utilizará." - Uncle Bob
    >
    > <br>
    - Uma classe não deve ser obrigada a implementar um método de determinada interface, se ele não será útil. Para isso, uma interface deverá ser extraída apenas com os métodos necessários.
    
- Dica: geralmente, para corrigir problemas que ferem o Open-Closed Principle usando Design Patterns, aplicando Interface Segregation e Dependency Inversion, acaba-se obtendo também Single Responsibility. Ou seja, obtém-se SOD corrigindo O. 

<br>

### O que aprendemos?
>
> [⬆️ Índice SOLID](#solid)
- Que é mais interessante e mais seguro para o nosso código depender de interfaces (classes abstratas, assinaturas de métodos e interfaces em si) do que das implementações de uma classe;
- Que as interfaces são menos propensas a sofrer mudanças enquanto implementações podem mudar a qualquer momento;
- Que o Princípio de Inversão de Dependência (DIP) diz que implementações devem depender de abstrações e abstrações não devem depender de implementações;
- Que as interfaces devem definir apenas os métodos que fazem sentido para seu contexto;
- Que o Princípio de Segregação de Interfaces (ISP) diz que uma classe não deve ser obrigada a implementar um método que ela não precisa;
