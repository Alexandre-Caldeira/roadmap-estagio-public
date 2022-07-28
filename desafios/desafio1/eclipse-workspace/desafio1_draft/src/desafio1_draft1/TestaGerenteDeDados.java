package desafio1_draft1;


public class TestaGerenteDeDados {
	public static void main(String[] args) {
		
		// Cria gerente de dados para receber 5 numeros apenas
		GerenteDeDados gdg = new GerenteDeDados(5);
		
		gdg.mostraDados();
		
		// System.out.println(GerenteDeDados.dadosInformados);
		// gdg.numDados = 6;		
		// The field GerenteDeDados.numDados is not visible!
		// Uso de private evita implementações contra a logica de negocios.
				
		gdg.setDado(4, 0);		// Insere valor 4 na posicao (correto)
		gdg.setDado(5, -2);		// Tenta inserir em posicao negativa
		gdg.setDado(1, 6);		// Tenta inserir em posicao acima do limite 
		gdg.setDado(-2, 4);		// Tenta inserir valor negativo
		gdg.setDado(11, 3);		// Tenta inserir valor acima do limite  
		gdg.setDado(10, 1);		// Insere 10 na posicao 1 (correto)
		gdg.setDado(7, 3);
		
		// Acessando valor por referencia:
		System.out.println("Mostrando somente o penultimo elemento: "+gdg.getDadosInformados()[3]);
		
		// Acessando valor por metodo:
		System.out.println("Mostrando somente o segundo elemento: "+gdg.getDado(1));
		
		// Apresentando de modo alternativo:
		gdg.setModoDisplay(1);
		gdg.mostraDados();
		
	}
}
