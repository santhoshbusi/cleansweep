package edu.cleansweep.simulator.power;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class PowerStationSimulator {

	private StationSimulator simulateSignal;
	private StationSimulator dontSimulateSignal;
	private static final Logger logger = LogManager.getLogger(PowerStationSimulator.class.getName());
	
	private StationSimulator currentOutput;
	
	public PowerStationSimulator(){
		simulateSignal = new SimulateSignal(this);
		dontSimulateSignal = new DontSimulateSignal(this);
		
		currentOutput = dontSimulateSignal;
		logger.info("PowerStationSimulator() was called.");
	}

	public StationSimulator getSimulateSignal() {
		logger.info("getSimulateSignal() was called. return - " + simulateSignal);
		return simulateSignal;
	}

	public void setSimulateSignal(StationSimulator simulateSignal) {
		this.simulateSignal = simulateSignal;
		logger.info("setSimulateSignal() was called.");
	}

	public StationSimulator getDontSimulateSignal() {
		logger.info("getDontSimulateSignal() was called. return =" + dontSimulateSignal);
		return dontSimulateSignal;
	}

	public void setDontSimulateSignal(StationSimulator dontSimulateSignal) {
		this.dontSimulateSignal = dontSimulateSignal;
		logger.info("setDontSimulateSignal() was called.");
	}

	public StationSimulator getCurrentOutput() {
		logger.info("getCurrentOutput() was called. return " + currentOutput);
		return currentOutput;
	}

	public void setCurrentOutput(StationSimulator currentOutput) {
		this.currentOutput = currentOutput;
		logger.info("setCurrentOutput() was called.");
	}
	
	public void emitSignal(){
		currentOutput.simulateSignal();
		logger.info("emitSignal() was called.");
	}
	
	public void dontEmitSignal(){
		currentOutput.dontsimulateSignal();
		logger.info("dontEmitSignal() was called.");
	}
	
	public void printCurrentState(){
		currentOutput.printCurrentSignal();
		logger.info("printCurrentState() was called.");
	}
}
