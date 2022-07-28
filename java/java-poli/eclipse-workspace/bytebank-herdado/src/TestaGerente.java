
public class TestaGerente {
	public static void main(String[] args) {
		Gerente g1 = new Gerente();
		g1.setNome("Marco");
		g1.setCpf("111.111.111-11");
		g1.setSalario(5000.0);
		g1.setSenha(2222);
		
		System.out.println(g1.getNome());
		System.out.println(g1.getCpf());
		System.out.println(g1.getSalario());
		
		boolean autenticou = g1.autentica(2222);
		System.out.println(autenticou);	
		
		System.out.println(g1.getBonificacao());
	}
}
