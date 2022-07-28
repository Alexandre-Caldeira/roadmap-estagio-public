package padroes.chain;

import java.math.BigDecimal;

public class Supermercado {
	// outros atributos e metodos
	
	// Dependendo do valor da compra, premia cliente
	public static BigDecimal valorDesconto(BigDecimal valorDaCompra){
		
		Desconto desconto = new DescontoAniversario( new DescontoValor( new SemDesconto() ) );
		return desconto.calculaDesconto(valorDaCompra);
    }
	
	// ...
	public static void main(String[] args) {
		BigDecimal compra = new BigDecimal("400");
		System.out.println("Compra: "+compra+", desconto: "+valorDesconto(compra));
	}

}