package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Client;

public class ClientController {
	
	private Connection conn;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet rs;
	
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
	
	public void update(Client client) {
		String sql = "UPDATE client SET name=?, email=?, cpf=?, phone=?, cnh=?, address=?, city=?, state=? WHERE id =?;";
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
			stmt.setInt(9, client.getId());
			stmt.execute();
			stmt.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no update de client:" + e);
		}
	
	}
	public ArrayList<Client> readAll() {
		String sql = "SELECT * FROM client;";
		ArrayList<Client> data = new ArrayList<>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Client client = new Client();
				client.setName(rs.getString("name"));
				client.setEmail(rs.getString("email"));
				client.setCpf(rs.getString("cpf"));
				client.setPhone(rs.getString("phone"));
				client.setCnh(rs.getString("cnh"));
				client.setAddress(rs.getString("address"));
				client.setCity(rs.getString("city"));
				client.setId(rs.getInt("id"));
				data.add(client);
			}
			st.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no readAll de client:" + e);
		}
		return data;
	}
	
}