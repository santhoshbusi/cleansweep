package edu.cleansweep.simulator.dirt;

public class HasDirtState implements DirtState {
	
	private DirtSimulator dirtSimulator;

	public HasDirtState(DirtSimulator _dirtSimulator){
		dirtSimulator = _dirtSimulator;
	}
	
	public void switchClean(){
		dirtSimulator.setCurrentState(dirtSimulator.getCleanState());
		System.out.println("Switching To Clean");
	}
	
	public void switchDirty(){
		dirtSimulator.setCurrentState(dirtSimulator.getDirtyState());
		System.out.println("Switching To Dirty");
	}
	
	public void printState(){
		System.out.println("Dirty");
	}
}
