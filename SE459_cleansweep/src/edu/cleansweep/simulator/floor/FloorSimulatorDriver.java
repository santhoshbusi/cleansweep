package edu.cleansweep.simulator.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class FloorSimulatorDriver {

	private static final Logger logger = LogManager.getLogger(FloorSimulatorDriver.class.getName());

	public static void main(String[] args) {


		FloorSimulator simulator = new FloorSimulator();
		
		//Print current (we start on Bare Floor)
		simulator.getCurrentState().printState();
		if (logger.isDebugEnabled()) {
			logger.debug("getCurrentState() was called.");
			}
		
		//Switch To High Pile
		simulator.switchToHighPile();
		if (logger.isDebugEnabled()) {
			logger.debug("switchToHighPile() was called.");
			}
		
		//try to switch to High Pile
		simulator.switchToHighPile();
		if (logger.isDebugEnabled()) {
			logger.debug("switchToHighPile() was called.");
			}
		
		//Switch To Low Pile
		simulator.switchToLowPile();
		if (logger.isDebugEnabled()) {
			logger.debug("switchToLowPile() was called.");
			}
		
		//Check Current State
		simulator.getCurrentState().printState();
		if (logger.isDebugEnabled()) {
			logger.debug("getCurrentState() was called.");
			}
		
		//Back To Bare Floor
		simulator.switchToBareFloor();
		if (logger.isDebugEnabled()) {
			logger.debug("switchToBareFloor() was called.");
			}
		
	}
}
