package edu.cleansweep.simulator.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class HighPileState implements FloorState {
	
	private FloorSimulator floorSimulator;
	private static final Logger logger = LogManager.getLogger(HighPileState.class.getName());

	
	public HighPileState(FloorSimulator _floorSimulator)
	{
		floorSimulator = _floorSimulator;
		logger.info("HighPileState() was called.");
	}
	
	@Override
	public void SwitchLowPile() {
		floorSimulator.setCurrentState(floorSimulator.getLowPileState());
		System.out.println("Switch to Low Pile Carpet");
		logger.info("SwitchLowPile() was called.");
	}

	@Override
	public void SwitchHighPile() {
		System.out.println("Already on High Pile Carpet");
		logger.info("SwitchHighPile() was called.");
	}

	@Override
	public void SwitchBareFloor() {
		floorSimulator.setCurrentState(floorSimulator.getBareFloorState());
		System.out.println("Switch to Bare Floor");
		logger.info("SwitchBareFloor() was called.");
	}
	
	public void printState(){
		System.out.println("High Pile Carpet");
		logger.info("printState() was called.");
	}
}
