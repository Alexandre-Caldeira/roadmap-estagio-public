package loja_virtual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

<<<<<<< HEAD
import factory.ConnectionFactory;

=======
>>>>>>> 4ad6f94ce4ed62ff9e59eec802c8784bcc8aacda
public class TentaInserir {

	public static void main(String[] args) throws SQLException{
		
		
		ConnectionFactory conFactory = new ConnectionFactory();
		Connection con = conFactory.recuperarConexao();
		
		Statement stm = con.createStatement();
		
		// O método devolve true quando o seu resultado é um java.sql.ResultSet 
		// e false caso contrário (update, delete, etc)
		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('MOUSE', 'MOUSE sem fio')",
					Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while (rst.next()) {
			System.out.println("ID criado: " +rst.getInt(1));
		}
		
		System.out.println();
		
		con.close();

	}

}
