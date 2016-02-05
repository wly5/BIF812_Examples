/**
 * This class stores data about a sample
 * @author gares
 *
 */
public class Sample {
	//an id field to identify the sample
	private long id;
	private String description;

	public Sample(){
		id = -1;
		description = "NOT INITIALIZED";
	}
	
	public Sample(long newId, String desc){
		id = newId;
		description = desc;
	}
	
	/**
	 * this method returns a string that contains this object's information
	 * in a human readable string
	 * P.S. javadoc is cool
	 */
	public String toString(){
		return "Contents: ID: " + id + " description: "+ description; 
	}
	
}
