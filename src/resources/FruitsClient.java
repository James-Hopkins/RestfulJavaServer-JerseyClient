package resources;

import java.io.IOException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import model.Fruit;


public class FruitsClient {
	public static void main(String[] args) throws IOException, URISyntaxException {
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
			
		
		} finally {
			response.close();
		}
	}
}
