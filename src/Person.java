public class Person extends Event {

    public int personId;
    public int rideTime;
    public double endTime;
    public double interArrivalTime;
    public double arrivalTime;
    public double travelTime = 0;
    public double elevatorArrivalTime;
    public double startTime;
    public int arrivalFloor=0, destinationFloor=0, currentFloor;
    public boolean externalUpButton;
    public boolean externalDownButton;
    public Elevator assignedElev;
    

public Person(int pId){
    personId = pId;
    arrivalFloor = RandomRates.getRandomFloor();
	destinationFloor = RandomRates.getRandomFloor();
	
    while(arrivalFloor == destinationFloor) {
    	destinationFloor = RandomRates.getRandomFloor();
    }
    interArrivalTime =  RandomRates.calculateInterarrivalTime();
    arrivalTime=EventScheduler.TotalTime+interArrivalTime;
    //System.out.println(arrivalTime);
    EventScheduler.TotalTime = arrivalTime;
   
}
public void CalculateTime()
{
	
	travelTime = Math.abs(assignedElev.currentFloor-arrivalFloor)*2;
	elevatorArrivalTime = arrivalTime+travelTime;
	startTime = elevatorArrivalTime+1;		//after elevator arrives at customer's location add one unit time to get in and start the elevator
	rideTime = Math.abs(destinationFloor-arrivalFloor)*2;
	endTime = startTime+rideTime+1;
	MasterController.elevators.get(assignedElev.elevatorID).currentFloor = destinationFloor;
	MasterController.floortime[arrivalFloor-1][destinationFloor-1] += endTime - arrivalTime;
	//EventScheduler.clockCounter[assignedElev.elevatorID] += 
	//arrivalTime = EventScheduler.clockCounter + travelTime;
	//EventScheduler.clockCounter += arrivalTime;
}
public void assignElev(Elevator e)
{
	this.assignedElev = e;
}





}
