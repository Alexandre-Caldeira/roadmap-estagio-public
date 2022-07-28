package desafio1;
import java.util.Scanner;

// Recebe 1 numero inteiro e mostra na tela
public class SimplesRecebeArgs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);  
		System.out.print("Digite um inteiro: ");
		
		int n = scanner.nextInt(); 
		// scanner tambem tem:
		// nextBoolean() nextByte() nextDouble() nextFloat()
		// nextLine()	 nextLong() nextShort
		
		scanner.close();
		
		System.out.println("Voce digitou: "+n);
	}
}
