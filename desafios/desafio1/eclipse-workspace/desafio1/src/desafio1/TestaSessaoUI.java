package desafio1;

public class TestaSessaoUI {
	public static void main(String[] args) {
		// Instancia sessao e singleton de dados
		SessaoUI ss = new SessaoUI(3);
		
		ss.registro.setDado(0, 1);
		ss.registro.setDado(2, 1);
		ss.getConsole().mostraDados();
		
		ss.getConsole().setModoDisplay(01);
		ss.getConsole().mostraDados();
		
		SessaoUI outraSS = new SessaoUI(5); // Nao reconstroi registro
		outraSS.getConsole().mostraDados();
		
		System.out.println("\n"+ss.getConsole());
		System.out.println(outraSS.getConsole());
				
		
	}
}
