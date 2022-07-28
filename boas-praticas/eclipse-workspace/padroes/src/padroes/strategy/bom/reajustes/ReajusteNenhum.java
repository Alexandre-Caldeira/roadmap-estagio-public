package padroes.strategy.bom.reajustes;

import java.math.BigDecimal;

public class ReajusteNenhum implements Reajuste {

	public BigDecimal calcula(BigDecimal salario) {
		return BigDecimal.ZERO;
	}

}
