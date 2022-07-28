package desafio1;

import java.io.IOException;

public interface Escritor {
	
	public abstract boolean salvaResultado(String nomeDoArquivo) throws IOException;
	
}
