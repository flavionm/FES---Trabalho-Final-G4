package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	public Connection getConection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost/vocealuga", "USUARIO", "SENHA");
		}catch (Exception e) {
			throw new RuntimeException("Erro na conexão com BD: " + e);
		}
	}
	
}  
