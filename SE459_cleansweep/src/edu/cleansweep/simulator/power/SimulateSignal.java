package edu.cleansweep.simulator.power;

public class SimulateSignal implements StationSimulator {

	private PowerStationSimulator powerStationSimulator;
	
	public SimulateSignal(PowerStationSimulator _powerStationSimulator){
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
		System.out.println("Simulating Power Signal");
	}
}
