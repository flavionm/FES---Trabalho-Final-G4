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

	public static boolean login(String email, String senha) {
		return Client.isOnDatabase(email, senha);
	}

	public static boolean register(ArrayList<String> dados) {
		Client c = new Client();

		c.setNome(dados.get(0));
		c.setEmail(dados.get(1));
		c.setSenha(dados.get(2));
		c.setCpf(dados.get(3));
		c.setCelular(dados.get(4));
		c.setCnh(dados.get(5));
		Address e = new Address(dados.get(6), dados.get(7), dados.get(8),
				dados.get(9), dados.get(10));
		c.setEndereco(e);

		return c.saveToDatabase();
	}
}
