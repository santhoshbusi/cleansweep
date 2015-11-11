package edu.cleansweep.simulator.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class LowPileState implements FloorState {

	private FloorSimulator floorSimulator;
	private static final Logger logger = LogManager.getLogger(LowPileState.class.getName());

	
	public LowPileState(FloorSimulator _floorSimulator)
	{
		floorSimulator = _floorSimulator;
		if (logger.isDebugEnabled()) {
			logger.debug("LowPileState() was called.");
			}
	}
	
	public void SwitchLowPile() {
		System.out.println("Already on Low Pile Carpet");
		if (logger.isDebugEnabled()) {
			logger.debug("SwitchLowPile() was called.");
			}
	}

	public void SwitchHighPile() {
		floorSimulator.setCurrentState(floorSimulator.getHighPileState());
		System.out.println("Switched To High Pile");
		if (logger.isDebugEnabled()) {
			logger.debug("setCurrentState() was called.");
			}
	}

	public void SwitchBareFloor() {
		floorSimulator.setCurrentState(floorSimulator.getBareFloorState());
		System.out.println("Switched To Bare Floor");
		if (logger.isDebugEnabled()) {
			logger.debug("SwitchBareFloor() was called.");
			}
	}
	
	public void printState(){
		System.out.println("Low Pile Carpet");
		if (logger.isDebugEnabled()) {
			logger.debug("printState() was called.");
			}
	}

}
