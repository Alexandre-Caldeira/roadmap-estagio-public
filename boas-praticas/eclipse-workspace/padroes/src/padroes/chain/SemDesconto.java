package padroes.chain;

import java.math.BigDecimal;

public class SemDesconto extends Desconto {
	
	public SemDesconto(){
        super(null);
    } 

	@Override 
    public BigDecimal calculaDesconto(BigDecimal valorDaCompra){
        return BigDecimal.ZERO;
    }

}
