package exemplo;

import java.util.ArrayList;
import java.util.Scanner;

public class ExemploLeitura {
	public static void main(String[] args) {
		String leitura = "";
		
		Scanner leitor = new Scanner(System.in);
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		for (int iteracao=0; iteracao<5; iteracao++) {
			
			System.out.print("Digite o valor" + iteracao + " >>");
			leitura = leitor.next();
			System.out.println("\n \nIteracao = " + iteracao);
			System.out.println("Eu li: " + leitura);
			
			lista.add(Integer.parseInt(leitura));
			
//			lista.add(leitor.nextInt());
			
		} 
		
		System.out.println("\n\n\n Variavel leitura:" + leitura);
		
		lista.stream().forEach( t -> System.out.println(t));
		
//		for () {
//			soma += cadaElemento
//		}
//		soma = soma/numElementos;
		
	}
}
