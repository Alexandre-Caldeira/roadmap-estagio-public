
public class TestaCaracteres {

	public static void main(String[] args) {
		char letra = 'a'; // Não compila com "a" nem 'aa'. Só 1 (um) char!
		System.out.println(letra); // retorna a
		
		char valor = 65;
		System.out.println(valor);
				
		// char valor = valor + 1; // Não "cabe"
		valor = (char)(valor+1);
		System.out.println(valor);
		
		String palavra = "Radix Engenharia e Software";
		System.out.println(palavra);
		
		palavra += 2020;
		System.out.println(palavra);
		
	}
}
