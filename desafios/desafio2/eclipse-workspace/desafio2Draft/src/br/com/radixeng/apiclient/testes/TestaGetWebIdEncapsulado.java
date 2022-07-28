package br.com.radixeng.apiclient.testes;



import java.util.Scanner;

import br.com.radixeng.apiclient.modelo.HttpRequester;
import br.com.radixeng.apiclient.modelo.TesterTag;

public class TestaGetWebIdEncapsulado {
	public static void main(String[] args) {
		HttpRequester requeridor = new HttpRequester();
		
		try (Scanner scanner = new Scanner(System.in)) {
			String result = scanner.hasNext() ? scanner.next() : "";
			
			TesterTag tagAtual = new TesterTag(result.toUpperCase().trim());

			tagAtual.setWebId(requeridor.getWebId(tagAtual.getNome()));

			System.out.println("WebId: \n\n\t"+ tagAtual.getWebId());
		}
	}

}
