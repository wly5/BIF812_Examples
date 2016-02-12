
public class TestAbstractLoader {

	public static void main(String[] args) {
		SequenceLoaderAbstract sla = new SequenceLoaderConcrete();
		sla.loadSequenceFromFile();
		sla.testConcatenate(3);
		System.out.println("this object's sequence is: " + sla.getSequence());

	}

}
