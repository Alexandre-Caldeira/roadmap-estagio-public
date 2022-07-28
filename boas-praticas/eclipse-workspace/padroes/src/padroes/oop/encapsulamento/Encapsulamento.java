package padroes.oop.encapsulamento;

import java.math.BigDecimal;

import padroes.oop.encapsulamento.bom.Funcionario;
import padroes.oop.encapsulamento.bom.Salario;
import padroes.oop.encapsulamento.ruim.FuncionarioR;

public class Encapsulamento {
	public static void main(String[] args) {
		
		// Private nao significa encapsulado!
		FuncionarioR malandro = new FuncionarioR(new BigDecimal("1000"));
		malandro.setSalario(new BigDecimal("999999999999999"));
		
		// Encapsulamento sem buracos:
		Funcionario mane = new Funcionario(new Salario(new BigDecimal("1000")));
//		mane.setSalario(new Salario(new BigDecimal("999999999999999"))); // Retorna excecao!
		mane.setSalario(new Salario(new BigDecimal("1200")));
		
		
		System.out.println(malandro.getSalario());
		System.out.println(mane.getSalario());
	}
}
