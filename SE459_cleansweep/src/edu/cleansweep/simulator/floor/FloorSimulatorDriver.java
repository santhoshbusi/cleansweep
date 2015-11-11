package edu.cleansweep.simulator.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class FloorSimulatorDriver {

	private static final Logger logger = LogManager.getLogger(FloorSimulatorDriver.class.getName());

	public static void main(String[] args) {


		FloorSimulator simulator = new FloorSimulator();
		
		//Print current (we start on Bare Floor)
		simulator.getCurrentState().printState();
		logger.info("getCurrentState() was called.");
		
		//Switch To High Pile
		simulator.switchToHighPile();
		logger.info("switchToHighPile() was called.");
		
		//try to switch to High Pile
		simulator.switchToHighPile();
		logger.info("switchToHighPile() was called.");
		
		//Switch To Low Pile
		simulator.switchToLowPile();
		logger.info("switchToLowPile() was called.");
		
		//Check Current State
		simulator.getCurrentState().printState();
		logger.info("getCurrentState() was called.");
		
		//Back To Bare Floor
		simulator.switchToBareFloor();
		logger.info("switchToBareFloor() was called.");
		
	}
}
