
public class TestaGetESet {
	public static void main(String[] args) {
		Conta conta = new Conta(001,1337);
		
		// pre-construtor:
		//conta.setNumero(1337);
		//conta.setAgencia(001);
		
		System.out.println("Numero da conta: " + conta.getNumero());		
		System.out.println("Numero da agencia: " + conta.getAgencia());
		
		
		
		// add cliente
		Cliente cliente = new Cliente();
		cliente.setCpf("222.222.222-22");
		cliente.setNome("Paulo Silveira");
		conta.setTitular(cliente);
		System.out.println(conta.getTitular().getNome());
		
		conta.getTitular().setProfissao("Programador");		
		System.out.println(conta.getTitular().getProfissao());
		
		
	}
}
