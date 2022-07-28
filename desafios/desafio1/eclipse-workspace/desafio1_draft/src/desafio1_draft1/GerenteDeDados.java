package desafio1_draft1;

import java.util.Arrays;

public class GerenteDeDados {
	private static int numDados;	// Tamanho do arranjo de inteiros a ser lido/preenchido
	private static int dadosInformados[];	// Arranjo que recebera os dados 
	private int modoDisplay = 0;	// Modo opcional de mostrar dados
	private static double media = 0;
	
	// Construtor para inicializar gerente e arranjo:
	public GerenteDeDados(int tamanhoEntrada) {
		System.out.println("Inicializando gerente de dados com "+tamanhoEntrada+" elementos.");
		
		GerenteDeDados.setNumDados(tamanhoEntrada);
		this.setDadosInformados(this.getDadosInformados(), GerenteDeDados.numDados);
	}
	
	// Implementa logica de negocio para receber dados de forma segura:
	public boolean setDado(int dado, int indice) {
		if (dado < 0 || dado > 10) {
			System.out.println("Dado submetido fora dos limites!");
			return false;
		}else {
			if (indice < GerenteDeDados.numDados && indice >= 0) {
				this.getDadosInformados()[indice] = dado;
				GerenteDeDados.media += dado;
				return true;
			} else {
				System.out.println("Posicao invalida para inserir dado!");
				return false;
			}
		}
	}
	
	// Calcula media:
	public static double getMedia() {
		return media/((double) GerenteDeDados.numDados);
	}
	
	public static void setNumDados(int numDados) {
		// Acessa atributo estatico para redefinir para todas as instancias:
		GerenteDeDados.numDados = numDados;
	}
	public static int getNumDados() {
		return numDados;
	}
	
	public void setDadosInformados(int[] dadosInformados, int numDados) {
		// Constroi arranjo de dados
		this.dadosInformados = new int[numDados];
	}	
	public int[] getDadosInformados() {
		// Retorna refencia ao arranjo de dados completo:
		return dadosInformados;
	}
	public int getDado(int indice) {
		// Retorna unico dado na posicao desejada:
		return this.getDadosInformados()[indice];
	}	
	
	
	public void mostraDados() {
		if (this.getModoDisplay() != 0) {	
			// Caso usuario desejar saida "bonita":
			System.out.println(Arrays.toString(this.getDadosInformados()));
		} else {								
			// Modo padrao, definido no desafio:
			for(int c = 0; c < GerenteDeDados.numDados; c++) {
				System.out.print(this.getDadosInformados()[c]+" ");
			}
			System.out.print(GerenteDeDados.getMedia()+"\n");
		}
	}
	public void setModoDisplay(int modo) {
		this.modoDisplay = modo;
	}
	public int getModoDisplay() {
		return modoDisplay;
	}
	
}
