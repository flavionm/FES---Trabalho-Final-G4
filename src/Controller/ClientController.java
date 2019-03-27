/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Address;
import Model.Client;
import java.util.ArrayList;

/**
 *
 * @author nuno
 */
public class ClientController {

	public static boolean login(String email, String password) {
		return Client.isOnDatabase(email, password);
	}

	public static boolean register(ArrayList<String> clientData) {
		Client c = new Client();

		c.setName(clientData.get(0));
		c.setEmail(clientData.get(1));
		c.setPassword(clientData.get(2));
		c.setCpf(clientData.get(3));
		c.setPhone(clientData.get(4));
		c.setCnh(clientData.get(5));
		Address e = new Address(clientData.get(6), clientData.get(7), clientData.get(8),
				clientData.get(9), clientData.get(10));
		c.setAddress(e);

		return c.saveToDatabase();
	}
}
