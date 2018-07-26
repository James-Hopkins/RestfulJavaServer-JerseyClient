package controller;

import java.io.IOException;
import java.net.URISyntaxException;

import model.Fruit;
import resources.FruitFunctions;

public class main {

	public static void main(String[] args) throws IOException, URISyntaxException {
		// TODO Auto-generated method stub
		Fruit fruit = new Fruit();
		fruit.setColor("b");
		fruit.setId(111);
		fruit.setName("adadasedawe");
		fruit.setPrice(20.20);
		fruit.setTexture("sdfwsferf");
		FruitFunctions.addFruit(fruit);
	}
}
