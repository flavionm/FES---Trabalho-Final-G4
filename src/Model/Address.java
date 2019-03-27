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
public class Address {

	private final String street;
	private final String num;
	private final String district;
	private final String city;
	private final String state;

	public Address(String street, String num, String district, String city, String state) {
		this.street = street;
		this.num = num;
		this.district = district;
		this.city = city;
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public String getNum() {
		return num;
	}

	public String getDistrict() {
		return district;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}
}
