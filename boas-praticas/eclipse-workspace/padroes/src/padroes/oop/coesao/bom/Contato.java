package padroes.oop.coesao.bom;

public class Contato {

	private String rua; 
	private String cidade;
	private String estado;
	private String email;
	
	public Contato(String rua, String cidade, String estado, String email) {
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
	}
	
	public String formataEndereco() { 
		/* lógica de toString... */
		return rua+","+cidade+","+estado;
	}
	public String formataCpf() { 
		/* lógica de toString... */ 
		return email;
	}

}
