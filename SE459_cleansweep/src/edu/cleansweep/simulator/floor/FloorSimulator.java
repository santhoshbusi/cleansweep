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
		if (logger.isDebugEnabled()) {
			logger.debug("getBareFloorState() was called.");
			}
		return bareFloorState;
	}

	public void setBareFloorState(FloorState bareFloorState) {
		if (logger.isDebugEnabled()) {
			logger.debug("setBareFloorState() was called.");
			}
		this.bareFloorState = bareFloorState;
	}

	public FloorState getLowPileState() {
		if (logger.isDebugEnabled()) {
			logger.debug("getLowPileState() was called: return lowPileState - " + lowPileState);
			}
		return lowPileState;
	}

	public void setLowPileState(FloorState lowPileState) {
		if (logger.isDebugEnabled()) {
			logger.debug("setLowPileState() was called.");
			}
		this.lowPileState = lowPileState;
	}

	public FloorState getHighPileState() {
		if (logger.isDebugEnabled()) {
			logger.debug("getHighPileState() was called: return highPileState - " + highPileState);
			}
		return highPileState;
	}

	public void setHighPileState(FloorState highPileState) {
		if (logger.isDebugEnabled()) {
			logger.debug("setHighPileState() was called.");
			}
		this.highPileState = highPileState;
	}

	public FloorState getCurrentState()
	{
		if (logger.isDebugEnabled()) {
			logger.debug("getCurrentState() was called: return current - " + current);
			}
		return current;
	}
	
	public void setCurrentState(FloorState _state)
	{
		if (logger.isDebugEnabled()) {
			logger.debug("setCurrentState() was called.");
			}
		current = _state;
	}

	public void switchToLowPile()
	{
		if (logger.isDebugEnabled()) {
			logger.debug("switchToLowPile() was called.");
			}
		current.SwitchLowPile();
	}
	
	public void switchToHighPile()
	{
		if (logger.isDebugEnabled()) {
			logger.debug("switchToHighPile() was called.");
			}
		current.SwitchHighPile();
	}
	
	public void switchToBareFloor()
	{
		if (logger.isDebugEnabled()) {
			logger.debug("switchToBareFloor() was called.");
			}
		current.SwitchBareFloor();
	}
}
