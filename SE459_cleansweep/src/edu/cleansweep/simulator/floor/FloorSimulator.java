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
		logger.info("FloorSimulator() was called.");
	}
	
	public FloorState getBareFloorState() {
		logger.info("getBareFloorState() was called.");
		return bareFloorState;
	}

	public void setBareFloorState(FloorState bareFloorState) {
		logger.info("setBareFloorState() was called.");
		this.bareFloorState = bareFloorState;
	}

	public FloorState getLowPileState() {
		logger.info("getLowPileState() was called: return lowPileState - " + lowPileState);
		return lowPileState;
	}

	public void setLowPileState(FloorState lowPileState) {
		logger.info("setLowPileState() was called.");
		this.lowPileState = lowPileState;
	}

	public FloorState getHighPileState() {
		logger.info("getHighPileState() was called: return highPileState - " + highPileState);
		return highPileState;
	}

	public void setHighPileState(FloorState highPileState) {
		logger.info("setHighPileState() was called.");
		this.highPileState = highPileState;
	}

	public FloorState getCurrentState()
	{
		logger.info("getCurrentState() was called: return current - " + current);
		return current;
	}
	
	public void setCurrentState(FloorState _state)
	{
		logger.info("setCurrentState() was called.");
		current = _state;
	}

	public void switchToLowPile()
	{
		logger.info("switchToLowPile() was called.");
		current.SwitchLowPile();
	}
	
	public void switchToHighPile()
	{
		logger.info("switchToHighPile() was called.");
		current.SwitchHighPile();
	}
	
	public void switchToBareFloor()
	{
		logger.info("switchToBareFloor() was called.");
		current.SwitchBareFloor();
	}
}
