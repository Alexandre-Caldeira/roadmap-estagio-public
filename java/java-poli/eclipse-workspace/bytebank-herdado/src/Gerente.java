
public class Gerente extends Funcionario implements Autenticavel {
	
	private AutenticadorUtil autenticador;
	
	public Gerente() {
		this.autenticador = new AutenticadorUtil(); // Relacionamento de COMPOSICAO
	}
	
	@Override
	public double getBonificacao() {
		return super.getSalario(); // super pega atributo da parent class
	}
	@Override
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}
	@Override
	public boolean autentica(int senha) {
		return this.autenticador.autentica(senha);
	}
}
