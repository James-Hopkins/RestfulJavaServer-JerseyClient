package resources;

import java.io.IOException;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import model.Fruit;


public class FruitFunctions {
	public List<Fruit> getFruits() throws IOException, URISyntaxException {
		CloseableHttpResponse response = null;
		try {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/A00220384JamesHopkinsServer/rest/fruits").build();
			
			System.out.println(uri.toString());
			
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Accept", "application/xml");
			
			CloseableHttpClient httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);
			
			HttpEntity entity = response.getEntity();
			String text = EntityUtils.toString(entity);
			System.out.println(text);
			
			List<Fruit> fruitList = new ParseFruits().doParseFruits(text);
			for(Fruit fruit : fruitList) {
				System.out.println("-------------------------");
				System.out.println("ID: " + fruit.getId());
				System.out.println("Name: " + fruit.getName());
				System.out.println("Price: " + fruit.getPrice());
				System.out.println("Texture: " + fruit.getTexture());
				System.out.println("Color: " + fruit.getColor());
			}
			return fruitList;
		
		} finally {
			response.close();
		}
	}
	
	public Fruit getFruit(int id) throws IOException, URISyntaxException {
		CloseableHttpResponse response = null;
		Fruit fruitR = new Fruit();
		try {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/A00220384JamesHopkinsServer/rest/fruits/"+id).build();
			
			System.out.println(uri.toString());
			
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Accept", "application/xml");
			
			CloseableHttpClient httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);
			
			HttpEntity entity = response.getEntity();
			String text = EntityUtils.toString(entity);
			System.out.println(text);
			
			List<Fruit> fruitList = new ParseFruits().doParseFruits(text);
			for(Fruit fruit : fruitList) {
				fruitR = fruit;
			}
			return fruitR;
			
		
		} finally {
			response.close();
		}
	}
	public static void addFruit(Fruit fruit) throws IOException, URISyntaxException {
		Fruit fruitR = new Fruit();
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/A00220384JamesHopkinsServer/rest/fruits/").build();
			
			System.out.println(uri.toString());
			MultivaluedMap input = new MultivaluedMapImpl();
			input.add("id", Integer.toString(fruit.getId()));
			input.add("name", fruit.getName());
			input.add("price", Double.toString(fruit.getPrice()));
			input.add("texture", fruit.getTexture());
			input.add("color", fruit.getColor());
			Client client = Client.create();
			WebResource webResource = client.resource(uri);
			ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
			   .post(ClientResponse.class, input);
	}
	public static void updateFruit(Fruit fruit) throws IOException, URISyntaxException {
		Fruit fruitR = new Fruit();
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/A00220384JamesHopkinsServer/rest/fruits/"+fruit.getId()).build();
			System.out.println(uri.toString());
			MultivaluedMap input = new MultivaluedMapImpl();
			input.add("id", Integer.toString(fruit.getId()));
			input.add("name", fruit.getName());
			input.add("price", Double.toString(fruit.getPrice()));
			input.add("texture", fruit.getTexture());
			input.add("color", fruit.getColor());
			Client client = Client.create();
			WebResource webResource = client.resource(uri);
			ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
			   .put(ClientResponse.class, input);
	}
	public static void deleteFruit(int id) throws IOException, URISyntaxException {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/A00220384JamesHopkinsServer/rest/fruits/").build();
			System.out.println(uri.toString());
			Client client = Client.create();
			WebResource webResource = client.resource(uri);
			ClientResponse response = webResource.path(Integer.toString(id)).delete(ClientResponse.class);
	}
}	
