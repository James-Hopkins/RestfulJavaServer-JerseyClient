package model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "fruit")
@XmlType(propOrder = { "id", "name", "price", "texture", "color"})
public class Fruit {
	private int id;
	private String name;
	private double price;
	private String texture;
	private String color;
	
	public Fruit() {}
	public Fruit(int id, String name, double price, String texture, String color) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.texture = texture;
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTexture() {
		return texture;
	}
	public void setTexture(String texture) {
		this.texture = texture;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
