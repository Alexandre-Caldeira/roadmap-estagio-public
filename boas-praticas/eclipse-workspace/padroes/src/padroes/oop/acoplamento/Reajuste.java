package padroes.oop.acoplamento;

public class Reajuste {
	
	private double valor;
	
	public Reajuste(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
	 
	// (encapsulado?)
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
