
public class FuncionarioTeste {
	
	private String nome;
	private String cpf; 
	private double salario;
	private int tipo = 0; // 0 - Funcionario comum, 1 - Gerente, 2 - Diretor
	
	// Construtor
	public FuncionarioTeste() {
		
	}
	
	// getters setters
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getTipo() {
		return tipo;
	}
	public double getBonificacao() {
		
		// Ma pratica: muitos ifs, tipos explicitos nao tabelados!
		if (this.tipo == 0) {				// Funcionario comum
			return this.getSalario()*0.1;
		}else if (this.tipo == 1) {			// Gerente	
			return this.getSalario();
		}else {								// Diretor
			return this.getSalario()+1000.0;
		}
		
	}
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
