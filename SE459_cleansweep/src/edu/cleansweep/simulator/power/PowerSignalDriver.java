package edu.cleansweep.simulator.power;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class PowerSignalDriver {

	private static final Logger logger = LogManager.getLogger(PowerSignalDriver.class.getName());

	public static void main(String [] args){
		
		PowerStationSimulator powerStationSimulator = new PowerStationSimulator();
		
		powerStationSimulator.printCurrentState();
		if (logger.isDebugEnabled()) {
			logger.debug("powerStationSimulator.printCurrentState() was called.");
			}
		
		powerStationSimulator.emitSignal();
		if (logger.isDebugEnabled()) {
			logger.debug("powerStationSimulator.emitSignal() was called.");
			}
		
		powerStationSimulator.printCurrentState();
		if (logger.isDebugEnabled()) {
			logger.debug("powerStationSimulator.printCurrentState() was called.");
			}
		
		powerStationSimulator.dontEmitSignal();
		if (logger.isDebugEnabled()) {
			logger.debug("powerStationSimulator.dontEmitSignal() was called.");
			}
		
		powerStationSimulator.printCurrentState();
		if (logger.isDebugEnabled()) {
			logger.debug("powerStationSimulator.printCurrentState() was called.");
			}		
	}

}
