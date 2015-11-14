package edu.cleansweep.controlsystem.power;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;
import edu.cleansweep.floor.Location;

class FullyChargedPowerState extends PowerState {

	private static final Logger logger = LogManager.getLogger(FullyChargedPowerState.class.getName());

	FullyChargedPowerState(){
		logger.info("Entering FullyChargedPowerState");
		_currentCharge = 100;
		if (logger.isDebugEnabled()) {
			logger.debug("FullyChargedPowerState() was called.");
			}
	}
	

	@Override
	void nextPowerState(PowerManager powerManager) {
		powerManager.setCurrentState(new DischargingPowerState(_currentCharge));	
	}


}
