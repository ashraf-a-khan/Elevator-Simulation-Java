
import java.util.*;
public class RandomRates {
    public static final double  arrivalRate = 0.6;



    public static double generateRandomVariable(){
        Random rand=new Random();
        double randVariable=rand.nextDouble();
        return randVariable;
    }

    public static double calculateInterarrivalTime(){
        double a = -Math.log(generateRandomVariable())/arrivalRate;
        return a;
    }
    
    
    public static double getRandomDoubleBetweenRange(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;
        return x;
    }
  
    public static int getRandomIntegerBetweenRange(int min, int max){
        int x = (int) (Math.random()*((max-min)+1))+min;
        return x;
    }
    
    
    
    public static int getRandomFloor(){ //Generate floor number
    	
    	if( getRandomDoubleBetweenRange(0,10) <= 5) {
    		return 1;
    	}else {
    		return getRandomIntegerBetweenRange(2,8);
    	}
    }

    
}
