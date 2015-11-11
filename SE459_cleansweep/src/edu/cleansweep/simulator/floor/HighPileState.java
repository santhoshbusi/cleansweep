package edu.cleansweep.simulator.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class HighPileState implements FloorState {
	
	private FloorSimulator floorSimulator;
	private static final Logger logger = LogManager.getLogger(HighPileState.class.getName());

	
	public HighPileState(FloorSimulator _floorSimulator)
	{
		floorSimulator = _floorSimulator;
	}
	
	@Override
	public void SwitchLowPile() {
		floorSimulator.setCurrentState(floorSimulator.getLowPileState());
		System.out.println("Switch to Low Pile Carpet");
		if (logger.isDebugEnabled()) {
			logger.debug("SwitchLowPile() was called.");
			}
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
