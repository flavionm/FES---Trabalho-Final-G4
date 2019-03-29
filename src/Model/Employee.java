/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nuno
 */
public class Employee {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean saveToDatabase() {
		return true;
	}

	public static Client getFromDatabase(String username, String password) {
		return new Client();
	}

	public static boolean isOnDatabase(String username, String password) {
		return true;
	}
}
