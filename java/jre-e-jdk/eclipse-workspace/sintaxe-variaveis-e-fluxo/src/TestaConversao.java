
public class TestaConversao {

	public static void main(String[] args) {
<<<<<<< HEAD
		double salario = 1270.50;
		int valor = (int) salario; // casting
=======
		
		double salario = 1270.50;
		int valor = (int) salario; // casting
		
>>>>>>> fe210d582175c63327783e337706605aa9217dc7
		System.out.println(valor);
		
		// alguns outros tipos e curiosidade:
		long numerogrande = 32432423523L;
		
		double valor1 = 0.2;
		double valor2 = 0.1;
		double total = valor1 + valor2;
		
		System.out.println(total);	// 0.30000000000000004 => IEEE
									// 0.30000000000000004.com
		
		// por isso, recomenda-se:
		float pontoFlutuante1 = (float) 3.14;
		
		// ou tammbém:
		float pontoFlutuante2 = 3.14f;
		
		// mas não:
		// float pontoFlutuanteErrado = 3.14; // type mismatch
		
		System.out.println(pontoFlutuante1);
		System.out.println(pontoFlutuante2);
	}
}
