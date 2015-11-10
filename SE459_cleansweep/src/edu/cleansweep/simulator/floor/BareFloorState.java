package edu.cleansweep.simulator.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class BareFloorState implements FloorState {
	
	private static final Logger logger = LogManager.getLogger(BareFloorState.class.getName());
	private FloorSimulator floorSimulator;

	public BareFloorState(FloorSimulator _floorSimulator){
		logger.info("BareFloorState() was called.");
		floorSimulator = _floorSimulator;
	}
	
	@Override
	public void SwitchLowPile() {
		floorSimulator.setCurrentState(floorSimulator.getLowPileState());
		System.out.println("Switch to Low Pile Carpet");
		logger.info("SwitchLowPile() was called.");
	}
	
	@Override
	public void SwitchHighPile() {
		floorSimulator.setCurrentState(floorSimulator.getHighPileState());
		System.out.println("Switch to High Pile Carpet");
		logger.info("SwitchHighPile() was called.");
	}

	@Override
	public void SwitchBareFloor() {
		System.out.print("Already On Bare Floor");
		logger.info("SwitchBareFloor() was called.");
	}
	
	@Override
	public void printState(){
		System.out.println("Bare Floor");
		logger.info("printState() was called.");
	}
}
