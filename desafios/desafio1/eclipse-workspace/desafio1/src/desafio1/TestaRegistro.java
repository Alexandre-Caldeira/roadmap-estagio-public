package desafio1;

import java.util.Arrays;

public class TestaRegistro {
	public static void main(String[] args) {
		Registro dados = Registro.getRegistro(5);
		
		System.out.println("Alocado em: "+dados.getDadosInformados());
		System.out.println(dados.getDado(1));
		System.out.println(Arrays.toString(dados.getDadosInformados()));
		
		
		// tentar construir outra instancia diferente numero de dados
		Registro maisDados = Registro.getRegistro(25);

		System.out.println("\ndados em: "+dados.getDadosInformados());
		System.out.println("maisDados em: "+maisDados.getDadosInformados());
		System.out.println(Arrays.toString(dados.getDadosInformados()));
		System.out.println(Arrays.toString(maisDados.getDadosInformados()));
		
		// Alterando
		dados.setDado(0, 1);
		
		System.out.println("\nnovo dados: "+Arrays.toString(dados.getDadosInformados()));
		System.out.println("maisDados:  "+Arrays.toString(maisDados.getDadosInformados()));
	}
}
