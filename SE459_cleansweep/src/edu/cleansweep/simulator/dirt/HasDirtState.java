package edu.cleansweep.simulator.dirt;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class HasDirtState implements DirtState {

	private static final Logger logger = LogManager.getLogger(HasDirtState.class.getName());
	private DirtSimulator dirtSimulator;

	public HasDirtState(DirtSimulator _dirtSimulator){
		logger.info("HasDirtState() was called.");

		dirtSimulator = _dirtSimulator;
	}
	
	public void switchClean(){
		dirtSimulator.setCurrentState(dirtSimulator.getCleanState());
		System.out.println("Switching To Clean");
		logger.info("switchClean() was called.");

	}
	
	public void switchDirty(){
		dirtSimulator.setCurrentState(dirtSimulator.getDirtyState());
		System.out.println("Switching To Dirty");
		logger.info("switchDirty() was called.");

	}
	
	public void printState(){
		System.out.println("Dirty");
		logger.info("printState() was called.");

	}
}
