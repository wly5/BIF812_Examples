/**
 * this class is an example of implementing the abstract methods in a super class
 * and therefore declaring a concrete subclass based on that abstract parent
 * @author marek
 *
 */
public class SequenceLoaderConcrete extends SequenceLoaderAbstract {

	
	@Override
	/**
	 * notice that here we are providing an implementation of the abstract method
	 * declared in SequenceLoaderAbstract => therefore SequenceLoaderConcrete does not
	 * need to be declared as abstract
	 */
	public void concatenate(String s, int times) {
		
		for(int i=0;i<times;i++){
			System.out.println("Concatenating time "+ i + " of "+times);
			sequence = sequence + s;
		}
		
	}
	

}
