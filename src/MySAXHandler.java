import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

//this class extends a class that implements the ContentHandler interface
public class MySAXHandler extends DefaultHandler{
	
	/*
	 * let's override the "hook" methods that get called by the parser when
	 * different document features are reached
	 * these methods are declared in ContentHandler
	 * empty, default implementations are provided in DefaultHandler (concrete base class)
	 */
	
	@Override
	public void startDocument() throws SAXException{
		//left as an exercise
	}
	
	@Override
	public void endDocument() throws SAXException{
		//left as an exercise
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes){
		//left as an exercise
	}
	
	@Override
	public void endElement(String uri, String localName, String qName){
		//left as an exercise
	
	}
	

	public static void main(String[] args) {
		//show a dialog to let the user choose an XML file to parse
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		//pass the selected file to the loadSequenceFromFile method
		String filename = fc.getSelectedFile().getAbsolutePath();
		
		System.out.println("Starting to parse: " + filename);
		//in the java SAX api, you're supposed to get an instance of SAXParser from the SAXParserFactory
		//that means we need an instance of the factory first!
		//NOTE: SAXParserFactory.newInstance() is a static method that returns a SAXParserFactory instance
		SAXParserFactory spf = SAXParserFactory.newInstance();
		//set the namespace for the parser factory
		spf.setNamespaceAware(true);
		//use the factory instance to create a new SAXParser
		//note this might throw some exceptions that must be caught (or declare main as throwing etc.)
		SAXParser sp =null;
		try {
			sp = spf.newSAXParser();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		//create an XML reader for use with the XML parser, and our Handler (which we haven't declared yet)
		XMLReader xmlReader = null;
		try {
			xmlReader = sp.getXMLReader();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		//set a content handler that will interpret or "do something" with the elements in the XML document
		//first instantiate the handler class (this class itself)
		MySAXHandler handler = new MySAXHandler();
		//associate the handler with the xml reader
		xmlReader.setContentHandler(handler);
	}

}
