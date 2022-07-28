package padroes.chain;

import java.math.BigDecimal;

public abstract class Desconto {
	protected Desconto next;
 
    public Desconto(Desconto next){
        this.next = next;
    }
    
    public abstract BigDecimal calculaDesconto(BigDecimal valorDaCompra);
}
