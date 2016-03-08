
public class MidtermProgrammingQuestion2 {

	public static void main(String[] args) {
		//instantiate a Sequence using non-default ctor
		Sequence s1 = new Sequence("gatcctccat");
		//instantiate a second Sequence using the default ctor
		Sequence s2 = new Sequence();
		//use the setter method to assign a value to s2
		s2.setRawSequence("gatcctccag");
		//display contents of s1
		System.out.println(s1.getRawSequence());
		//display contents of s2
		System.out.println(s2.getRawSequence());
		//compute the similarity between s1 and s2
		double result = s1.similarity(s2);
		//display the similarity
		System.out.println("The similarity is : " + result);

	}

}
