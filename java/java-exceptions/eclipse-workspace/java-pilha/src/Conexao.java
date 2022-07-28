
public class Conexao implements AutoCloseable{

    public Conexao() {
        System.out.println("Abrindo conexao");
        
        // AutoCloseable tambem facilita 
        // para erros de construtor
        // throw new IllegalStateException();
    }

    public void leDados() {
        System.out.println("Recebendo dados");
        throw new IllegalStateException();
    }

    public void fecha() {
        System.out.println("Fechando conexao");
    }

	@Override
	public void close() {
		System.out.println("Fechando conexao");
	}
}