package padroes.chain;

import java.math.BigDecimal;

//Outra condicao
public class DescontoValor extends Desconto {
	
	 public DescontoValor(Desconto next){
	     super(next);
	 }

	 public BigDecimal calculaDesconto(BigDecimal valorDaCompra){
	     // se tiver valor alto recebe 10% de desconto
	     if (valorDaCompra.compareTo(new BigDecimal("500")) >= 0 ){
	         return valorDaCompra.multiply(new BigDecimal("0.1"));
	     } 
	
	     return  next.calculaDesconto(valorDaCompra);
	 }
}