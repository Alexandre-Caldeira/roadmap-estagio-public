
public class TestaEscopo {
	
	public static void main(String[] args) {
		System.out.println("testando condicionais");

		int idade = 20;
		int quantidadePessoas = 1;
		boolean acompanhado = true; // precisa ser declarada aqui
		
		if (quantidadePessoas >= 2){
			acompanhado = true;		// se fosse declarada aqui, nao  
		}							// poderia ser usada fora do if
		else {
			acompanhado = false;			
		}
		
		if (idade >= 18 && acompanhado) {
			System.out.println("seja bem vindo");
		}
		else {
			System.out.println("infelizmente voce nao pode entrar");
		}
			
	}
}
