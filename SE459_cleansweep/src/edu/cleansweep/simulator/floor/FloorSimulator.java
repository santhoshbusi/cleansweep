package edu.cleansweep.simulator.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class FloorSimulator {
	
	private FloorState bareFloorState;
	private FloorState lowPileState;
	private FloorState highPileState;
	private static final Logger logger = LogManager.getLogger(FloorSimulator.class.getName());

	
	private FloorState current;
	
	public FloorSimulator(){
		bareFloorState = new BareFloorState(this);
		lowPileState = new LowPileState(this);
		highPileState = new HighPileState(this);
		//Arbitrary
		current = bareFloorState;
		if (logger.isDebugEnabled()) {
			logger.debug("FloorSimulator() was called.");
			}
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
