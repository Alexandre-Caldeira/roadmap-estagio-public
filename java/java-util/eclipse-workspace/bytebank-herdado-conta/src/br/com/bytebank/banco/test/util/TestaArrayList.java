package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TestaArrayList {
	public static void main(String[] args) {
	
		ArrayList<Conta> lista = new ArrayList();
		
		System.out.println(lista.size());
		
		Conta cc = new ContaCorrente(42, 1);
		lista.add(cc);
		
		Cliente cliente = new Cliente();
//		lista.add(cliente);		// proibido pois a lista eh tipada
//		lista.add("");
		
		
		Conta cc2 = new ContaCorrente(42, 2);
		lista.add(cc2);
		
		int tamanho = lista.size();
		System.out.println("Tamanho antes de remover: "+tamanho);
		
		Conta ref = (Conta) lista.get(0);
		System.out.println(ref.getNumero());

		lista.remove(0);
		System.out.println("Tamanho apos remover: "+lista.size());
		
		Conta cc3 = new ContaPoupanca(42, 3);
		lista.add(cc3);
		Conta cc4 = new ContaCorrente(42, 4);
		lista.add(cc4);
		
		for(int i = 0; i < lista.size(); i++) {
//			System.out.println(lista.get(i));
			Object oRef = lista.get(i);
			System.out.println(oRef);
		}
		
		System.out.println("\n ------------- \n");
		
//		for(Object oRef: lista) {	// enhanced for itera para cada elemento
//			System.out.println(oRef);
//		}
		
		// Com lista tipada fica mais claro/expressivo:
		for(Conta conta: lista) {
			System.out.println(conta);
		}
	}
}
