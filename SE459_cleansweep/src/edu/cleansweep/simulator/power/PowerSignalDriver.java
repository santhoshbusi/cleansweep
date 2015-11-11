package edu.cleansweep.simulator.power;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class PowerSignalDriver {

	private static final Logger logger = LogManager.getLogger(PowerSignalDriver.class.getName());

	public static void main(String [] args){
		
		PowerStationSimulator powerStationSimulator = new PowerStationSimulator();
		
		powerStationSimulator.printCurrentState();
		logger.info("powerStationSimulator.printCurrentState() was called.");
		
		powerStationSimulator.emitSignal();
		logger.info("powerStationSimulator.emitSignal() was called.");
		
		powerStationSimulator.printCurrentState();
		logger.info("powerStationSimulator.printCurrentState() was called.");
		
		powerStationSimulator.dontEmitSignal();
		logger.info("powerStationSimulator.dontEmitSignal() was called.");
		
		powerStationSimulator.printCurrentState();
		logger.info("powerStationSimulator.printCurrentState() was called.");
		
	}

}
