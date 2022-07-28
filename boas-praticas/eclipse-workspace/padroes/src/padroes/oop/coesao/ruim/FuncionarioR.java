package padroes.oop.coesao.ruim;

public class FuncionarioR {

	private String nome;
	private String cargo;
	private String rua; 
	private String cidade;
	private String estado;
	private String email;
	
	public FuncionarioR(String nome, String cargo, String rua, String cidade, String estado, String email) {
		this.nome = nome;
		this.cargo = cargo;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
	}
	
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
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
