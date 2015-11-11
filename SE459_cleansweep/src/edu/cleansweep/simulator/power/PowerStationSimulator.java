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
		if (logger.isDebugEnabled()) {
			logger.debug("PowerStationSimulator() was called.");
			}
	}

	public StationSimulator getSimulateSignal() {
		if (logger.isDebugEnabled()) {
			logger.debug("getSimulateSignal() was called. return - " + simulateSignal);
			}
		return simulateSignal;
	}

	public void setSimulateSignal(StationSimulator simulateSignal) {
		this.simulateSignal = simulateSignal;
		if (logger.isDebugEnabled()) {
			logger.debug("setSimulateSignal() was called.");
			}
	}

	public StationSimulator getDontSimulateSignal() {
		if (logger.isDebugEnabled()) {
			logger.debug("getDontSimulateSignal() was called. return =" + dontSimulateSignal);
			}
		return dontSimulateSignal;
	}

	public void setDontSimulateSignal(StationSimulator dontSimulateSignal) {
		this.dontSimulateSignal = dontSimulateSignal;
		if (logger.isDebugEnabled()) {
			logger.debug("setDontSimulateSignal() was called.");
			}

	}

	public StationSimulator getCurrentOutput() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCurrentOutput() was called. return " + currentOutput);
			}

		return currentOutput;
	}

	public void setCurrentOutput(StationSimulator currentOutput) {
		this.currentOutput = currentOutput;
		if (logger.isDebugEnabled()) {
			logger.debug("setCurrentOutput() was called.");
			}

	}
	
	public void emitSignal(){
		currentOutput.simulateSignal();
		if (logger.isDebugEnabled()) {
			logger.debug("emitSignal() was called.");
			}

	}
	
	public void dontEmitSignal(){
		currentOutput.dontsimulateSignal();
		if (logger.isDebugEnabled()) {
			logger.debug("dontEmitSignal() was called.");
			}

	}
	
	public void printCurrentState(){
		currentOutput.printCurrentSignal();
		if (logger.isDebugEnabled()) {
			logger.debug("printCurrentState() was called.");
			}
	}
}
