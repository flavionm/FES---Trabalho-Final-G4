package Model;

import java.util.ArrayList;

public class Vehicle {

	private int id;
	private String brand;
	private String model;
	private String type;
	private String color;
	private String plate;
	private String document;
	private String insurance;
	private int disponibility;
	private String cost;
	private float km;
	private String filial;
	
	public ArrayList<String> getDataForTable() {
		ArrayList<String> data = new ArrayList<>();
		data.add(this.getBrand());
		data.add(this.getPlate());
		data.add(this.getDocument());
		return data;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public int getDisponibility() {
		return disponibility;
	}
	public void setDisponibility(int disponibility) {
		this.disponibility = disponibility;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public float getKm() {
		return km;
	}
	public void setKm(float km) {
		this.km = km;
	}
	public String getFilial() {
		return filial;
	}
	public void setFilial(String filial) {
		this.filial = filial;
	}
	
	
}
