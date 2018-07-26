package resources;
import java.io.*;

import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.*;

import model.Fruit;

public class ParseFruits {
	boolean inFruits = false;
	boolean inFruit = false;
	boolean inId = false;
	boolean inName = false;
	boolean inPrice = false;
	boolean inTexture = false;
	boolean inColor = false;
	
	Fruit currentFruit;
	List<Fruit> currentFruitList;
	
	public List<Fruit> doParseFruits(String s) {
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser pullParser = factory.newPullParser();
			pullParser.setInput(new StringReader(s));
			processDocument(pullParser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentFruitList;
	}
	
	public void processDocument(XmlPullParser pullParser) throws XmlPullParserException, IOException {
		int eventType = pullParser.getEventType();
		do {
			if (eventType == XmlPullParser.START_DOCUMENT) {
				System.out.println("Start Document");
			} 
			else if (eventType == XmlPullParser.END_DOCUMENT) {
				System.out.println("End Document");
			} 
			else if (eventType == XmlPullParser.START_TAG) {
				processStartElement(pullParser);
			} 
			else if (eventType == XmlPullParser.END_TAG) {
				processEndElement(pullParser);
			} 
			else if (eventType == XmlPullParser.TEXT) {
				processText(pullParser);
			}
			eventType = pullParser.next();
		} while (eventType != XmlPullParser.END_DOCUMENT);
	}
	
	public void processStartElement(XmlPullParser event) {
		String name = event.getName();
		if (name.equals("fruits")) {
			inFruits = true;
			currentFruitList = new ArrayList<Fruit>();
		}
		else if (name.equals("fruit")) {
			inFruit = true;
			currentFruit = new Fruit();
		} 
		else if (name.equals("id")) {
			inId = true;
		} 
		else if (name.equals("name")) {
			inName = true;
		} 
		else if (name.equals("price")) {
			inPrice = true;
		} 
		else if (name.equals("texture")) {
			inTexture = true;
		}
		else if (name.equals("color")) {
			inColor = true;
		}
	}
	
	public void processEndElement(XmlPullParser event) {
		String name = event.getName();
		if (name.equals("fruits")) {
			inFruits = false;
		}
		else if (name.equals("fruit")) {
			inFruit = false;
			currentFruitList.add(currentFruit);
		} 
		else if (name.equals("id")) {
			inId = false;
		} 
		else if (name.equals("name")) {
			inName = false;
		} 
		else if (name.equals("price")) {
			inPrice = false;
		} 
		else if (name.equals("texture")) {
			inTexture = false;
		}
		else if (name.equals("color")) {
			inColor = false;
		}
	}

	public void processText(XmlPullParser event) throws XmlPullParserException {
		if(inId) {
			String s = event.getText();
			currentFruit.setId(Integer.parseInt(s));
		}
		if(inName) {
			String s = event.getText();
			currentFruit.setName(s);;
		}
		if(inPrice) {
			String s = event.getText();
			currentFruit.setPrice(Double.parseDouble(s));
		}
		if(inTexture) {
			String s = event.getText();
			currentFruit.setTexture(s);
		}
		if(inColor) {
			String s = event.getText();
			currentFruit.setColor(s);
		}
	}
}
