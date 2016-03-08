
public class MidtermQuestion5 {

	public static double cmpNets(double[] firstNet, double[] secondNet){
		double sumFirst = 0;
		double sumSecond = 0;
		
		for(int i = 0; i < firstNet.length; i++){
			sumFirst  = sumFirst + firstNet[i];
		}
		
		for(int i =0 ; i < secondNet.length; i++){
			sumSecond = sumSecond + secondNet[i];
		}
	
		return (sumSecond - sumFirst);
	}
	
}
