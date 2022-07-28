package padroes.oop.acoplamento.bom;

import java.util.ArrayList;
import java.util.List;

import padroes.oop.acoplamento.Reajuste;

public class Funcionario {
	public static Funcionario carregarDoBancoDeDados() {
		return new Funcionario();
	}

	public double getTotalRecebidoEmReajustes() {
		List<Reajuste> exemploReajustes = new ArrayList<Reajuste>();
		
		exemploReajustes.add(new Reajuste(25));
		exemploReajustes.add(new Reajuste(100));
		exemploReajustes.add(new Reajuste(250));
		exemploReajustes.add(new Reajuste(15));
		
		double valorTotalReajustes = 0;
		for(Reajuste r: exemploReajustes){
	        valorTotalReajustes += r.getValor();
	    }
		
		return valorTotalReajustes;
	}
}
