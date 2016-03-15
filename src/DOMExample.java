import java.io.IOException;

import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * This program uses the DOM style parser built into Java.
 * The relevant classes are:
 * Document which represents the XML document parsed into a tree
 * DocumentBuilder parses an XML document and creates a Document instance for you
 * DocumentBuilderFactory which is a class for instantiating DocumentBuilders on our behalf
 * NodeList is a class that represents a list of DOM tree nodes - not necessarily in any kind of order
 * NodeList uses the familar List API
 * Node is a class that represents one Node or element in the DOM tree
 * note: once again we don't use new to instantiate any of these classes
 * (this is fairly common in frameworks)
 * 
 * Exercises:
 * 1) perform a depth first traversal of the tree - recall using a list of nodes to visit
 * visit each element and print: the element name, attributes (if any), element text (if any)
 * 2) use a different output stream to write the modified XML document to a file instead of standard output
 * 3) open an XML document from a remote URL and parse it.
 */
public class DOMExample {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		//first step is to get the DocumentBuilderFactory
		//use a static method call (we use the class name instead of a reference to an instance)
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		//get a DocumentBuilder from the factory
		//the factory will deal with the complexity of properly initializing the class
		DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
		
		//allow the user to choose a file...
		//as an exercise you may implement this in its own function that returns a string
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		//pass the selected file to the loadSequenceFromFile method
		String filename = fc.getSelectedFile().getAbsolutePath();
		
		
		//parse the input xml file to create a Document
		Document document = docBuilder.parse(filename);
		//now document will contain the entire XML document as a tree structure that we can traverse..
		//we can traverse this document in any arbitrary way we want
		//and we can edit the document as well.
		
		//Document.getDocumentElement() gets us the root Node (root element)
		//we can get the name of each Node (element) by calling Node.getNodeName()
		System.out.println("Root element of " + filename + " is: " + document.getDocumentElement().getNodeName());
		
		//search the tree for particular elements by using the Document.getElementsByTagName(String name)
		NodeList myNodeList = document.getElementsByTagName("URL");
		//iterate through the NodeList using a loop and the familiar List Interface
		for(int i =0; i < myNodeList.getLength(); i++){
			//get a node by index by calling NodeList.item(int index)
			Node myNode = myNodeList.item(i);
			//use the Node.getTextContent() method to retrieve the text from the element
			System.out.println(myNode.getTextContent());
		}
		//demonstrate some other methods on another node to experiment on
		//get a different node using getElementByName
		//using method call chaining call .item() immediately on the NodeList that was returned
		//this gets us the first node in the list!
		Node anotherNode = document.getElementsByTagName("ReferenceClinVarAssertion").item(0);
		//let's display anotherNode's name to be sure we got something valid
		System.out.println("the name of the node we are playing with is: "+ anotherNode.getNodeName());
		//now we can do more interesting things like inspect anotherNode's parents and children. So cool!
		//get anotherNode's parent
		Node parentNode = anotherNode.getParentNode();
		//display the parentNode information
		System.out.println("The tag (name) of anotherNode's parent node is: " + parentNode.getNodeName());
		//let's attempt to also show the parent node's attributes
		//The class that represents an Attribute is called Attr
		NamedNodeMap attributes = parentNode.getAttributes();
		//write a for loop to iterate through the list of attributes
		System.out.println("Listing the parent node's attributes:");
		for(int i = 0; i < attributes.getLength(); i++){
			System.out.println(attributes.item(i));
		}
		
		//now instead of the parent, let's get anotherNode's (ReferenceClinVarAssertion) children and list them
		System.out.println("Now printing out ReferenceClinVarAssertion's child nodes");;
		NodeList childList = anotherNode.getChildNodes();
		for(int i = 0; i< childList.getLength(); i++){
			Node childNode = childList.item(i);
			if(childNode.getNodeType() == Node.ELEMENT_NODE){
				System.out.println("This child's tag: " + childNode.getNodeName() + " Text content (if any): " +childNode.getTextContent() );
			}
		}
		
		//example of editing the DOM tree
		//add a child element to the exsting DOM tree
		//create a new element that is not in the tree yet
		Element aNewElement = document.createElement("Lunch");
		//use Node.appendChild to actually add the child into the tree
		//we're specifying the new element's parent...
		anotherNode.appendChild(aNewElement);
		
		//add a new attribute to an existing element
		//recall: Attr class represents an attribute
		Attr newAttr = document.createAttribute("sandwich");
		//assign the value of the attribute (currently it's blank)
		newAttr.setNodeValue("cold cut combo sub");
		//add the attribute as a child of an element
		aNewElement.setAttributeNode(newAttr);
		
		//let's write the newly modified XML file to disk
		//we use the Transformer class to perform the output task
		//again, this uses static method calls and factories to get instances of the relevant classes
		TransformerFactory tFactory = TransformerFactory.newInstance();
		//get a Transformer from that factory
		Transformer transformer = tFactory.newTransformer();
		
		//create a new DOMSouce object
		DOMSource src = new DOMSource(document);
		//try to write this new xml document (to standard output (console) for now
		StreamResult stream = new StreamResult(System.out);
		transformer.transform(src, stream);
		
	}

}



