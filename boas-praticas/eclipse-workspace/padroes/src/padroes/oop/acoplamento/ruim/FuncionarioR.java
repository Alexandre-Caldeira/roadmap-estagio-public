package padroes.oop.acoplamento.ruim;

import java.util.ArrayList;
import java.util.List;

import padroes.oop.acoplamento.Reajuste;

public class FuncionarioR {
	
	public static FuncionarioR carregarDoBancoDeDados() {
		return new FuncionarioR();
	}

	public List<Reajuste> getReajustes() {
		
		List<Reajuste> exemploReajustes = new ArrayList<Reajuste>();
		exemploReajustes.add(new Reajuste(25));
		exemploReajustes.add(new Reajuste(100));
		exemploReajustes.add(new Reajuste(250));
		exemploReajustes.add(new Reajuste(15));
				
		return exemploReajustes;
	}
}
