/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employee;

/**
 *
 * @author nuno
 */
public class EmployeeController {

	public static boolean login(String username, String password) {
		return Employee.isOnDatabase(username, password);
	}

	public static boolean register(String username, String password) {
		Employee e = new Employee();

		e.setUsername(username);
		e.setPassword(password);
		e.saveToDatabase();

		return true;
	}
}
