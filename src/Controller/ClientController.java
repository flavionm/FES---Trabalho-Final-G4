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
		String sql = "INSERT INTO client (name, email, cpf, phone, cnh, address) VALUES (?, ?, ?, ?, ?, ?);";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, client.getName());
			stmt.setString(2, client.getEmail());
			stmt.setString(3, client.getCpf());
			stmt.setString(4, client.getPhone());
			stmt.setString(5, client.getCnh());
			stmt.setInt(6, client.getAddress());
			stmt.execute();
			stmt.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no insert de client:" + e);
		}
	
	}
	
}