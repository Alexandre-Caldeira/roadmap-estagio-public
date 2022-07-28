package loja_virtual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TentaConectar {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC","root","8LqAtNrQYQQ5&C");
				
		con.close();
		
	}

}
