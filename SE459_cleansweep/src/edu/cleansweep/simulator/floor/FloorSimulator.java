package edu.cleansweep.simulator.floor;

public class FloorSimulator {
	
	FloorState bareFloorState;
	FloorState lowPileState;
	FloorState highPileState;
	
	FloorState current;
	
	public FloorSimulator(){
		bareFloorState = new BareFloorState(this);
		lowPileState = new LowPileState(this);
		highPileState = new HighPileState(this);
		//Arbitrary
		current = bareFloorState;
	}
	
	public FloorState getBareFloorState() {
		return bareFloorState;
	}

	public void setBareFloorState(FloorState bareFloorState) {
		this.bareFloorState = bareFloorState;
	}

	public FloorState getLowPileState() {
		return lowPileState;
	}

	public void setLowPileState(FloorState lowPileState) {
		this.lowPileState = lowPileState;
	}

	public FloorState getHighPileState() {
		return highPileState;
	}

	public void setHighPileState(FloorState highPileState) {
		this.highPileState = highPileState;
	}

	public FloorState getCurrentState()
	{
		return current;
	}
	
	public void setCurrentState(FloorState _state)
	{
		current = _state;
	}

	public void switchToLowPile()
	{
		current.SwitchLowPile();
	}
	
	public void switchToHighPile()
	{
		current.SwitchHighPile();
	}
	
	public void switchToBareFloor()
	{
		current.SwitchBareFloor();
	}
}
