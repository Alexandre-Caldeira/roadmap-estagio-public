
public abstract class Funcionario {				// => "classe não-instanciavel"
	
	private String nome;
	private String cpf; 
	private double salario;	// protected = public para children, private para outros
							// geralmente ma ideia
	
	// Construtor
	public Funcionario() {
		
	}
	
	// getters setters
	public abstract double getBonificacao();	// => "metodo sem corpo"
												// filhos devem implementar!
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
		
}
