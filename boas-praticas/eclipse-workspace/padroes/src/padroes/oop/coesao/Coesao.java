package padroes.oop.coesao;

import padroes.oop.coesao.bom.Contato;
import padroes.oop.coesao.bom.Funcionario;
import padroes.oop.coesao.ruim.FuncionarioR;

public class Coesao {
	public static void main(String[] args) {
		
		// construtor longo, sera que preciso de todas essas entradas sempre?
		FuncionarioR jose = new FuncionarioR("Jose", "Designer", "Rua Dona Ida", 
				"Curvelo", "MG", "jose.designer@email.com");
		
		jose.getCargo();
		
		// Melhor!
		Funcionario tiago = new Funcionario("Tiago", "Backend");
		
		// ... em outro lugar do código ...
		tiago.setContato(new Contato("Rua Dona Volta", "Corinto", "MG", "tiago.backend@email.com"));
		
	}
}
