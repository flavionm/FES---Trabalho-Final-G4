package Controller;

import java.sql.Connection;
import java.sql.Statement;

public class BootstrapDB {

	public static Connection conn;
	public static Statement st;
	
	public static void Bootstrap() {
		conn = new ConnectionDB().getConection();
		BootstrapEmployee();
		BootstrapClient();
		BootstrapVehicle();
		return;
	}
	
	public static void BootstrapEmployee() {
		String sql = "CREATE TABLE IF NOT EXISTS employee ("
				+ "id int(11) NOT NULL AUTO_INCREMENT,"
				+ "username varchar(100) NOT NULL UNIQUE,"
				+ "password varchar(100) NOT NULL,"
				+ "type int(1) DEFAULT 0,"
				+ "PRIMARY KEY (id)"
				+ ");";
		try {
			st = conn.createStatement();
			st.execute(sql);
			st.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no bootstrap de employee:" + e);
		}
	}
	
	public static void BootstrapClient() {
		String sql = "CREATE TABLE IF NOT EXISTS client ("
				+ "id int(11) NOT NULL AUTO_INCREMENT,"
				+ "name varchar(100) NOT NULL,"
				+ "email varchar(100) NOT NULL UNIQUE,"
				+ "cpf varchar(11) NOT NULL UNIQUE,"
				+ "phone varchar(100) NOT NULL UNIQUE,"
				+ "cnh varchar(100) UNIQUE,"
				+ "address varchar(100),"
				+ "city varchar(100),"
				+ "state varchar(100),"
				+ "PRIMARY KEY(id)"
				+ ");";
		try {
			st = conn.createStatement();
			st.execute(sql);
			st.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no bootstrap de client:" + e);
		}
	}
	
	public static void BootstrapVehicle() {
		String sql = "CREATE TABLE IF NOT EXISTS vehicle ("
				+ "id int(11) NOT NULL AUTO_INCREMENT,"
				+ "brand varchar(100) NOT NULL,"
				+ "model varchar(100) NOT NULL UNIQUE,"
				+ "type int(11) NOT NULL UNIQUE,"
				+ "color varchar(100) NOT NULL UNIQUE,"
				+ "plate varchar(100) UNIQUE,"
				+ "document varchar(100),"
				+ "insurance varchar(100),"
				+ "disponibility int(11),"
				+ "cost float(5),"
				+ "km float(5),"
				+ "filial varchar(100),"
				+ "PRIMARY KEY(id)"
				+ ");";
		try {
			st = conn.createStatement();
			st.execute(sql);
			st.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no bootstrap de vehicle:" + e);
		}
	}
}
