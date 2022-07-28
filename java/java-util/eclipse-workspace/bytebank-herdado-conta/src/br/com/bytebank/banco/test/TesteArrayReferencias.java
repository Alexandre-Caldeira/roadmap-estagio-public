package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.Conta;

public class TesteArrayReferencias {

	public static void main(String[] args) {
		Object[] referencias = new Object[5];
		
		System.out.println(referencias);
		System.out.println(referencias[1]); //null
		
		ContaCorrente cc1 = new ContaCorrente(42, 1);	
		referencias[0] = cc1;
		System.out.println(referencias[0]);
		
		ContaPoupanca cc2 = new ContaPoupanca(42, 2);
		referencias[1]= cc2;
		
		System.out.println(((Conta) referencias[1]).getNumero());
		
		// cast de referencia
		ContaPoupanca ref = (ContaPoupanca) referencias[1];
		System.out.println(ref.getNumero());
		
	}

}
