package edu.cleansweep.simulator.power;

public class PowerStationSimulator {

	private StationSimulator simulateSignal;
	private StationSimulator dontSimulateSignal;
	
	private StationSimulator currentOutput;
	
	public PowerStationSimulator(){
		simulateSignal = new SimulateSignal(this);
		dontSimulateSignal = new DontSimulateSignal(this);
		
		currentOutput = dontSimulateSignal;
	}

	public StationSimulator getSimulateSignal() {
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
