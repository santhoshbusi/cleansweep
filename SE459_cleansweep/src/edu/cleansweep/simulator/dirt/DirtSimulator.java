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
		if (logger.isDebugEnabled()) {
			logger.debug("DirtSimulator() was called.");
			}
	}

	public DirtState getDirtyState() {
		if (logger.isDebugEnabled()) {
			logger.debug("getDirtyState() was called: return dirtyState - " + dirtyState);
			}
		return dirtyState;
	}

	public void setDirtyState(DirtState dirtyState) {
		if (logger.isDebugEnabled()) {
			logger.debug("setDirtyState() was called.");
			}
		this.dirtyState = dirtyState;
	}

	public DirtState getCleanState() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCleanState() was called: return cleanState - " + cleanState);
			}
		return cleanState;
	}

	public void setCleanState(DirtState cleanState) {
		if (logger.isDebugEnabled()) {
			logger.debug("setCleanState() was called.");
			}
		this.cleanState = cleanState;
	}

	public DirtState getCurrentState() {
		if (logger.isDebugEnabled()) {
			logger.debug("getCurrentState() was called: return currentState - " + currentState);
			}
		return currentState;
	}

	public void setCurrentState(DirtState currentState) {
		if (logger.isDebugEnabled()) {
			logger.debug("setCurrentState() was called.");
			}

		this.currentState = currentState;
	}
	
	public void switchToClean(){
		if (logger.isDebugEnabled()) {
			logger.debug("switchToClean() was called.");
			}
		currentState.switchClean();
	}
	
	public void switchToDirty(){
		if (logger.isDebugEnabled()) {
			logger.debug("switchToDirty() was called.");
			}
		currentState.switchDirty();
	}
	
	public void printCurrentState(){
		if (logger.isDebugEnabled()) {
			logger.debug("printCurrentState() was called.");
			}
		currentState.printState();
	}
}
