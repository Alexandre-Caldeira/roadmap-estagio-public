package br.com.bytebank.banco.test;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorDeReferencias;

public class OutroTeste {

	public static void main(String[] args) {
		GuardadorDeReferencias guardador = new GuardadorDeReferencias();
		
		Conta cc = new ContaCorrente(42, 1);
		guardador.adiciona(cc);
		
		Conta cc2 = new ContaCorrente(42, 2);
		guardador.adiciona(cc2);
		
		int tamanho = guardador.getQuantidadeDeElementos();
		System.out.println(tamanho);
		
		Conta ref = (Conta) guardador.getReferencia(0);
		System.out.println(ref.getNumero());
		
	}

}
