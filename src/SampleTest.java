
public class SampleTest {

	public static void main(String[] args) {
		//instantiate (create a new instance of) the Sample class
		//using default constructor
		Sample s = new Sample();
		//display the state of Sample s
		System.out.println(s.toString());
		//instantiate a second instance of Sample using the non default constructor
		Sample t = new Sample(5, "Shoe Size");
		//display the state of Sample t
		System.out.println(t.toString());
	}

}
