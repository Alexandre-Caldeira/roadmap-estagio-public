# 01. O que é Git?

## Para que serve Git?

- Escopo do problema: desenvolvimento de software em equipe
- Metodologia: servidor rastrea mudanças no código e autores
    - Sistema de Controle de Versões
    - Permite trabalho offline, e protege código funcional
- Outras opções
    - CSV, SVN, Mercurial

## Instalando Git

- Site oficial possui links rápidos: [https://git-scm.com/](https://git-scm.com/)
- Recomendação: instalar com git bash e opções padrão
- Git bash
    
    ![Untitled](01%20O%20que%20e%CC%81%20Git/Untitled.png)
    

## Repositórios

- Nesse curso será criada uma página HTML de cursos
- Inicializando repositório:
    - Criando pasta local
        
        ![Untitled](01%20O%20que%20e%CC%81%20Git/Untitled%201.png)
        
    - Checando no bash e criando repositório
        
        ![Untitled](01%20O%20que%20e%CC%81%20Git/Untitled%202.png)
        
- Como sei que está funcionando?
    - Criando arquivo novo, vazio: index.html
        
        ![Untitled](01%20O%20que%20e%CC%81%20Git/Untitled%203.png)
        
    - VSCode já indica mudanças (verde)
        
        ![Untitled](01%20O%20que%20e%CC%81%20Git/Untitled%204.png)
        
    - Bash também: git status
        
        ![Untitled](01%20O%20que%20e%CC%81%20Git/Untitled%205.png)
        
        - Estamos no ramo (branch) master
        - Não há commits ainda
        - Não há arquivos monitorados (Untracked Files)

## Para saber mais: Quem é você

- Configurando credenciais (”login”)
    
    ```bash
    git config --local user.name "Seu nome aqui"
    ```
    
    ```bash
    git config --local user.email "seu@email.aqui"
    ```
    

## Consolidando o seu conhecimento

- Adicionar código à página HTML:
    
    ```html
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Cursos da Alura</title>
    </head>
    <body>
        <p> Roadmap do Estágio Radix: </p>
        <ul>
            <li>Git e Github</li>
            <li>JRE e JDK</li>
            <li>Introdução a OO</li>
            <li>Aprofundamento OO (Polimorfismo e Herança)</li>
            <li>Injeção de Dependencia e Inversão de Controle</li>
            <li>Estrutura de Dados</li>
            <li>Coleções, Wrapper e Lambda</li>
            <li>Testes Unitários: Mocks em Java, conhecendo Mockito</li>
            <li>Bando de Dados Relacional</li>
            <li>JDBC</li>
            <li>JPA</li>
            <li>Spring Data</li>
            <li> Spring Boot API REST</li>
            <li>Design Patterns</li>
            <li>SOLID</li>
        </ul>
        <p> Tópicos avançados: </p>
        <ul>
            <li>ActiveMQ</li>
            <li>Reflection</li>
            <li>Redis</li>
            <li>Docker</li>
        </ul>
    </body>
    </html>
    ```