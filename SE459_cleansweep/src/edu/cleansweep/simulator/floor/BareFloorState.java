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
		if (logger.isDebugEnabled()) {
			logger.debug("SwitchLowPile() was called.");
			}
	}
	
	@Override
	public void SwitchHighPile() {
		floorSimulator.setCurrentState(floorSimulator.getHighPileState());
		System.out.println("Switch to High Pile Carpet");
		if (logger.isDebugEnabled()) {
			logger.debug("SwitchHighPile() was called.");
			}
	}

	@Override
	public void SwitchBareFloor() {
		System.out.print("Already On Bare Floor");
		if (logger.isDebugEnabled()) {
			logger.debug("SwitchBareFloor() was called.");
			}
	}
	
	@Override
	public void printState(){
		System.out.println("Bare Floor");
		if (logger.isDebugEnabled()) {
			logger.debug("printState() was called.");
			}
	}
}
