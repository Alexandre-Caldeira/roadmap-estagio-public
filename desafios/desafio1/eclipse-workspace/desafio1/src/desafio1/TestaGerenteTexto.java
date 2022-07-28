package desafio1;

public class TestaGerenteTexto {
	public static void main(String[] args) {
		SessaoUI ss = new SessaoUI(5);
		GerenteTexto gtxt = new GerenteTexto(ss);
		
		ss.registro.setDado(0, 4);
		ss.registro.setDado(1, 3);
		ss.registro.setDado(2, 8);
		ss.registro.setDado(3, 1);
		ss.registro.setDado(4, 2);
		
		gtxt.setCaminhoPadrao("C:\\Users\\alexa\\Desktop\\");
		gtxt.salvaResultado("meuTeste");
		System.out.println(gtxt.calculaMedia());
	}
}
