package desafio1;

// Referencia https://refactoring.guru/pt-br/design-patterns/singleton/java/example

public final class Registro {
	private static Registro instancia;
	private int[] dadosInformados;
	
	// Construtor privado proibe criacao "desregrada" de instancias
	private Registro(int numeroDeDados) {
		System.out.println("Construindo registro para receber "+numeroDeDados+ " dados.");
		this.dadosInformados = new int[numeroDeDados];
	}
	
	// Controla criancao de instancias, chama construtor: 
	public static Registro getRegistro(int numeroDeDados) {
		if (instancia == null) {
			instancia = new Registro(numeroDeDados);
		}
		
		return instancia;
	}
	
	// getters e setters
	// Retorna ponteiro (referencia)
	public int[] getDadosInformados() {	
		return dadosInformados;
	}
	// Extra: devolve apenas 1 dado
	public int getDado(int indice) { 
		return dadosInformados[indice];
	}
	// BR: Somente pode-se alterar 1 dado por vez.
	public boolean setDado(int indice,int valor) { 
		if (valor < 0 || valor > 10) {
			System.out.println("Dado submetido fora dos limites!");
			return false;
		} else {
			if (indice < this.getDadosInformados().length && indice >= 0) {
				this.getDadosInformados()[indice] = valor;
				// GerenteDeDados.media += dado;
				return true;
			} else {
				System.out.println("Posicao invalida para inserir dado!");
				return false;
			}
		}
	}
	
}
