package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Employee;

public class EmployeeController {
	
	private Connection conn;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet rs;
	private ArrayList<Employee> data = new ArrayList<>();
	
	public EmployeeController() {
		conn = new ConnectionDB().getConection();
	}
	
	public void insert(Employee employee) {
		String sql = "INSERT INTO employee (username, password, type) VALUES (?, ?, ?);";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee.getUsername());
			stmt.setString(2, employee.getPassword());
			stmt.setInt(3, employee.getType());
			stmt.execute();
			stmt.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no insert de employee:" + e);
		}
	}
	
	public Employee login(Employee employee) {
		String sql = "SELECT * FROM employee WHERE username = ? AND password = ?";
		Employee auth = new Employee();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee.getUsername());
			stmt.setString(2, employee.getPassword());
			rs = stmt.executeQuery();
			if (rs.next()) {
				auth.setUsername(rs.getString("username"));
				auth.setType(rs.getInt("type"));
			}
			stmt.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no read de employee: " + e);
		}
		return auth;
	}
	
	public void update(Employee employee) {
		String sql = "UPDATE employee SET username = ?, password = ?, type = ? where id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, employee.getUsername());
			stmt.setString(2, employee.getPassword());
			stmt.setInt(3, employee.getType());
			stmt.setInt(4, employee.getId());
			stmt.execute();
			stmt.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no update de employee:" + e);
		}
	}
	
	public void delete(int valor) {
		String sql = "DELETE FROM employee WHERE id = " + valor;
		try {
			st = conn.createStatement();
			st.execute(sql);
			st.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no delete de employee:" + e);
		}
	}
	
}