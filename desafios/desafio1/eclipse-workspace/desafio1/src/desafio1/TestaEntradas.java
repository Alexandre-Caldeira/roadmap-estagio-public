package desafio1;

public class TestaEntradas {
	public static void main(String[] args) {
		// Cria sessao e gerentes:
		SessaoUI ss = new SessaoUI(5);
		GerenteTabela gtab = new GerenteTabela(ss);
		GerenteTexto gtxt = new GerenteTexto(ss);
		
		// Recebe dados:
		ss.getConsole().setModoDisplay(10);
		ss.getConsole().receberDados();
		
		// Apresenta e salva: 4 3 8 1 2
		gtab.setCaminhoPadrao("C:\\Users\\alexa\\Desktop\\");
		gtxt.setCaminhoPadrao(gtab.getCaminhoPadrao());

		gtab.salvaResultado("saida");
		gtxt.salvaResultado("saida");
	}
}
