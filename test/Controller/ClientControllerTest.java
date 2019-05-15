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

/**
 *
 * @author nuno
 */
public class ClientControllerTest {
	
	public ClientControllerTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
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
