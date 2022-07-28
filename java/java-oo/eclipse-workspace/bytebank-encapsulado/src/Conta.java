
class Conta {
	private double saldo;
	private int agencia = 42;
	private int numero;
	private Cliente titular;
	private static int total;	// total de contas, compartilhado
								// entre classes do tipo Conta
	
	// Construtor:
	public Conta(int agencia, int numero) {
		this.agencia = agencia;
		this.numero = numero;
		System.out.println("Estou criando a conta: "+ this.numero);
		
		Conta.total++;
		System.out.println("O total de contas é: "+ total);
	}
	
	// getters/setters
	public double getSaldo() {
		return this.saldo;
	}
	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		Conta.total = total;
	}
	public void setAgencia(int agencia) {
		if (agencia < 0) {
			System.out.println("Erro! Numero de agencia invalido.");
			System.out.println("Mantendo agencia = 0 !");
		} else {
			this.agencia = agencia;
		}
	}
	public int getAgencia() {
		return this.agencia;
	}
	public void setNumero(int numero) {
		if (numero < 0) {
			System.out.println("Erro! Numero de conta invalido.");
			System.out.println("Mantendo numero = 0 !");
		} else {
			this.numero = numero;
		}
	}
	public int getNumero() {
		return this.numero;
	}
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	public Cliente getTitular() {
		return this.titular;
	}
	
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
