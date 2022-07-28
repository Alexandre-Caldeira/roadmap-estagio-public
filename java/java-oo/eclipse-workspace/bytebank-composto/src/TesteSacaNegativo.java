
public class TesteSacaNegativo {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.deposita(100);
		
		// nao saca negativo
		System.out.println("saca ? " + conta.saca(200));
		System.out.println(conta.getSaldo());
		
		// mas posso manualmente remover:
		// conta.saldo -= 101;
		// System.out.println(conta.saldo); // saldo negativo (-1.0)
		
		// licao: sempre utilizar interfaces e metodos, nunca atributos.
		// Se nao existe interface ou metodo para isso, implemente!
		// => encapsulamento
		

	}
}
