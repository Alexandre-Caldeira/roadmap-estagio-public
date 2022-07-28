# Java e java.lang: Programe com a classe Object e String

- Full quallified name é o nome da classe identificando seu caminho em forma de pacote 
> "Na ausência do modificador, também chamado de package private ou default, o membro fica visível na classe e no package, mas é invisível fora do pacote (nem para filhos)."
>
- Protected são inacessíveis fora do pacote, mesmo que para classes herdeiras

#
- Javadoc pode ser gerado automaticamente a partir de comentarios de documentação (/**)
- membros (não públicos) são considerados detalhes da implementação e não podem ser utilizados por outras classes, nao aparecendo no javadoc.
- Javadoc tags:
```java
/**
* @author (usado na classe ou interface)
* @version (usado na classe ou interface)
* @param (usado no método e construtor)
* @return (usado apenas no método)
* @exception ou @throws (no método ou construtor)
* @see
* @since
* @serial
* @deprecated
*/
```

- Java .jar são formas de se distribuir código fonte compilado ou também executaveis java
- java.lang sempre é automaticamente importado e é de onde vem System, String e outros.

#
- String nao exige construtor porque é um literal mas pode ser instanciada também com objeto. Existe uma diferença entre a criação com new e a criação com aspas duplas. Usar aspas duplas é boa prática pois a JVM pode executar várias otimizações por baixo dos panos.

- Strings são imutáveis:
```java
String nome = "Alura";
String nome2 = new String("Alura");

nome.replace("A","a");
System.out.println(nome);

nome2 = nome.replace("A","a");	
System.out.println(nome2);

// Retorna:
//   Alura
//   alura
```

- String possui os métodos charAt, indexOf, substring, toUpperCase e toLowerCase, trim, dentre outros.
>"objetos da classe String são imutáveis e usamos uma sintaxe literal para criar (object literal) qualquer método de alteração da classe String devolve uma nova String que representa a alteração a classe String é uma CharSequence se precisamos concatenar muitos String devemos usar a classe StringBuilder
>

- System:
    - é uma classe, java.lang, acesso public
- out: 
    - atributo, public, referencia (algum tipo de objeto), static (por ser acessado através da classe e não de uma instancia)
- println();
    - método, recebe string e mostra na tela, public, void, não static (chamado através de uma referencia: o atributo out), tem varias sobrecargas, não joga checked exceptions

- Object é o tipo mais generico de classe, todas as classes Java herdam de Object
