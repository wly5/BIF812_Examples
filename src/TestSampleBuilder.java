
public class TestSampleBuilder {

	public static void main(String[] args) {
		Sample mySample = new SampleBuilder();
		long nanoseconds = mySample.testConcatenate(100);
		double seconds = nanoseconds / (double)1000000000; 
		System.out.println("concatenating using StringBuilder took " + seconds + " seconds");

	}

}
