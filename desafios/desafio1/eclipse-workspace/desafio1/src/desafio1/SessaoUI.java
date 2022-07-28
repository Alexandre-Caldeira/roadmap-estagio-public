package desafio1;


public class SessaoUI {
	public String nomeDaSessao = "Sessao Radix";
	public int idSessao = 0;
	public static int numDeSessoes;
	protected Registro registro;
	private GerenteConsole console;
	
	
	// Construtor depende do numeroDeDados para instanciar Registro
	public SessaoUI(int numeroDeDados) {
		idSessao = numDeSessoes++;
		System.out.println("\nIniciando " +nomeDaSessao+" #"+idSessao+".");
		registro = Registro.getRegistro(numeroDeDados);		
		console = new GerenteConsole(this);		
	}
	
	// getters e setters
	public GerenteConsole getConsole() {
		return console;
	}
	
}

