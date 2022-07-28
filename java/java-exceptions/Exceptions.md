# Java Exceções: Aprenda a criar, lançar e controlar exceções

- A Call Stack (pilha de execução) guarda metodos que estão sendo executados em formato de pilha (sempre inicia com main)
- Objetos vivem no HEAP, que é controlado pelo garbage collector

#
- Cuidados com try-catch: exceções são tratadas tipo a tipo.
- Tratar múltiplas exceções com mais de um bloco catch ou usando Multi-Catch utilizando o pipe (|).
- "throw" pode ser usada para lançar excessões instanciadas

#
- Observar pilha até o fim! Se não chega até o fim significa que há exceções não tratadas
- StackOverflowError => Call Stack ran out of memory
- Errors são throwable mas são reservados para baixo nível (boa prática), por isso devemos extender RuntimeException ao inves de Throwable
    > " Exceções são usadas em códigos de aplicação. Erros são usados exclusivamente pela máquina virtual."
    >

#
- Caso opte por extender Exception, a classe / método deverá necessariamente apresentar "throws" na assinatura da classe ou método (em frente ao seu nome) OU colocar try-catch no corpo => CHECKED 
- Ao contrário, RuntimeExceptions são UNCHECKED (compilador não verifica sintaticamente)

![](https://s3.amazonaws.com/caelum-online-public/834-java-excecoes/05/_05.01_001_runtimeexception-exception-error+2.png)

#
- É possível capturar quaisquer excessões porém não é uma boa prática:
```java
try {
    metodoPerigoso();
} catch (Exception e){
    e.printStackTrace();
}
```

- try-catch-finally possibilita sempre executar pelo menos parte do codigo independentemente de erros:
```java
Conexao con = null;
try {
    con = new Conexao();
    con.leDados();
}catch(IllegalStateException ex) {
    System.out.println("Deu erro na conexao");
}finally { 
    con.fecha();
}
```
- Para evitar null, podemos fazer algo mais elegante: try-with-resources para classes que implementam AutoCloseable
- O tratamento no bloco catch é opcional quando tem o bloco finally.

> "A IllegalArgumentException e IllegalStateException são duas exceções importantes, que o desenvolvedor Java deve usar. Em geral, quando faz sentido, use uma exceção padrão em vez de criar uma própria."
>

