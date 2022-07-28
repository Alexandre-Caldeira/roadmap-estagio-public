package loja_virtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

<<<<<<< HEAD
import factory.ConnectionFactory;

=======
>>>>>>> 4ad6f94ce4ed62ff9e59eec802c8784bcc8aacda
public class TentaRemover {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conFactory = new ConnectionFactory();
		Connection con = conFactory.recuperarConexao();
		
		Statement stm = con.createStatement();

		stm.execute("DELETE FROM PRODUTO WHERE NOME LIKE '%Mouse%'",
					Statement.RETURN_GENERATED_KEYS);
<<<<<<< HEAD

=======
		
>>>>>>> 4ad6f94ce4ed62ff9e59eec802c8784bcc8aacda
		int mod = stm.getUpdateCount();
		
		System.out.println(mod+" linhas removidas.");
		
		con.close();
	}

}
