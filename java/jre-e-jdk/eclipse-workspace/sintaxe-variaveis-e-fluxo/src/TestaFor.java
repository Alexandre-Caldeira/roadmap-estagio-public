
public class TestaFor {
	public static void main(String[] args) {
		int total = 0;	// declarando fora do escopo do for
						// para mostrar ao final
		for (int contador = 0; contador<=10 ; contador++) {
			System.out.println("Iteracao = " + contador);
			total += contador;
		}
		System.out.println(total);
	}
}
