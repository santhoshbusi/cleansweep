package edu.cleansweep.simulator.dirt;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class DirtSimulatorDriver {
	
	private static final Logger logger = LogManager.getLogger(DirtSimulatorDriver.class.getName());

	public static void main(String[] args){
		
		DirtSimulator dirtSimulator = new DirtSimulator();
		if (logger.isDebugEnabled()) {
			logger.debug("calling printCurrentState()");
			}
		dirtSimulator.printCurrentState();
		if (logger.isDebugEnabled()) {
			logger.debug("calling switchToClean()");
			}
		dirtSimulator.switchToClean();
		if (logger.isDebugEnabled()) {
			logger.debug("calling printCurrentState()");
			}
		dirtSimulator.printCurrentState();
		if (logger.isDebugEnabled()) {
			logger.debug("calling printCurrentState()");
			}
		dirtSimulator.printCurrentState();
		if (logger.isDebugEnabled()) {
			logger.debug("calling printCurrentState()");
			}
		dirtSimulator.printCurrentState();
		if (logger.isDebugEnabled()) {
			logger.debug("calling switchToDirty()");
			}
		dirtSimulator.switchToDirty();
		if (logger.isDebugEnabled()) {
			logger.debug("calling printCurrentState()");
			}
		dirtSimulator.printCurrentState();
	}
}
