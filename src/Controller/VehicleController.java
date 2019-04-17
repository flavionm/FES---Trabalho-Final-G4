package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Client;
import Model.Vehicle;

public class VehicleController {
	
	private Connection conn;
	private PreparedStatement stmt;
	private Statement st;
	private ResultSet rs;
	
	public VehicleController() {
		conn = new ConnectionDB().getConection();
	}
	
	public void insert(Vehicle vehicle) {
		String sql = "INSERT INTO vehicle (brand, model, type, color, plate, document, insurance, cost, filial) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vehicle.getBrand());
			stmt.setString(2, vehicle.getModel());
			stmt.setString(3, vehicle.getType());
			stmt.setString(4, vehicle.getColor());
			stmt.setString(5, vehicle.getPlate());
			stmt.setString(6, vehicle.getDocument());
			stmt.setString(7, vehicle.getInsurance());
			stmt.setString(8, vehicle.getCost());
			stmt.setString(9, vehicle.getFilial());
			stmt.execute();
			stmt.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no insert de client:" + e);
		}
	
	}
	
	public ArrayList<Vehicle> readAll() {
		String sql = "SELECT * FROM vehicle;";
		ArrayList<Vehicle> data = new ArrayList<>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setBrand(rs.getString("brand"));
				vehicle.setModel(rs.getString("model"));
				vehicle.setType(rs.getString("type"));
				vehicle.setPlate(rs.getString("plate"));
				vehicle.setColor(rs.getString("color"));
				vehicle.setDocument(rs.getString("document"));
				vehicle.setInsurance(rs.getString("insurance"));
				vehicle.setDisponibility(rs.getInt("disponibility"));
				vehicle.setCost(rs.getString("cost"));
				vehicle.setId(rs.getInt("id"));
				data.add(vehicle);
			}
			st.close();
		}catch(Exception e) {
			throw new RuntimeException("Erro no readAll de vehicle:" + e);
		}
		return data;
	}
}