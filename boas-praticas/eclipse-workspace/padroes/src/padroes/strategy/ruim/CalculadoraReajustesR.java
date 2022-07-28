package padroes.strategy.ruim;

import java.math.BigDecimal;

public class CalculadoraReajustesR {
	
	private TiposReajuste reajuste;

	public CalculadoraReajustesR(TiposReajuste reajuste) {
		this.reajuste = reajuste;
	}

	public BigDecimal calculaReajuste(BigDecimal salario) {
		switch(this.reajuste) {
			case DESEMPENHO:
				return calculaReajusteDesempenho(salario);
				
			case TEMPO:
				return calculaReajusteTempo(salario);
			
			case PROMOCAO:
				return calculaReajustePromocao(salario);
			
			case NENHUM:
				return BigDecimal.ZERO;
			
			default:
				return BigDecimal.ZERO;
		}
				
	}

	private BigDecimal calculaReajustePromocao(BigDecimal salario) {
		return salario.multiply(new BigDecimal("1"));
	}


	private BigDecimal calculaReajusteTempo(BigDecimal salario) {
		return salario.multiply(new BigDecimal("0.2"));
	}


	private BigDecimal calculaReajusteDesempenho(BigDecimal salario) {
		return salario.multiply(new BigDecimal("0.5"));
	}
}
