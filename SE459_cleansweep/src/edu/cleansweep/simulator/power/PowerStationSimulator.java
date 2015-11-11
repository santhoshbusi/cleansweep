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
	}

	public StationSimulator getSimulateSignal() {
		if (logger.isDebugEnabled()) {
			logger.debug("getSimulateSignal() was called. return - " + simulateSignal);
			}
		return simulateSignal;
	}

	public void setSimulateSignal(StationSimulator simulateSignal) {
		this.simulateSignal = simulateSignal;
	}

	public StationSimulator getDontSimulateSignal() {
		return dontSimulateSignal;
	}

	public void setDontSimulateSignal(StationSimulator dontSimulateSignal) {
		this.dontSimulateSignal = dontSimulateSignal;
	}

	public StationSimulator getCurrentOutput() {
		return currentOutput;
	}

	public void setCurrentOutput(StationSimulator currentOutput) {
		this.currentOutput = currentOutput;
	}
	
	public void emitSignal(){
		currentOutput.simulateSignal();
	}
	
	public void dontEmitSignal(){
		currentOutput.dontsimulateSignal();
	}
	
	public void printCurrentState(){
		currentOutput.printCurrentSignal();
	}
}
