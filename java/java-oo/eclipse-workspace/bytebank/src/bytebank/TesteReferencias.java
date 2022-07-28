package bytebank;

public class TesteReferencias {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 300;
		
		System.out.println("saldo da primeira: "+ primeiraConta.saldo);
		
		// objetos sempre sao passados por referencia
		// pois o java nao guarda objetos por valor
		Conta segundaConta = primeiraConta;
		
		System.out.println("saldo da segunda: "+ segundaConta.saldo);
		
		segundaConta.saldo += 100;
		System.out.println("novo saldo da segunda: "+ segundaConta.saldo);
		
		System.out.println("tambem atualizou saldo da primeira: "+primeiraConta.saldo);
		
		if (primeiraConta == segundaConta) {
			System.out.println("sao a mesmissima coisa");
			System.out.println(primeiraConta);
			System.out.println(segundaConta);
		}
	}
}
