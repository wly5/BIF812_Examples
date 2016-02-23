import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JPanel;

//a panel is an "inner" section of the GUI - the outer container is the JFrame that we instantiate in main
public class MyFirstGUI extends JPanel{

	private static final long serialVersionUID = 5541128329654819823L;
	//bit of Java trivia - each panel needs a unique identifier
	
	//the fields inside a Panel are the GUI components themselves, such as buttons or text boxes
	Label myLabel;
	
	//let's write a constructor that sets up our GUI
	public MyFirstGUI(){
		//create a layout within our MyFirstGUI JPanel
		//(note: the layout is itself a JPanel)
		JPanel controlsArea = new JPanel(new GridLayout(3,2));
		//set Preferred Size
		setPreferredSize(new Dimension(300,300));
		
		//populate (add controls) to the controlsArea JPanel layout thing
		//NOTE: we don't need to interact with this new Label, so we're not keeping a reference to it here
		controlsArea.add(new Label("Welcome to Java GUIs!"));
		
		//IMPORTANT! don't forget to add the controls area layout (controlsArea) to the MyFirstGUI JPanel
		this.add(controlsArea, BorderLayout.SOUTH);
	}
	
}
