
public class ControleBonificacao {
	private double soma;
	
	public void registra(Funcionario f) {
		double bonificacao = f.getBonificacao();
		this.soma += bonificacao;
	}
	/* Continua funcionando, pois Gerente e EditorVideo herda Funcionario
	public void registra(Gerente g) {
		double bonificacao = g.getBonificacao();
		this.soma += bonificacao;
	}	
	public void registra(EditorVideo ev) {
		double bonificacao = ev.getBonificacao();
		this.soma += bonificacao;
	}	
	*/
	public double getSoma() {
		return soma;
	}
}
