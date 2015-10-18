package edu.cleansweep.simulator.dirt;

public class DirtSimulatorDriver {
	
	public static void main(String[] args){
		
		DirtSimulator dirtSimulator = new DirtSimulator();
		
		dirtSimulator.printCurrentState();
		
		dirtSimulator.switchToClean();
		
		dirtSimulator.printCurrentState();
		
		dirtSimulator.switchToDirty();
		
		dirtSimulator.printCurrentState();
		
		dirtSimulator.switchToDirty();
		
		dirtSimulator.printCurrentState();
	}
}
