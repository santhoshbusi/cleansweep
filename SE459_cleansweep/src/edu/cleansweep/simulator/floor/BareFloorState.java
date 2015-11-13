package edu.cleansweep.simulator.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class BareFloorState implements FloorState {
	
	private static final Logger logger = LogManager.getLogger(BareFloorState.class.getName());
	private FloorSimulator floorSimulator;

	public BareFloorState(FloorSimulator _floorSimulator){
		if (logger.isDebugEnabled()) {
			logger.debug("BareFloorState() was called.");
			}
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
