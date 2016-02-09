/**
 * This class stores data about a sample
 * @author gares
 *
 */
public class Sample extends SequenceLoader{
	//an id field to identify the sample
	private long id;
	private String description;

	public Sample(){
		//demonstrate calling one constructor from the other
		this(-1,"NOT INITIALIZED");
		//id = -1;
		//description = "NOT INITIALIZED";
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
	@Override
	public String toString(){
		return "Contents: ID: " + id + " description: "+ description; 
	}
	
}
