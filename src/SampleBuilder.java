
public class SampleBuilder extends Sample {

	@Override
	public void concatenate(String s, int times) {
		StringBuilder sb = new StringBuilder(sequence);
		for(int i=0;i<times;i++){
			System.out.println("Concatenating using Stringbuilder; time "+ i + " of "+times);
			//sequence = sequence + s; //this was the old test
			sb.append(s);
		}
		sequence = sb.toString();
	
	}
	
	@Override
	public String toString(){
		return super.toString() + " Sequence: " + sequence;
	}
}