package desafio1;

import java.io.FileWriter;
import java.io.IOException;

public class GerenteTexto extends Analista implements Escritor {

	public GerenteTexto(SessaoUI sessao) {
		super(sessao);
		System.out.println("Gerente de texto adcionado para "+ sessao.nomeDaSessao + " #"+sessao.idSessao+".");
	}

	@Override
	public boolean salvaResultado(String nomeDoArquivo) {
		System.out.println("Salvando resultados para: "+this.getCaminhoPadrao()+nomeDoArquivo+".txt");
		
		FileWriter writer;
		
		try {
			writer = new FileWriter(this.getCaminhoPadrao()+nomeDoArquivo+".txt");
			for (int j=0; j<5; j++) { 
				writer.write(registro.getDado(j)+" ");
			}
			
			// Escreve nas saidas
			writer.write(this.calculaMedia()+""); // TODO: corrigir trailling zeros e usar this.getMedia()
			writer.close();
			return true;
			
		} catch (IOException e) {
			// Mostra erro de IO caso ocorra
			e.printStackTrace();
			return false;
		}		
	}

}
