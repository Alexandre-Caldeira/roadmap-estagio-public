// obs: note padrao CamelCase para classe
public class TestaVariaveis {

	public static void main(String[] args) {
		System.out.println("Novo teste, ola");
		
		// idade = 37; // não compila pois java = estaticamente tipado
		
		int idade;
		idade = 22;
		
		System.out.println(idade);
		
		idade = 30+10;
		
		System.out.println(idade);
		
		idade = (7*5) + 2; // % / ^
		
		System.out.println(idade);
		
		// concatenacao
		System.out.println("\nA idade é "  + idade + ", parabéns!");
		
		
	}
}
