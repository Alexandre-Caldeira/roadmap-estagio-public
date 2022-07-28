
public class TestaValores {
	public static void main(String[] args) {
		Conta conta = new Conta(231,39845);
		
		// conta estava inconsistente
		//conta.setAgencia(-231);
		//conta.setNumero(-39845);
		//System.out.println(conta.getAgencia());
		
		Conta conta2 = new Conta(42,conta.getNumero()+1);
		Conta conta3 = new Conta(conta2.getAgencia(),conta2.getNumero()+1);
		
		System.out.println("Total de contas: " +Conta.getTotal());
		
	}
}
