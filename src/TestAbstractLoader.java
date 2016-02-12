
public class TestAbstractLoader {

	public static void main(String[] args) {
		SequenceLoaderAbstract sla = new SequenceLoaderConcrete();
		sla.loadSequenceFromFile();
		sla.testConcatenate(3);
		System.out.println("this object's sequence is: " + sla.getSequence());
		
		
		int position = 100;
		//use the getLetter method declared in the LetterGetter interface
		//(implemented by SequenceLoaderAbstract)
		System.out.println("The letter at " + position + " is " + sla.getLetter(position));

	}

}
