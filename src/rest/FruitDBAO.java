package rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import rest.Fruit;

public class FruitDBAO{
	private static Connection connectToDB() {
		Connection con = null;
	      try {
	    	  Class.forName("org.hsqldb.jdbc.JDBCDriver");
	    	  con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");      
	  		}  catch (Exception e) {
	  			e.printStackTrace(System.out);
	  		}
	      return con;
	}
	public static List<Fruit> getFruits() {
		Connection con = connectToDB();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM FRUIT");
			List<Fruit> fruits = new ArrayList<Fruit>();
			
			while (rs.next()) {			
				int resid = Integer.parseInt(rs.getString("id"));
				String name = rs.getString("name");
				double price = Double.parseDouble(rs.getString("price"));
				String texture = rs.getString("texture");
				String color = rs.getString("color");
				Fruit fruit = new Fruit(resid, name, price, texture, color);
				fruits.add(fruit);
			}
			return fruits;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Fruit getFruit(int id) {
		Connection con = connectToDB();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM FRUIT WHERE id = " + id);
			while (rs.next()) {
				int resid = Integer.parseInt(rs.getString("id"));
				String name = rs.getString("name");
				double price = Double.parseDouble(rs.getString("price"));
				String texture = rs.getString("texture");
				String color = rs.getString("color");
				Fruit fruit = new Fruit(resid, name, price, texture, color);
				return fruit;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Fruit updateFruit(Fruit fruit) {
		Connection con = connectToDB();
		Statement stmt;
		int id = fruit.getId();
		String name = fruit.getName();
		double price = fruit.getPrice();
		String texture = fruit.getTexture(); 
		String color = fruit.getColor();
		try {
			stmt = con.createStatement();
			stmt.executeUpdate("UPDATE FRUIT SET id = "+id+", name='"+name+"', price = "+price+", texture = '"+texture
					+"', color = '"+color+"' where id="+id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Fruit addFruit(Fruit fruit) {
		Connection con = connectToDB();
		Statement stmt;
		int id = fruit.getId();
		String name = fruit.getName();
		double price = fruit.getPrice();
		String texture = fruit.getTexture(); 
		String color = fruit.getColor();
		try {
			stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO FRUIT (id, name, price, texture, color) VALUES("
					+id+",'"+name+"',"+price+",'"+texture+"', '"+color+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void deleteFruit(int id) {
		Connection con = connectToDB();
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM fruit where id="+id);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	
	
	
      


}