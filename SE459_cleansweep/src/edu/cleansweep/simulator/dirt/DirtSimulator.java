package edu.cleansweep.simulator.dirt;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class DirtSimulator {

	private static final Logger logger = LogManager.getLogger(DirtSimulator.class.getName());
	private DirtState dirtyState;
	private DirtState cleanState;
	
	private DirtState currentState;
	
	public DirtSimulator(){
		dirtyState = new HasDirtState(this);
		cleanState = new HasNoDirtState(this);
		//Arbitrary
		currentState = dirtyState;
		logger.info("DirtSimulator() was called.");

	}

	public DirtState getDirtyState() {
		logger.info("getDirtyState() was called: return dirtyState - " + dirtyState);
		return dirtyState;
	}

	public void setDirtyState(DirtState dirtyState) {
		logger.info("setDirtyState() was called.");
		this.dirtyState = dirtyState;
	}

	public DirtState getCleanState() {
		logger.info("getCleanState() was called: return cleanState - " + cleanState);
		return cleanState;
	}

	public void setCleanState(DirtState cleanState) {
		logger.info("setCleanState() was called.");
		this.cleanState = cleanState;
	}

	public DirtState getCurrentState() {
		logger.info("getCurrentState() was called: return currentState - " + currentState);
		return currentState;
	}

	public void setCurrentState(DirtState currentState) {
		logger.info("setCurrentState() was called.");
		this.currentState = currentState;
	}
	
	public void switchToClean(){
		logger.info("switchToClean() was called.");
		currentState.switchClean();
	}
	
	public void switchToDirty(){
		logger.info("switchToDirty() was called.");
		currentState.switchDirty();
	}
	
	public void printCurrentState(){
		logger.info("printCurrentState() was called.");
		currentState.printState();
	}
}
