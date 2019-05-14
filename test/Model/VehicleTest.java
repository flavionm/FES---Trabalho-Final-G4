/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nuno
 */
public class VehicleTest {
	
	public VehicleTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of getDataForTable method, of class Vehicle.
	 */
	@Test
	public void testGetDataForTable() {
		System.out.println("getDataForTable");
		Vehicle instance = new Vehicle();
		ArrayList<String> expResult = new ArrayList<>();
		expResult.add(null);
		expResult.add(null);
		expResult.add(null);
		ArrayList<String> result = instance.getDataForTable();
		assertEquals(expResult, result);
	}
	
}
