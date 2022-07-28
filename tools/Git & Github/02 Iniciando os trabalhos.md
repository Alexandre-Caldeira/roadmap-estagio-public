# 02. Iniciando os trabalhos

## Salvando alterações

- Alterações ainda não estão sendo monitoradas!
- Para adicionar um arquivo ou pasta:
    
    ```bash
    git add nomeDoArquivo
    ```
    
- Ou para adicionar todos os arquivos e subpastas do repositorio local:
    
    ```bash
    git add .
    ```
    
- Aplicando no terminal bash:
    
    ![Untitled](02%20Iniciando%20os%20trabalhos/Untitled.png)
    
- Git exige que seja adicionada uma mensagem curta que descreva as mudanças (commit)
    
    > A boa prática pede para colocarmos mensagens **descritivas**, evitando que fiquem muito grandes.
    > 
- Executando no terminal bash:
    
    ```bash
    git commit -m "Criando arquivo index.html com roadmap"
    ```
    
- Agora não há novas modificações, até que outras sejam feitas
    
    ![Untitled](02%20Iniciando%20os%20trabalhos/Untitled%201.png)
    

## Para saber mais: git status

> Ao executar o comando `git status`, recebemos algumas informações que talvez não estejam tão claras, principalmente quando nos deparamos com termos como `HEAD`, `working tree`, `index`, etc.
> 
> - `HEAD`: Estado atual do nosso código, ou seja, onde o Git os colocou
> - `working tree`: Local onde os arquivos realmente estão sendo armazenados e editados
> - `index`: Local onde o Git armazena o que será *commitado*, ou seja, o local entre a *working tree*
>  e o repositório Git em si.
- Mais informações em: [https://git-scm.com/book/pt-br/v2/Fundamentos-de-Git-Gravando-Alterações-em-Seu-Repositório](https://git-scm.com/book/pt-br/v2/Fundamentos-de-Git-Gravando-Altera%C3%A7%C3%B5es-em-Seu-Reposit%C3%B3rio)

## Vendo o histórico

- git log
    
    ![Untitled](02%20Iniciando%20os%20trabalhos/Untitled%202.png)
    
- Dica: git log cheatsheet [https://devhints.io/git-log](https://devhints.io/git-log)
- Visualização mais limpa:
    
    ```bash
    git log —oneline
    ```
    
    ![Untitled](02%20Iniciando%20os%20trabalhos/Untitled%203.png)
    
- Visualização com mais informações:
    
    ```bash
    git log -p
    ```
    
    ![Untitled](02%20Iniciando%20os%20trabalhos/Untitled%204.png)
    
- Formatos personalizados, exemplo
    
    ```bash
    git log --pretty="format:%h %s"
    ```
    

## Ignorando arquivos

- Criando um arquivo vazio
    
    ![Untitled](02%20Iniciando%20os%20trabalhos/Untitled%205.png)
    
- Arquivo .gitignore
    - Lista de tipos e nomes de arquivos ou pastas serem ignorados
    - Todos na lista não terão suas modificações monitoradas
- Ignorando nosso arquivo vazio
    
    ![Untitled](02%20Iniciando%20os%20trabalhos/Untitled%206.png)
    
    ![Untitled](02%20Iniciando%20os%20trabalhos/Untitled%207.png)
    
- Quando criar um commit?
    - Não há muito consenso, mas por boas práticas:
    
    > Este é um assunto muito extenso, que gera discussões bem calorosas, mas um consenso geral é que **jamais devemos commitar código que não funciona**. Isto é, o código deve estar sempre no estado funcional para ser commitado. Isto não significa que ele deva ser commitado apenas ao fim do projeto. A recomendação é que se gere um commit após cada alteração significativa.
    > 
    - Ainda:
    
    > Devemos gerar um *commit* sempre que a nossa base de código está em um estado do qual gostaríamos de nos lembrar. Nunca devemos ter *commits* de códigos que não funcionam, mas também não é interessante deixar para *commitar* apenas no final de uma *feature*.
    >