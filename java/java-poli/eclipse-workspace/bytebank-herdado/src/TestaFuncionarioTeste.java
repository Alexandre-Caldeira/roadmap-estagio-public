
public class TestaFuncionarioTeste {
	public static void main(String[] args) {
		FuncionarioTeste f1 = new FuncionarioTeste();
		f1.setSalario(3000.0);

		System.out.println(f1.getTipo());
		System.out.println(f1.getBonificacao()+"\n");

		// para Diretores:
		FuncionarioTeste f2 = new FuncionarioTeste();
		f2.setSalario(5000.0);
		f2.setTipo(2);
		
		System.out.println(f2.getTipo());
		System.out.println(f2.getBonificacao()+"\n");

	}
}
