import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;

/**
 * This class loads sequence data from a file.
 * BUT we want to defer some decisions until we create a subclass
 * in this case we'll show how to make this class abstract
 * @author marek
 *
 */

public abstract class SequenceLoaderAbstract {

	protected String sequence;
	
	/**
	 * sets this instance's sequence to the indicated sequence
	 * (example of a "setter" method)
	 * @param s the new sequence
	 */
	public void setSequence(String s){
		sequence = s;
		
	}
	/**
	 * @return this instance's sequence
	 * (example of a "getter" method
	 */
	public String getSequence(){
		return sequence;
	}
	
	/**
	 * loads a sequence from a file that the user chooses
	 */
	public void loadSequenceFromFile(){
		//the next two lines show the dialog
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		//pass the selected file to the loadSequenceFromFile method
		loadSequenceFromFile(fc.getSelectedFile().getAbsolutePath());
	}
	
	/**
	 * loads a sequence from the indicated file
	 * @param filepath the path to the file that contains the sequence to load
	 */
	public void loadSequenceFromFile(String filepath){
		try {
			sequence = new String(Files.readAllBytes(Paths.get(filepath)));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Loads a sequence from the indicated filepath and tests the time required to concatenate the sequence with itself the indicated number of times
	 * @param filepath the path to the file that contains the sequence
	 * @param times the number of times to concatenate sequence to itself
	 * @return time elapsed in nanoseconds required to concatenate sequence to itself the indicated number of times
	 */
	public long testConcatenate(String filepath, int times){
		loadSequenceFromFile(filepath);		
		
		long t1 = System.nanoTime();
		
		concatenate(sequence, times);
		
		long elapsedTime = System.nanoTime() - t1;
		
		return elapsedTime;
	}
	/**
	 * tests the time required to concatenate the sequence with itself the indicated number of times
	 * if sequence is null, the user will select a file form which to load the sequence
	 * @param times the number of times to concatenate sequence to itself
	 * @return time elapsed in nanoseconds required to concatenate sequence to itself the indicated number of times
	 */
	public long testConcatenate(int times){
		
		
		if(sequence == null){
			loadSequenceFromFile();
		}
		
		long t1 = System.nanoTime();
		
		concatenate(sequence, times);
		
		long elapsedTime = System.nanoTime() - t1;
		return elapsedTime;
	}
	
	/**
	 * NOTE: that we are deferring the implementation of this method to a subclass
	 * therefore we are declaring it as abstract.
	 * This method will concatenate String s to the end of sequence the indicated number of times
	 * @param s the string to concatenate to the end of sequence
	 * @param times the number of times s will be concatenated to the end sequence
	 */
	public abstract void concatenate(String s, int times);
	
}
