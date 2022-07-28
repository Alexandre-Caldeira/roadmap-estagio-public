package desafio1;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

// Exporta 5 inteiros e sua media em formato txt e na tela do console
public class ArraySalvaArgs {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);// Instanciando objetos e variaveis
		int dadosInformados[] = new int[5];		 // tamanho fixo evita aloc. dinamica	
		double acumulaMedia = 0;
	
		// Recebe 5 valores inteiros via console
		// ASSUME USUARIO "AMIGAVEL"!
		System.out.print("Digite 5 numeros: ");
		for (int i=0; i<5; i++) { 
			int novoNum = scanner.nextInt();	
			acumulaMedia += novoNum;
			dadosInformados[i]= novoNum;
		}
	
		// Apresentando resultados na tela e salvando para .txt:
		FileWriter writer = new FileWriter("saida.txt"); 

		System.out.print("Foram recebidos: ");		
		for (int j=0; j<5; j++) { 
			System.out.print(dadosInformados[j]+" ");
			writer.write(dadosInformados[j]+" ");
		}
		
		// Calcula media, upcast para string 
		acumulaMedia /= 5;
		String mediaSaida = Double.toString(acumulaMedia);
		
		// Escreve nas saidas
		writer.write(mediaSaida);
		System.out.println("\nMedia: " + mediaSaida);
		
		writer.close();
		
	}
	
}
