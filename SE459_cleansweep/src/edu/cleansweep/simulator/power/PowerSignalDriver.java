package edu.cleansweep.simulator.power;

public class PowerSignalDriver {
	
	public static void main(String [] args){
		
		PowerStationSimulator powerStationSimulator = new PowerStationSimulator();
		
		powerStationSimulator.printCurrentState();
		
		powerStationSimulator.emitSignal();
		
		powerStationSimulator.printCurrentState();
		
		powerStationSimulator.dontEmitSignal();
		
		powerStationSimulator.printCurrentState();
		
	}

}
