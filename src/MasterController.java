import java.util.*;
public class MasterController {
	static ArrayList<Elevator> elevators = new ArrayList<Elevator>(5);
	static double[][] numPeople = new double[8][8];
	static double[][] floortime = new double[8][8];
	public static Elevator pickElevator(Person p) {
		ArrayList<Elevator> AvailableElevators = new ArrayList<Elevator>(5);
		
		for(Elevator r: elevators)
		{
			if(r.direction==0)
			{
				AvailableElevators.add(r);
			}
		}
		if(p.arrivalFloor-p.destinationFloor>0)
		{
			for(Elevator r: elevators)
			{
				if(r.direction<0)
				{
					AvailableElevators.add(r);
				}
			}
			for(Elevator r: elevators)
			{
				if(r.direction>0)
				{
					AvailableElevators.add(r);
				}
			}
		}
		else 
		{
			for(Elevator r: elevators)
			{
				if(r.direction>0)
				{
					AvailableElevators.add(r);
				}
			}
			for(Elevator r: elevators)
			{
				if(r.direction<0)
				{
					AvailableElevators.add(r);
				}
			}
		}
		int min = Math.abs(AvailableElevators.get(0).currentFloor-p.arrivalFloor);
		Elevator elev = AvailableElevators.get(0);
		for(Elevator r: AvailableElevators)
		{
			
			if(Math.abs(r.currentFloor-p.arrivalFloor)<min)
			{
				elev = r;
			}
			
		}
		
		elevators.get(elev.elevatorID).direction=p.destinationFloor-p.arrivalFloor;
		//elevators.get(elev.elevatorID).currentFloor=p.destinationFloor;
		return elev;
	}
	public final static int customerNumber = 10000;
	
	public static void main(String args[]) {
		LinkedList<Person> customers = new LinkedList<Person>();
		for (int k=0; k<5; k++) elevators.add(new Elevator(k));
				
		for(int i=0 ; i< customerNumber; i++) 
		{
			customers.add(new Person(i));
			Elevator picked = pickElevator(customers.tail.data);
			customers.tail.data.assignElev(picked);
			customers.tail.data.CalculateTime();
			numPeople[customers.tail.data.arrivalFloor-1][ customers.tail.data.destinationFloor-1]++;
			//System.out.println(customers.tail.data.arrivalFloor + ":" + customers.tail.data.destinationFloor + " : " + picked.elevatorID);
			//4th to 1st = 1 time unit get in + 2x|3| time units to reach 1st + 1 time unit to get out
			
		}
		System.out.println("Number of people from floor-i to floor-j:\n");
		for(double[] row: numPeople ) {
			
			for(double col: row) {
				System.out.print("\t"+String.format("%03d", (int)col) + " |\t");
			}
			System.out.println();

		}
		System.out.println("\n\nTotal amount of time spent from floor-i to floor-j:\n");

		for(double[] row: floortime ) {
			for(double col: row) {
				System.out.print("\t"+String.format("%05d", (int)col) + " |\t");
			}
			System.out.println();
		}
		System.out.println("\n\nAverage amount of time spent from floor-i to floor-j:\n");
		for (int i = 0; i < 8; i++)
		{
			for(int j = 0; j <8; j++)
			{
				if(i!=j)
				{
					double temp = floortime[i][j]/numPeople[i][j];
					System.out.print("\t"+String.format("%.2f", temp) + " |\t");
					//System.out.printf("%,.2f%n ", temp, " ");	
				}
				else
				System.out.print( "\t00.00 |\t");	
			}
			System.out.println();
		}
		
	
	

	}
	
	}
