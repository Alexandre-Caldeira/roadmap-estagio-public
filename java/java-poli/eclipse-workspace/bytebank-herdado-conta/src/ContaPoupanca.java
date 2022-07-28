
public class ContaPoupanca extends Conta {
	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);	// chama construtor da classe mae
	}							// nao se herda construtores
	
	@Override
	public void deposita(double valor) {
		super.saldo += valor;
	}
}
