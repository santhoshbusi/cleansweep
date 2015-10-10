package edu.cleansweep.simulator.floor;

public class LowPileState implements FloorState {

	private FloorSimulator floorSimulator;
	
	public LowPileState(FloorSimulator _floorSimulator)
	{
		floorSimulator = _floorSimulator;
	}
	
	public void SwitchLowPile() {
		System.out.println("Already on Low Pile Carpet");
	}

	public void SwitchHighPile() {
		floorSimulator.setCurrentState(floorSimulator.getHighPileState());
		System.out.println("Switched To High Pile");
	}

	public void SwitchBareFloor() {
		floorSimulator.setCurrentState(floorSimulator.getBareFloorState());
		System.out.println("Switched To Bare Floor");
	}
	
	public void printState(){
		System.out.println("Low Pile Carpet");
	}

}
