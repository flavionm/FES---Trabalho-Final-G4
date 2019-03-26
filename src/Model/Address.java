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

	private final String rua;
	private final String num;
	private final String bairro;
	private final String cidade;
	private final String estado;

	public Address(String rua, String num, String bairro, String cidade, String estado) {
		this.rua = rua;
		this.num = num;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public String getNum() {
		return num;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}
}
