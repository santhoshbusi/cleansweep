package edu.cleansweep.simulator.power;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class SimulateSignal implements StationSimulator {

	private PowerStationSimulator powerStationSimulator;
	private static final Logger logger = LogManager.getLogger(SimulateSignal.class.getName());
	
	public SimulateSignal(PowerStationSimulator _powerStationSimulator){
		powerStationSimulator = _powerStationSimulator;
		logger.info("SimulateSignal() was called.");
	}
	@Override
	public void simulateSignal() {
		powerStationSimulator.setCurrentOutput(powerStationSimulator.getSimulateSignal());
		System.out.println("Emitting Signal...");
		logger.info("simulateSignal() was called.");
	}

	@Override
	public void dontsimulateSignal() {
		powerStationSimulator.setCurrentOutput(powerStationSimulator.getDontSimulateSignal());
		System.out.println("Not Emitting Signal...");
		logger.info("dontsimulateSignal() was called.");
	}
	
	@Override
	public void printCurrentSignal(){
		System.out.println("Simulating Power Signal");
		logger.info("printCurrentSignal() was called.");
	}
}
