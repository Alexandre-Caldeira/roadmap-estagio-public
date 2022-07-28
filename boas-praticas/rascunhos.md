# Strategy

- BAD
``` java
    // ...
    public BigDecimal CalculaImpostos(BigDecimal orcamento) {
        switch (this.tipo):
            case TiposDeImposto.IPVA:
                // Lógica de negócio para cálculo do imposto a partir do orçamento
                valor = calculaIPVA(orcamento);       
                break;
            case TiposDeImposto.IPTU:
                valor = calculaIPTU(orcamento);      
                break;
            case TiposDeImposto.ICMS:
                valor = calculaICMS(orcamento);       
                break;
            case TiposDeImposto.ISS:
                valor = calculaISS(orcamento);            
                break;
            default:
                // throw ImpostoInexistenteException("Tipo de imposto inexistente!")
                break;

        return valor;
    }
    // ...
```

- GOOD
``` java
    // ...
    public BigDecimal CalculaImpostos(BigDecimal orcamento, Imposto imposto) {
        // IoC + polimorfismo => sem ifs!
        return imposto.calcula(valor);
    }
    // ...
```