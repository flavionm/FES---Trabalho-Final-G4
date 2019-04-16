/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

public class Client {

	private int id;
	private String name = "";
	private String email;
	private String cpf = "";
	private String phone = "";
	private String cnh = "";
	private String address = "";
	private String city = "";

	public ArrayList<String> getDataForDashBoardTable() {
		ArrayList<String> data = new ArrayList<>();
		data.add(this.getName());
		data.add(this.getPhone());
		data.add(this.getCpf());
		return data;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	private String state;

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean saveToDatabase() {
		return true;
	}

	public static Client getFromDatabase(String email) {
		return new Client();
	}

	public static boolean isOnDatabase(String email) {
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
