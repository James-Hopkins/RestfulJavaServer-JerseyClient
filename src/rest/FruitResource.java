package rest;

import java.io.IOException;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.servlet.http.*;

@Path("/fruits")
public class FruitResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Fruit>getFruits(){
		return FruitDBAO.getFruits();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@Path("{fruitId}")
	public Fruit getFruit(@PathParam("fruitId") String id){
		return FruitDBAO.getFruit(Integer.parseInt(id));
	}
	
	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	public void postFruit(
			@FormParam("id") String id,
			@FormParam("name") String name,
			@FormParam("price") String price,
			@FormParam("texture") String texture,
			@FormParam("color") String color,
			@Context HttpServletResponse servletResponse) throws IOException {
		System.out.println("Inside POST id = " + id);
		System.out.println("Name = " + name);
		

		Fruit fruit =  new Fruit(0, "", 0.0, "", "");
		fruit.setId(Integer.parseInt(id));
		fruit.setName(name);
		fruit.setTexture(texture);
		fruit.setColor(color);
		fruit.setPrice(Double.parseDouble(price));
		
		FruitDBAO.addFruit(fruit);
		//servletResponse.sendRedirect("../createFruit.html");
		
	}
	
	@DELETE
	@Produces({ MediaType.TEXT_HTML })
	@Path("{fruitId}")
	public void deleteFruit(@PathParam("fruitId") String id) throws IOException {
		System.out.println("Delete id: " + id);
		FruitDBAO.deleteFruit(Integer.parseInt(id));
	}
	
	@PUT
	@Produces({ MediaType.TEXT_HTML })
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Path("{fruitId}")
	public static void putFruit(
			@FormParam("id") String id,
			@FormParam("name") String name,
			@FormParam("price") String price,
			@FormParam("texture") String texture,
			@FormParam("color") String color,
			@Context HttpServletResponse servletResponse) throws IOException {
		System.out.println("PUT id = " + id);
		
		Fruit fruit =  new Fruit(0, "", 0.0, "", "");
		fruit.setId(Integer.parseInt(id));
		fruit.setName(name);
		fruit.setTexture(texture);
		fruit.setColor(color);
		fruit.setPrice(Double.parseDouble(price));
		FruitDBAO.updateFruit(fruit);
	}
}
