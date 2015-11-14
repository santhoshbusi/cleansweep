package edu.cleansweep.controlsystem.power;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

class DischargingPowerState extends PowerState {

	private static final Logger logger = LogManager.getLogger(DischargingPowerState.class.getName());

	DischargingPowerState(double chargeValue){
		System.out.println("[PowerState] Entering DischargingPowerState");
		_currentCharge = chargeValue;
		if (logger.isDebugEnabled()) {
			logger.debug("DischargingPowerState() was called.");
			}
	}
	

	@Override
	void nextPowerState(PowerManager powerManager) {
		if(powerManager.getCurrentState().getPercentCharge() <= 0)
			powerManager.setCurrentState(new FullyDepletedPowerState());
	}
}
