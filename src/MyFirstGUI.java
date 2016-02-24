import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Button;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * This example gui uses Label, JTextArea and Button to let a user enter a sequence string
 * and a search string. When the user presses the button, the program could search for the 
 * search string within the sequence string, and show the result using the searchResult Label
 * Performing the actual search is left as an exercise.
 * NOTE: a panel is an "inner" section of the GUI - the outer container is the JFrame that we instantiate in main
 */
public class MyFirstGUI extends JPanel{

	private static final long serialVersionUID = 5541128329654819823L;
	//bit of Java trivia - each panel needs a unique identifier
	
	//the fields inside a Panel are the GUI components themselves, such as buttons or text boxes
	//display the result of the search to the user
	Label searchResult;
	//a text field to hold the string that we are searching within
	JTextArea sequenceBox;
	//a text field to hold the string that the user is looking for within the first text field
	JTextArea searchBox;
	//a button that the user can press to search the first text field for the string in the second field
	Button searchButton;
	//let's write a constructor that sets up our GUI
	public MyFirstGUI(){
		//create a layout within our MyFirstGUI JPanel
		//(note: the layout is itself a JPanel)
		JPanel controlsArea = new JPanel(new GridLayout(3,2));
		//set Preferred Size
		//setPreferredSize(new Dimension(500,400));
		
		//populate (add controls) to the controlsArea JPanel layout thing
		//NOTE: we don't need to interact with this new Label, so we're not keeping a reference to it here
		controlsArea.add(new Label("Sequence:"));
		
		//instantiate the sequence box and add it to the layout
		sequenceBox = new JTextArea();
		controlsArea.add(sequenceBox);
		
		//instantiate and add the search label to the layout
		controlsArea.add(new Label("Search for: "));
		
		//instantiate the search box and add it to the layout
		searchBox = new JTextArea();
		controlsArea.add(searchBox);
		
		//instantiate the button and add it to the layout
		searchButton = new Button("XXX");
		controlsArea.add(searchButton);
		
		//instantiate and add the result label - that displays the result to the us
		searchResult = new Label("<== click the button to search ");
		controlsArea.add(searchResult);
		
		//IMPORTANT! don't forget to add the controls area layout (controlsArea) to the MyFirstGUI JPanel
		this.add(controlsArea, BorderLayout.SOUTH);
	}
	
}
