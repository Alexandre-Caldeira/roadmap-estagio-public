package padroes.oop.acoplamento;

import java.util.List;

import padroes.oop.acoplamento.bom.Funcionario;
import padroes.oop.acoplamento.ruim.FuncionarioR;

public class Acoplamento {
	public static void main(String[] args) {
		
		// RUIM (fortemente acoplado)
		FuncionarioR leandro = FuncionarioR.carregarDoBancoDeDados();
	    double totalReajustesLeandro = 0;
	    List<Reajuste> reajustes = leandro.getReajustes();
	    for(Reajuste r: reajustes){
	        totalReajustesLeandro += r.getValor();
	    }
	    
	    // BOM (fracamente acoplado)
	    Funcionario lucas = Funcionario.carregarDoBancoDeDados();
	    double totalReajustesLucas = lucas.getTotalRecebidoEmReajustes();
	    
	    System.out.println(totalReajustesLeandro);
	    System.out.println(totalReajustesLucas);

	}
}
