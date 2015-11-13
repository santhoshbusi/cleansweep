package edu.cleansweep.simulator.dirt;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class HasNoDirtState implements DirtState {

	private DirtSimulator dirtSimulator;
	private static final Logger logger = LogManager.getLogger(HasNoDirtState.class.getName());

	public HasNoDirtState(DirtSimulator _dirtSimulator){
		if (logger.isDebugEnabled()) {
			logger.debug("HasNoDirtState() was called.");
			}
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
		System.out.println("Clean");
	}
}
