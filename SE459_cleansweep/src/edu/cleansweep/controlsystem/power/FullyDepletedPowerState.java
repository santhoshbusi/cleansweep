package edu.cleansweep.controlsystem.power;

import edu.cleansweep.floor.Location;
import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

class FullyDepletedPowerState extends PowerState {

	private static final Logger logger = LogManager.getLogger(FullyDepletedPowerState.class.getName());

	FullyDepletedPowerState(){
		System.out.println("[PowerState] Entering FullyDepletedPowerState");
		_currentCharge = 0;
	}
	

	@Override
	void nextPowerState(PowerManager powerManager) {
		if (logger.isDebugEnabled()) {
			logger.debug("nextPowerState() was called.");
			}		
	}
}
