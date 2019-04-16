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
	
	public VehicleController() {
		conn = new ConnectionDB().getConection();
	}
	
	
}