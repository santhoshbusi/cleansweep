package edu.cleansweep.simulator.floor;

public class FloorSimulatorDriver {

	public static void main(String[] args) {
		
		FloorSimulator simulator = new FloorSimulator();
		
		//Print current (we start on Bare Floor)
		simulator.getCurrentState().printState();
		
		//Switch To High Pile
		simulator.switchToHighPile();
		
		//try to switch to High Pile
		simulator.switchToHighPile();
		
		//Switch To Low Pile
		simulator.switchToLowPile();
		
		//Check Current State
		simulator.getCurrentState().printState();
		
		//Back To Bare Floor
		simulator.switchToBareFloor();
		
	}
}
