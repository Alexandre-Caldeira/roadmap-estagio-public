package desafio1;

import java.io.IOException;

public class Curiosidade {
	public static void main(String[] args) throws IOException{
		// Cria sessao e gerentes:
		
		SessaoUI ss =null; //TODO refator later!
		if (args.length>0) {
			ss = new SessaoUI(Integer.parseInt(args[0]));
		}else {
			ss = new SessaoUI(5);
		}
		
		GerenteTabela gtab = new GerenteTabela(ss);
		GerenteTexto gtxt = new GerenteTexto(ss);
		
		// Recebe dados:
		if (args.length>1) {
			ss.getConsole().setModoDisplay(Integer.parseInt(args[1]));
		}else {
			ss.getConsole().setModoDisplay(10);
		}
		ss.getConsole().receberDados();
		
		// Apresenta e salva: 4 3 8 1 2
		//gtab.setCaminhoPadrao("C:\\Users\\alexandre.caldeira\\OneDrive - RADIX ENGENHARIA E DESENVOLVIMENTO DE SOFTWARE S A (ISV)\\Área de Trabalho\\");
		gtab.setCaminhoPadrao("");
		gtxt.setCaminhoPadrao(gtab.getCaminhoPadrao());
		
		salvarResultado(gtab);
		salvarResultado(gtxt);
		ss.getConsole().mostraDados();
	}
	
	public static void salvarResultado(Escritor escritor) throws IOException{
		escritor.salvaResultado("saida");
	}
	
}
