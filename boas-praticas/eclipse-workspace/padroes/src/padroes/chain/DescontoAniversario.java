package padroes.chain;

import java.math.BigDecimal;
import java.time.LocalDate;

//Uma condicao
public class DescontoAniversario extends Desconto {
	public DescontoAniversario(Desconto next){
	    super(next); 
	} 

	public BigDecimal calculaDesconto(BigDecimal valorDaCompra){
	     // se for aniversario do supermercado, recebe 20% de desconto
	    if ( LocalDate.now().equals(LocalDate.of(2022, 04, 18)) ){
	        return valorDaCompra.multiply(new BigDecimal("0.2"));
	    }
	
	    return  next.calculaDesconto(valorDaCompra);
	}
}