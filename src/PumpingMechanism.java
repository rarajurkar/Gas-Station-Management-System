import java.util.Random;

public class PumpingMechanism {
	
	private boolean startFlow;
	private boolean cutOff = false;
	static int counter; 
	double quantity=0;
	static Random random = new Random();
	static int low = 5;
	static int high =20;
	static final int result = random.nextInt(high-low)+low;
	public void startFlow(String selectedGrade){
		startFlow = true;
	}
	public boolean isCutOff(){
		
		
		// when counter will be equal to random value n then
		
		///System.out.println("Random Number : "+result);
		///System.out.println("Counter : "+counter);
		
		//repeat the following while counter hits the random number
		if(result==counter){
			cutOff = true;
			startFlow = false;
		}
		else{
			counter++;
		}
		return cutOff;
	}
	public double getVolume() {
		quantity+=0.5;
		return quantity;
		
	}
}
