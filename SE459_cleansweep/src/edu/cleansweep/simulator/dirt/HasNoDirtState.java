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
		if (logger.isDebugEnabled()) {
			logger.debug("switchClean() was called.");
			}
	}
	
	public void switchDirty(){
		dirtSimulator.setCurrentState(dirtSimulator.getDirtyState());
		System.out.println("Switching To Dirty");
		if (logger.isDebugEnabled()) {
			logger.debug("switchDirty() was called.");
			}
	}
	
	public void printState(){
		System.out.println("Clean");
		if (logger.isDebugEnabled()) {
			logger.debug("printState() was called.");
			}
	}
}
