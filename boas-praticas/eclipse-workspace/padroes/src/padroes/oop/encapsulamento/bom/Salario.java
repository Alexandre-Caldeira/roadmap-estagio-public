package padroes.oop.encapsulamento.bom;

import java.math.BigDecimal;

public class Salario {

	private BigDecimal valor;
		
	public Salario(BigDecimal valor) {
		this.valor = valor;
	}

	public boolean isValido(Funcionario funcionario) {
		return valor.compareTo(new BigDecimal("100000")) <= 0 &&
				valor.compareTo(funcionario.getSalario()) >= 0;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
}
