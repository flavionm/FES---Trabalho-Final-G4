package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.Client;

public class ClientController {
	
	private Connection conn;
	private PreparedStatement stmt;
	
	public ClientController() {
		conn = new ConnectionDB().getConection();
	}
	
	public void insert(Client client) {
		String sql = "INSERT INTO client (name, email, cpf, phone, cnh, address, city, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, client.getName());
			stmt.setString(2, client.getEmail());
			stmt.setString(3, client.getCpf());
			stmt.setString(4, client.getPhone());
			stmt.setString(5, client.getCnh());
			stmt.setString(6, client.getAddress());
			stmt.setString(7, client.getCity());
			stmt.setString(8, client.getState());
			stmt.execute();
			stmt.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no insert de client:" + e);
		}
	
	}
	
}