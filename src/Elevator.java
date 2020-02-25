public class Elevator extends Event {
	
	int elevatorID;
	int arrayOfInternalButtons[] = new int[8];
	int currentFloor = 1;
	int direction = 0;
	
	double arrivalTime;
	
	public Elevator(int eID) {
		elevatorID = eID;
	}
	
	
	
	public void moveUp() {
		currentFloor = currentFloor+1;
	}
	
	public void moveDown() {
		currentFloor = currentFloor-1;	
	}
}
