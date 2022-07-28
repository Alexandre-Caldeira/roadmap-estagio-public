# 04. Trabalhando em equipe

## Branches

- Ramificações de trabalho
- A branch master é a padrão
- Criando branches e trabalhando nelas
    
    ![Untitled](04%20Trabalhando%20em%20equipe/Untitled.png)
    
- Ferramenta útil: [https://git-school.github.io/visualizing-git](https://git-school.github.io/visualizing-git)
- Alterando index.html na branch titulo
    
    ![Untitled](04%20Trabalhando%20em%20equipe/Untitled%201.png)
    
- Essas alterações não estão na branch master:
    
    ![Untitled](04%20Trabalhando%20em%20equipe/Untitled%202.png)
    
- Ana vai alterar a lista
    
    ![Untitled](04%20Trabalhando%20em%20equipe/Untitled%203.png)
    

## Unindo o trabalho

- git merge
    - Cria commit unindo alterações de diferentes branches
    - Omite commits feitos dentro da branch que ser englobada
    
    ```bash
    git checkout main
    git merge titulo
    ```
    
    ![Untitled](04%20Trabalhando%20em%20equipe/Untitled%204.png)
    
- OBS: o terminal git bash utiliza Vim. Para salvar e sair após alterações: ":x + Enter"

## Atualizando a branch

- Como não “sujar” o log com commits de merge?
- No [https://git-school.github.io/visualizing-git/](https://git-school.github.io/visualizing-git/) vemos a ideia:
    
    ![Untitled](04%20Trabalhando%20em%20equipe/Untitled%205.png)
    
- Diferença entre rebase e merge
    
    > O `merge` junta os trabalhos e gera um `merge commit`. O `rebase` aplica os *commits* de outra *branch* na *branch* atual. Com isso, evitamos os *commits* de *merge*. Há uma longa discussão sobre o que é "melhor": `rebase` ou `merge`. Estude, pesquise, e tire suas róprias conclusões. Aqui tem um artigo (de milhares outros) que cita o assunto:
     [https://medium.com/datadriveninvestor/git-rebase-vs-merge-cc5199edd77c](https://medium.com/datadriveninvestor/git-rebase-vs-merge-cc5199edd77c).
    > 

## Resolvendo conflitos

- Quando há alterações simultâneas no mesmo local do código, o merge não será automatico
- Corrige-se via IDE ou Vim:
    
    ![Untitled](04%20Trabalhando%20em%20equipe/Untitled%206.png)
    
- Após corrigir, é necessário commitar as mudanças
    
    ![Untitled](04%20Trabalhando%20em%20equipe/Untitled%207.png)
    
- Log resultante
    
    ![Untitled](04%20Trabalhando%20em%20equipe/Untitled%208.png)
    
- Caso outra branch queira unir à main agora, terá que trazer as mudanças antes

> SEMPRE dar git pull antes de começar a trabalhar, evitando conflitos.
>