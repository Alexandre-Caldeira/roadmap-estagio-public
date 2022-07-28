
public class TestaFuncionario {
	public static void main(String[] args) {
		
		// como regra, o compilador insere construtor padrao na ausencia de um
		// Funcionario nico = new Funcionario(); // virou abstrato
		Gerente nico = new Gerente();
		nico.setNome("Nico Steppat");
		nico.setCpf("111.111.111-11");
		nico.setSalario(2590.00);
		
		System.out.println("Funcionario: "+nico.getNome());
		System.out.println("Bonificacao: "+nico.getBonificacao());
		
		
		
	}
}
