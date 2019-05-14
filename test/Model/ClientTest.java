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
public class ClientTest {
	
	public ClientTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of getDataForDashBoardTable method, of class Client.
	 */
	@Test
	public void testGetDataForDashBoardTable() {
		System.out.println("getDataForDashBoardTable");
		Client instance = new Client();
		ArrayList<String> expResult = new ArrayList<>();
		expResult.add("");
		expResult.add("");
		expResult.add("");
		ArrayList<String> result = instance.getDataForDashBoardTable();
		assertEquals(expResult, result);
	}

	/**
	 * Test of saveToDatabase method, of class Client.
	 */
	@Test
	public void testSaveToDatabase() {
		System.out.println("saveToDatabase");
		Client instance = new Client();
		boolean expResult = true;
		boolean result = instance.saveToDatabase();
		assertEquals(expResult, result);
	}

	/**
	 * Test of isOnDatabase method, of class Client.
	 */
	@Test
	public void testIsOnDatabase() {
		System.out.println("isOnDatabase");
		String email = "";
		boolean expResult = true;
		boolean result = Client.isOnDatabase(email);
		assertEquals(expResult, result);
	}

}
