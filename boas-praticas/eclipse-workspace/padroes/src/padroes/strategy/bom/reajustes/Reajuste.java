package padroes.strategy.bom.reajustes;

import java.math.BigDecimal;

public interface Reajuste {
	
	public BigDecimal calcula(BigDecimal salario);

}
