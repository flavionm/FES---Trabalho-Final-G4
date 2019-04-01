package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	public Connection getConection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/vocealuga", "root", "slickmac");
		}catch (Exception e) {
			throw new RuntimeException("Erro na conexão com BD: " + e);
		}
	}
	
}  
