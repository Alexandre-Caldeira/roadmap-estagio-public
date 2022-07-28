# 06. Gerando entregas

## Vendo as alterações

- É possível gerar um sumário dos commits e mudanças:
    - `git diff **Hash1**..**Hash2**`
    - Onde **Hash1** e **Hash2** são hashes de dois commits, entre os quais queremos ver as diferenças

## Tags e releases

- Utilizando um hash de commit, é possível gerar uma tag para marcar pontos na aplicação
- Pontos que não podem ser alterados, similar ao lançamento de uma versão
- Para isso, usa-se `git tag -a nomeDaTag -m "mensagem opcional da tag"`
- Agora, será gerada uma release no github ao pushar, que poderá ser baixada