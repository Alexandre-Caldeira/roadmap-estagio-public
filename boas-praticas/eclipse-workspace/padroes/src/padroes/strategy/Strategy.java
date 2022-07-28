package padroes.strategy;

import java.math.BigDecimal;

import padroes.strategy.bom.CalculadoraReajustes;
import padroes.strategy.bom.reajustes.ReajusteDesempenho;
import padroes.strategy.ruim.CalculadoraReajustesR;
import padroes.strategy.ruim.TiposReajuste;

public class Strategy {
	public static void main(String[] args) {

		BigDecimal salarioAtual = new BigDecimal("1000");
		
		// RUIM
		CalculadoraReajustesR calculadoraRuim = new CalculadoraReajustesR(TiposReajuste.DESEMPENHO);
		BigDecimal reajusteR = calculadoraRuim.calculaReajuste(salarioAtual);
		System.out.println(reajusteR);
		
		// BOM
		BigDecimal reajuste = CalculadoraReajustes.calculaImposto(salarioAtual, new ReajusteDesempenho());
		System.out.println(reajuste);
	}
}
