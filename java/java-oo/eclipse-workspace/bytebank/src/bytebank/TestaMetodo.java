package bytebank;

public class TestaMetodo {
	public static void main(String[] args) {
		Conta contaDoPaulo = new Conta();
		contaDoPaulo.saldo = 100;
		double valorDepositar = 50;
		
		if(contaDoPaulo.deposita(valorDepositar)) {
			System.out.println("Depositou "+valorDepositar+" com sucesso!");
		}else {
			System.out.println("Falha! Verificar conta e valor a depositar.");
		}	
		
		System.out.println("Saldo atual: "+ contaDoPaulo.saldo);
		
		// nao necessariamente voce precisa receber/guardar o retorno do metodo
		contaDoPaulo.saca(20);
		System.out.println("Saldo apos saque: " + contaDoPaulo.saldo);
		
		
		// Transferindo para Paulo:
		Conta contaDaMarcela = new Conta();
		
		System.out.println("Conta criada, saldo: "+ contaDaMarcela.saldo);
		
		if(contaDaMarcela.deposita(1000))
			System.out.println("Deposito efetivado, saldo: "+ contaDaMarcela.saldo);
		
		if(contaDaMarcela.transfere(contaDoPaulo, 500)) {
			System.out.println("Transferencia completa!");
			System.out.println("Saldo da Marcela: "+ contaDaMarcela.saldo);
			System.out.println("Saldo do Paulo: "+ contaDoPaulo.saldo);
		}
		
		
	}
}
