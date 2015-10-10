package edu.cleansweep.simulator.floor;

public class HighPileState implements FloorState {
	
	private FloorSimulator floorSimulator;
	
	public HighPileState(FloorSimulator _floorSimulator)
	{
		floorSimulator = _floorSimulator;
	}
	
	@Override
	public void SwitchLowPile() {
		floorSimulator.setCurrentState(floorSimulator.getLowPileState());
		System.out.println("Switch to Low Pile Carpet");
	}

	@Override
	public void SwitchHighPile() {
		System.out.println("Already on High Pile Carpet");
	}

	@Override
	public void SwitchBareFloor() {
		floorSimulator.setCurrentState(floorSimulator.getBareFloorState());
		System.out.println("Switch to Bare Floor");
	}
	
	public void printState(){
		System.out.println("High Pile Carpet");
	}
}
