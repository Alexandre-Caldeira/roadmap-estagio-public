
public class TestaReferencias {
	public static void main(String[] args) {
		 // Funcionario g1 = new Gerente(); // polimorfismo
		// g1.autentica(2222);	// nao consegue chamar o metodo devido ao tipo da referencia
		// g1.setNome("Marcos");
		// String nome = g1.getNome();		
		// System.out.println(nome);
		
		 // Funcionario f1 = new Funcionario();	// nao deveria funcionar 
		 // f1.setSalario(2000.0);				// Funcionario devia ser abstrata
		 
		 Gerente g1 = new Gerente();
		 g1.setNome("Marcos");
		 g1.setSalario(5000.0);
		 
		 Designer d = new Designer();
		 d.setSalario(2000.0);
		 
		 EditorVideo ev = new EditorVideo();
		 ev.setSalario((2500.0));
		 
		 ControleBonificacao controle = new ControleBonificacao();
		 
		 controle.registra(g1);
		 // controle.registra(f1);
		 controle.registra(ev);
		 
		 System.out.println(controle.getSoma());
		 
		 
	}
}
