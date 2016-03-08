
public class Sample {
	
	//data members
	private int unique_id; //could also have used long
	private String source;
	private String sequence;
	//3 argument constructor
	public Sample(int uid, String src, String seq){
		unique_id = uid;
		source = src;
		sequence = seq;
	}
	
	//alternate version of 3 argument constructor
	public Sample(int unique_id, String source, String sequence){
		this.unique_id = unique_id;
		this.source = source;
		this.sequence = sequence;
	}
	//getters
	public int getID(){
		return unique_id;
	}
	
	public String getSource(){
		return source;
	}
	
	public String getSequence(){
		return sequence;
	}
	
	//setters
	public void setID(int id){
		unique_id = id;
	}
	
	public void setSource(String src){
		source = src;
	}
	
	public void setSequence(String seq){
		sequence = seq;
	}
	//compare method
	public boolean compare(Sample other){
		return sequence == other.sequence;
	}
}
