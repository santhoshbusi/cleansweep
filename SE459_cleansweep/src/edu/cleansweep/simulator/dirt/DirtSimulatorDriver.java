package edu.cleansweep.simulator.dirt;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class DirtSimulatorDriver {
	
	private static final Logger logger = LogManager.getLogger(DirtSimulatorDriver.class.getName());

	public static void main(String[] args){
		
		DirtSimulator dirtSimulator = new DirtSimulator();
		
		logger.info("calling printCurrentState()");
		dirtSimulator.printCurrentState();
		logger.info("calling switchToClean()");
		dirtSimulator.switchToClean();
		logger.info("calling printCurrentState()");
		dirtSimulator.printCurrentState();
		logger.info("calling printCurrentState()");
		dirtSimulator.printCurrentState();
		logger.info("calling printCurrentState()");
		dirtSimulator.printCurrentState();
		logger.info("calling switchToDirty()");
		dirtSimulator.switchToDirty();
		logger.info("calling printCurrentState()");
		dirtSimulator.printCurrentState();
	}
}
