package padroes.strategy.bom;

import java.math.BigDecimal;

import padroes.strategy.bom.reajustes.Reajuste;

public class CalculadoraReajustes {
	
	public static BigDecimal calculaImposto(BigDecimal valor, Reajuste reajuste) {
		return reajuste.calcula(valor);
	}

}
