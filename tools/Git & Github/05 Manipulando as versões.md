# 05. Manipulando as versões

## Ctrl+Z no Git

- É possível remover um arquivo do stage após um “git add meuArquivo”
    
    ```bash
    git reset HEAD meuArquivo
    ```
    
    ```bash
    git checkout -- meuArquivo
    ```
    
- É possível também voltar atrás em commits anteriores, retornando a versões antigas do código
    
    ```bash
    git log
    ```
    
    - Após encontrar o hash (e.g. 999A99a9a9) que identifica o commit:
    
    ```bash
    git revert 999A99a9a9
    ```
    
    - Gerando outro commit que reverte o anterior

## Desfazendo o trabalho

- Quais os comandos, respectivamente, desfazem alterações antes de adicioná-las (1); depois de adicioná-las, mas antes de *commitá-las*  (2); e após realizar o *commit*  (3)?
    
    1 - `git checkout`
    
    2 - `git reset`
    
    3 - `git revert`
    
    > Com o `git checkout` nós desfazemos uma alteração que ainda não foi adicionada ao `index` ou `stage`, ou seja, antes do `git add`. Depois de adicionar com `git add`, para desfazer uma alteração, precisamos tirá-la deste estado, com `git reset`. Agora, se já realizamos o `commit`, o comando `git revert` pode nos salvar.
    > 

## Guardando para depois

- `git stash`: salva alterações em um local temporário
- Gera um hash, que pode ser buscado com `git stash list`
- É possível “voltar” ao stash com `git stash apply **NUM. DA STASH**`
- `git stash pop` tira da stash a última alteração e traz para a working tree
- `git stash drop` remove uma stash

## Viajando no tempo

- É possível navegar para um commit via `git checkout **HASHdoCOMMIT**`
- Obs: alterações irão para uma branch inexistente (detached head)
- Para evitar isso, será necessário:
    - `git checkout **HASHdoCOMMIT**`
    - `git checkout -b nova-branch`
    - Agora, alterações serão salvas

## Resumo

> Vimos que:
> 
> - Que o Git pode nos ajudar a desfazer alterações que não vamos utilizar;
> - Que, para desfazer uma alteração antes de adicioná-la para `commit` (com `git add`), podemos utilizar o comando `git checkout -- <arquivos>`;
> - Que, para desfazer uma alteração após adicioná-la para `commit`, antes precisamos executar o `git reset HEAD <arquivos>` e depois podemos desfazê-las com `git checkout -- <arquivos>`;
> - Que, para revertermos as alterações realizadas em um `commit`, o comando `git revert` pode ser a solução;
> - Que o comando `git revert` gera um novo `commit` informando que alterações foram desfeitas;
> - Que, para guardar um trabalho para retomá-lo posteriormente, podemos utilizar o `git stash`;
> - Que, para visualizar quais alterações estão na `stash`, podemos utilizar o comando `git stash list`;
> - Que, com o comando `git stash apply <numero>`, podemos aplicar uma alteração específica da `stash`;
> - Que o comando `git stash drop <numero>` remove determinado item da `stash`;
> - Que o comando `git stash pop` aplica e remove a última alteração que foi adicionada na `stash`;
> - Que o `git checkout` serve para deixar a cópia do código da nossa aplicação no estado que desejarmos:
>     - `git checkout <branch>` deixa o código no estado de uma `branch` com o nome `<branch>`;
>     - `git checkout <hash>` deixa o código no estado do *commit* com o hash `<hash>`.