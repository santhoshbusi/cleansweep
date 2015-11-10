package edu.cleansweep.simulator.power;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;
import edu.cleansweep.floor.Location;

class FullyChargedPowerState extends PowerState {

	private static final Logger logger = LogManager.getLogger(FullyChargedPowerState.class.getName());

	FullyChargedPowerState(){
		System.out.println("[PowerState] Entering FullyChargedPowerState");
		_currentCharge = 100;
		logger.info("FullyChargedPowerState() was called.");
	}
	

	@Override
	void nextPowerState(PowerManager powerManager) {
		powerManager.setCurrentState(new DischargingPowerState(_currentCharge));	
		logger.info("nextPowerState() was called.");
	}


}
