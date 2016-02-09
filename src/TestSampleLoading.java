
public class TestSampleLoading {

	public static void main(String[] args) {
		
		Sample mySample = new Sample();
		long nanoseconds = mySample.testConcatenate(10000);
		double seconds = nanoseconds / (double)1000000000; 
		System.out.println("concatenating took " + seconds + " seconds");

	}

}
