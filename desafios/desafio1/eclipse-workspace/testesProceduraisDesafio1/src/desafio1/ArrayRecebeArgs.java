package desafio1;

import java.util.Scanner;

// Calcula media de 5 numeros inteiros digitados no console
public class ArrayRecebeArgs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 	// construtor recebe System.in
													// (input stream)
		
		int dadosInformados[] = new int[5];			// declarar array para os dados
													// com tamanho ja delimitado
		double acumulaMedia = 0;
		
		System.out.print("Digite 5 numeros: ");
		for (int i=0; i<5; i++) { 					
			int novoNum = scanner.nextInt();		// podem ser enviados 1 por 1
			acumulaMedia += novoNum;				// ou todos de uma vez
			dadosInformados[i]= novoNum;
		}
		
		System.out.println("Foram informados: ");
		for (int j=0; j<5; j++) { 
			 System.out.print(dadosInformados[j]+" ");
		}
		System.out.println("\nMedia: " + acumulaMedia/5);
		
	}
}
