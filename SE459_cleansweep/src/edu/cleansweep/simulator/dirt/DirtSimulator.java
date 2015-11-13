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
	}

	public DirtState getDirtyState() {
		if (logger.isDebugEnabled()) {
			logger.debug("getDirtyState() was called: return dirtyState - " + dirtyState);
			}
		return dirtyState;
	}

	public void setDirtyState(DirtState dirtyState) {
		this.dirtyState = dirtyState;
	}

	public DirtState getCleanState() {
		return cleanState;
	}

	public void setCleanState(DirtState cleanState) {
		this.cleanState = cleanState;
	}

	public DirtState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(DirtState currentState) {
		this.currentState = currentState;
	}
	
	public void switchToClean(){
		currentState.switchClean();
	}
	
	public void switchToDirty(){
		currentState.switchDirty();
	}
	
	public void printCurrentState(){
		currentState.printState();
	}
}
