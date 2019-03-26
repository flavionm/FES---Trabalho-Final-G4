/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Client;

/**
 *
 * @author nuno
 */
public class ClientController {
    public static boolean login(String email, String senha) {
        return Client.isOnDatabase(email, senha);
    }
}
