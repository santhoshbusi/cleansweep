package edu.cleansweep.simulator.power;

public class DontSimulateSignal implements StationSimulator {

	private PowerStationSimulator powerStationSimulator;
	
	public DontSimulateSignal(PowerStationSimulator _powerStationSimulator){
		powerStationSimulator = _powerStationSimulator;
	}
	
	@Override
	public void simulateSignal() {
		powerStationSimulator.setCurrentOutput(powerStationSimulator.getSimulateSignal());
		System.out.println("Emitting Signal...");
	}

	@Override
	public void dontsimulateSignal() {
		powerStationSimulator.setCurrentOutput(powerStationSimulator.getDontSimulateSignal());
		System.out.println("Not Emitting Signal...");
	}
	
	@Override
	public void printCurrentSignal(){
		System.out.println("Not Simulating Power Signal");
	}
}
