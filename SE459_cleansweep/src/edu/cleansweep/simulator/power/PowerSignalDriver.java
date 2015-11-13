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
		powerStationSimulator.printCurrentState();
		powerStationSimulator.dontEmitSignal();
		powerStationSimulator.printCurrentState();
	}

}
