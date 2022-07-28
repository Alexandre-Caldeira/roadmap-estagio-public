# 03. Compartilhando o trabalho

## Repositórios remotos

- Criando um novo repo vazio para ser um repositorio puro
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled.png)
    
- Adicionando o “servidor” como repositório remoto do outro
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%201.png)
    
- Note, do último comando, que é possível ter “servidores” diferentes para enviar e buscar mudanças de código
- Simulando colaboração com Ana
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%202.png)
    
    - Ana criou uma pasta, e clonou nosso repo para outra pasta de nome “projeto”
    

## Servidor git

```bash
git init --bare
```

> Com este comando nós criamos um repositório que não terá a *working tree*, ou seja, não conterá uma cópia dos nossos arquivos. Como o repositório servirá apenas como servidor, para que outros membros da equipe sincronizem seus trabalhos, poupamos espaço de armazenamento desta forma.
> 

## Trabalhando com repositórios remotos

```bash
git remote add nome-repositorio caminho/para/o/repositorio
```

> Desta forma teremos um link do nosso repositório local com o repositório remoto, que chamamos de `nome-repositorio`, que está armazenado em `caminho/para/o/repositorio`.
> 

## Sincronizando os dados

- Quando ana clonou nosso repo, não haviam dados.
- Enviando alterações para o remoto
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%203.png)
    
- Agora Ana pode pegar o código: git pull
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%204.png)
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%205.png)
    
- Ana pode também alterar o código
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%206.png)
    
- Commitando e enviando mudanças de Ana para repo principal
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%207.png)
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%208.png)
    
- Pegando mudanças no repo principal
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%209.png)
    
- Funciona!
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%2010.png)
    

## Compartilhando alterações

```bash
git clone
```

> Traz um repositório remoto para nosso computador
> 

```bash
git push [repo] master
```

> Envia informações para “repo”
> 

## Github

- Pode ser pensado como servidor remoto de repositórios
- Criando repositório
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%2011.png)
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%2012.png)
    
- Enviando o repo já criado para lá:
    
    ```bash
    git remote add origin https://github.com/Alexandre-Caldeira/roadmap-estagio.git
    ```
    
    ```bash
    git branch -M main
    ```
    
    ```bash
    git push -u origin main
    ```
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%2013.png)
    
- No Github
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%2014.png)
    
- Mostrando commit de Ana
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%2015.png)
    
- Mostrando histórico de commits
    
    ![Untitled](03%20Compartilhando%20o%20trabalho/Untitled%2016.png)