package bytebank;

class Conta {
	double saldo;
	int agencia = 42;
	int numero;
	String titular;
	
	public boolean deposita(double valorDeposito) {
		boolean depositou = false;
		
		if (valorDeposito >= 0.01) {
			this.saldo += valorDeposito;
			depositou = true;
		}
		
		return depositou;
	}
	
	public boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean transfere(Conta destino, double valor) {
		boolean result = false;
		
		if (this.saca(valor)) {
			destino.saldo += valor;
			result = true;
		}
		
		return result;
	}
	
}