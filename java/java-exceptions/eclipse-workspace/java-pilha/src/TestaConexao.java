
public class TestaConexao {

	public static void main(String[] args) {
		
		try(Conexao con = new Conexao()){ 
			con.leDados();	// fecha automaticamente por implementar
							// AutoCloseable
		}catch(IllegalStateException ex) {
			System.out.println("Erro na conexao!");
		}
		
		/*
		 
		Conexao con = null;
		try {
			con = new Conexao();
			con.leDados();
		}catch(IllegalStateException ex) {
			System.out.println("Deu erro na conexao");
		}finally { 
			con.fecha();
		} 
		
		*/
	}
}
