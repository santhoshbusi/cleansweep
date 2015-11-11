package edu.cleansweep.simulator.power;

import edu.cleansweep.floor.Location;
import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

class FullyDepletedPowerState extends PowerState {

	private static final Logger logger = LogManager.getLogger(FullyDepletedPowerState.class.getName());

	FullyDepletedPowerState(){
		System.out.println("[PowerState] Entering FullyDepletedPowerState");
		_currentCharge = 0;
		logger.info("FullyDepletedPowerState() was called.");
	}
	

	@Override
	void nextPowerState(PowerManager powerManager) {
		logger.info("nextPowerState() was called.");
		

	}


}
