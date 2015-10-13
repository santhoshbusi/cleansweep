package edu.cleansweep.simulator.floor;

public class BareFloorState implements FloorState {
	
	private FloorSimulator floorSimulator;

	public BareFloorState(FloorSimulator _floorSimulator){
		floorSimulator = _floorSimulator;
	}
	
	@Override
	public void SwitchLowPile() {
		floorSimulator.setCurrentState(floorSimulator.getLowPileState());
		System.out.println("Switch to Low Pile Carpet");
	}
	
	@Override
	public void SwitchHighPile() {
		floorSimulator.setCurrentState(floorSimulator.getHighPileState());
		System.out.println("Switch to High Pile Carpet");
	}

	@Override
	public void SwitchBareFloor() {
		System.out.print("Already On Bare Floor");
	}
	
	@Override
	public void printState(){
		System.out.println("Bare Floor");
	}
}