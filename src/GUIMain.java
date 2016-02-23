import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * this class will instantiate our JPanel class (MyFirstGUI.java) and places it inside a JFrame
 */
public class GUIMain {

	public static void main(String[] args) {
		
		/*
		 * indicate to the Java VM and GUI system that we want to call createAndShowGUI
		 * asynchronously => which means "sometime later"
		 * notice this is another static method call
		 * 
		 * Runnable is a class related to multithreading
		 * this is also an example of flexible Java syntax where 
		 * we instantiate a class - AND override one of it's methods in the same line
		 * this is called an anyonymous subclass
		 */
		javax.swing.SwingUtilities.invokeLater( new Runnable(){
				
				//override the run() method defined in Runnable
				//notice this is all within the ( ) argument list for invokeLater
				
				public void run(){
					createAndShowGUI();
				}
		}); //the closing ) for the invokeLater argument list
		

	}
	
	/*
	 * create a method to instantiate and set up our JPanel (MyFirstGUI)
	 * you can repeat this "pattern" for all your GUIs
	 * REVIEW: private means that we can only call this method from within the GUIMain class
	 * REVIEW: static means that we can call createAndShowGUI without any instances (objects) i.e. without calling new or any constructors
	 */
	private static void createAndShowGUI(){
		//create a frame that is going to be the outer container for our GUI
		JFrame frame = new JFrame("This is my First GUI :)");
		//get the program to end, when the user closes the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create and set up the content pane (JPanel - MyFirstGUI)
		JComponent myPanel = new MyFirstGUI();
		//make the content pane opaque (visible to the user)
		myPanel.setOpaque(true);
		//associate myPanel (content) with the containing JFrame
		frame.setContentPane(myPanel);
		
		//display the GUI window
		frame.pack();
		frame.setVisible(true);
	}
	

}
