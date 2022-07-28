
public class TestaBanco {
	public static void main(String[] args) {
		Cliente paulo = new Cliente();
		paulo.nome = "Paulo Silveira";
		paulo.cpf = "222.222.222-22";
		paulo.profissao = "programador";
		
		Conta contaDoPaulo = new Conta();
		contaDoPaulo.titular = paulo;
		contaDoPaulo.deposita(100);
		
		System.out.println("Agencia: " + contaDoPaulo.agencia);
		System.out.println("Titular: " + contaDoPaulo.titular.nome);
		System.out.println("Saldo: "+ contaDoPaulo.getSaldo());
		
	}
}
