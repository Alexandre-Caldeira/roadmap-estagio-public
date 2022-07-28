package loja_virtual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

<<<<<<< HEAD
import factory.ConnectionFactory;

=======
>>>>>>> 4ad6f94ce4ed62ff9e59eec802c8784bcc8aacda
public class TentaListar {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conFactory = new ConnectionFactory();
		Connection con = conFactory.recuperarConexao();
		
		Statement stm = con.createStatement();
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO;");
		
		ResultSet rst = stm.getResultSet();
		
		while (rst.next()) {
			//Integer id = rst.getInt(0);
			Integer id = rst.getInt("ID");
			String descricao = rst.getString("DESCRICAO");
			System.out.println(id+": "+descricao);
		}
		
		con.close();
	}
}
