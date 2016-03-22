import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

/**
 * This program opens a data (text) file using the character stream classes
 * these classes are seen throughout the Java API and have other uses beyond these examples
 * check them out in the Java API (especially if they are mentioned in other classes you are 
 * thinking of using!
 * 
 * This program converts lower case text data to upper case text and writes that data to another file
 * @author gares
 *
 */
public class AnotherFileExample {

	public static void main(String[] args)  {
		//declare references to buffered  IO stream objects
		//bufferedreader is for input
		BufferedReader inputStream = null;
		//this one is for output
		PrintWriter outputStream = null;
		
		//first let's get a file name from the user
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		//pass the selected file to the loadSequenceFromFile method
		String inputFileName = fc.getSelectedFile().getAbsolutePath();
		
		
		//file operations can throw exceptions
		//use the try-catch approach
		
		//use new to get a instance of BufferedReader
		//inside the constructor call ()  we're going to instantiate a temporary FileReader Object
		//sometimes called an anonymous object
		try {
			inputStream = new BufferedReader(new FileReader(inputFileName));
			System.out.println("File was opened for reading correctly");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//open an stream for output
		try {
			outputStream = new PrintWriter(new FileWriter("processed_data.txt"));
			/*
			 * use a loop to iterate through the data and turn everything lowercase -> uppercase
			 * read in lines from the file until the end of the file is reached
			 * each line will be stored in the variable: lineOfData
			 * this line of code is saying that the loop will continue until 
			 * the end of file is reached -> in which case inputStream.readLine() will return null
			 */
			//declare a string variable to store each line of input
			String lineOfData;
			while((lineOfData = inputStream.readLine()) != null ){
				//at this point lineOfData already has the next line
				//and we know it's not null because, of the loop condition
				//transform the lineOfData
				String temp = lineOfData.toUpperCase();
				System.out.println("Data: " + temp);//just for debugging
				outputStream.println(temp);//remember this is the one that wraps the FileWriter
				//flush the buffer or force the outputStream to write to the Operating System.. file buffer etc.
				outputStream.flush();//this operation will empty the buffer
			}
			//once we're done with the files
			//we should close them to avoid corrupted files and stuff
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
