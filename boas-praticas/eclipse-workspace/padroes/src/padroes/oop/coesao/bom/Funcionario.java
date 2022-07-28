package padroes.oop.coesao.bom;

public class Funcionario {
	
	private String nome;
	private String cargo;
	private Contato contato;
	
	public Funcionario(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
	}

	public Funcionario(String nome, String cargo, Contato contato) {
		this.nome = nome;
		this.cargo = cargo;
		this.contato = contato;
	}
	
	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
