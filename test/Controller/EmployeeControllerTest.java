/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employee;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nuno
 */
public class EmployeeControllerTest {
	
	public EmployeeControllerTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of login method, of class EmployeeController.
	 */
	@Test
	public void testLogin() {
		System.out.println("login");
		Employee employee = new Employee();
		employee.setUsername("test");
		employee.setPassword("test");
		EmployeeController instance = new EmployeeController();
		Employee result = instance.login(employee);
		assertEquals("test", result.getUsername());
		assertEquals(0, result.getType());
	}
	
}
