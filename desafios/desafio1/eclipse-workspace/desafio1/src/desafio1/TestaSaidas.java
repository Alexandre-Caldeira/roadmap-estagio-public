package desafio1;

public class TestaSaidas {
	public static void main(String[] args) {
		SessaoUI ss = new SessaoUI(5);
		
		ss.registro.setDado(0, 4);
		ss.registro.setDado(1, 3);
		ss.registro.setDado(2, 8);
		ss.registro.setDado(3, 1);
		ss.registro.setDado(4, 2);
		
		ss.getConsole().setModoDisplay(00);
		ss.getConsole().mostraDados();
	}
}
