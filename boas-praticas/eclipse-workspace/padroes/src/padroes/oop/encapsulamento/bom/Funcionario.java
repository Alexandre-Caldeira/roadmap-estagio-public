package padroes.oop.encapsulamento.bom;

import java.math.BigDecimal;

public class Funcionario {
	// outros atributos...
	private Salario salario;
	
	public Funcionario(Salario salarioInicial) {
		this.salario = salarioInicial;
	}
	
	public BigDecimal getSalario(){ 
		return salario.getValor();
	}

	public void setSalario(Salario novoSalario){
		if(novoSalario.isValido(this)){
			this.salario = novoSalario;
		} else {
			throw new RuntimeException("Salário inválido!");
		}
	}

	// construtor, outros getters e setters...

}
