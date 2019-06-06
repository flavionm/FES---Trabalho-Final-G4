/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Client;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nuno
 */
public class ClientControllerTest {
	
	public ClientControllerTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		String sql = "INSERT INTO client (name, email, cpf, phone, cnh, address, city, state)"
		           + " VALUES ('test', 'test', 'test', 'test', 'test', 'test', 'test', 'test');";
		try {
			Connection conn = new ConnectionDB().getConection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@AfterClass
	public static void tearDownClass() {
		String sql = "DELETE FROM client WHERE name = 'test' OR name = 'test2' OR name = 'test3';";
		try {
			Connection conn = new ConnectionDB().getConection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Test of insert method, of class ClientController.
	 */
	@Test
	public void testInsert() {
		System.out.println("insert");
		ClientController instance = new ClientController();
		ArrayList<Client> result = instance.readAll();
		boolean found = false;
		for (Client c : result) {
			if (c.getName().equals("test"))
				found = true;
		}
		assertTrue(found);
	}
	
	/**
	 * Test of readAll method, of class ClientController.
	 */
	@Test
	public void testReadAll() {
		System.out.println("readAll");
		ClientController instance = new ClientController();
		ArrayList<Client> result = instance.readAll();
		boolean found = false;
		for (Client c : result) {
			if (c.getName().equals("test"))
				found = true;
		}
		assertTrue(found);
	}
	
}
