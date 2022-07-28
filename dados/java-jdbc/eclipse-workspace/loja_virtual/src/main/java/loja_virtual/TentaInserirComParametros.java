package loja_virtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

<<<<<<< HEAD
import factory.ConnectionFactory;

=======
>>>>>>> 4ad6f94ce4ed62ff9e59eec802c8784bcc8aacda
public class TentaInserirComParametros {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory conFactory = new ConnectionFactory();
		try(Connection connection = conFactory.recuperarConexao()){

			connection.setAutoCommit(false);

			try (PreparedStatement stm = 
					connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
					){
				adicionarVariavel("SmartTV", "45 polegadas", stm);
				adicionarVariavel("Radio", "Radio de bateria", stm);

				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		if(nome.equals("Radio")) {
			throw new RuntimeException("Nao foi possivel adicionar o produto");
		}

		stm.execute();

		try(ResultSet rst = stm.getGeneratedKeys()){
			while(rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
	}
	
	
//	public static void main(String[] args) throws SQLException {
//		Connection con = ConnectionFactory.recuperarConexao();
//		
//		String nome = "Mouse'";
//		String descricao = "Mouse sem fio'); delete * from produto;";
//		
//		String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)";
//	
//		// O PreparedStatement mantém a consulta compilada no banco de dados, para o usuário que necessitar 
//		// realizar a mesma consulta, diversas vezes, com parâmetros diferentes.
//		PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
//		stm.setString(1, nome);
//		stm.setString(2, descricao);
//		stm.execute();
//		
//		ResultSet rst = stm.getGeneratedKeys();
//		while (rst.next()) {
//			System.out.println("ID criado: " +rst.getInt(1));
//		}
//		
//		
//		con.close();
//
//	}

}
