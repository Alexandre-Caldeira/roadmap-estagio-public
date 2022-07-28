package padroes.oop.encapsulamento.ruim;

import java.math.BigDecimal;

public class FuncionarioR {
	// outros atributos...
	private BigDecimal salario;
	
	public FuncionarioR(BigDecimal salarioInicial) {
		this.salario = salarioInicial;
	}

	public BigDecimal getSalario(){ 
		return this.salario;
	}

	public void setSalario(BigDecimal novoSalario){
		this.salario = novoSalario;
	}
		
	// construtor, outros getters e setters...

}
