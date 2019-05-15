/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Vehicle;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author nuno
 */
public class VehicleControllerTest {
	
	public VehicleControllerTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of readAll method, of class VehicleController.
	 */
	@Test
	public void testReadAll() {
		System.out.println("readAll");
		VehicleController instance = new VehicleController();
		ArrayList<Vehicle> result = instance.readAll();
		boolean found = false;
		for (Vehicle vehicle : result) {
			if (vehicle.getBrand().equals("test"))
				found = true;
		}
		assertTrue(found);
	}

	/**
	 * Test of search method, of class VehicleController.
	 */
	@Test
	public void testSearch() {
		System.out.println("search");
		String param = "test";
		VehicleController instance = new VehicleController();
		ArrayList<Vehicle> result = instance.search(param);
		assertEquals("test", result.get(0).getBrand());
	}
	
}
