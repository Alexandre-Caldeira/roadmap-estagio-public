package padroes.strategy.bom.reajustes;

import java.math.BigDecimal;

public class ReajustePromocao implements Reajuste {

	public BigDecimal calcula(BigDecimal salario) {
		return salario.multiply(new BigDecimal("1"));
	}

}
