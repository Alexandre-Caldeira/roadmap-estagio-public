package desafio1;

public class TestaGerenteTabela {
	public static void main(String[] args) {
		SessaoUI ss = new SessaoUI(5);
		GerenteTabela gtab = new GerenteTabela(ss);
		
		ss.registro.setDado(0, 4);
		ss.registro.setDado(1, 3);
		ss.registro.setDado(2, 8);
		ss.registro.setDado(3, 1);
		ss.registro.setDado(4, 2);
		
		gtab.setCaminhoPadrao("C:\\Users\\alexa\\Desktop\\");
		gtab.salvaResultado("meuTeste");
		System.out.println(gtab.calculaMedia());
	}
}
