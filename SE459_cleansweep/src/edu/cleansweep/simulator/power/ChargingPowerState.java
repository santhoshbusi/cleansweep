package edu.cleansweep.simulator.power;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

class ChargingPowerState extends PowerState {

	private static final Logger logger = LogManager.getLogger(ChargingPowerState.class.getName());

	ChargingPowerState(double chargeValue){
		System.out.println("[PowerState] Entering ChargingPowerState");
		_currentCharge = chargeValue;
		logger.info("ChargingPowerState() was called.");
	}

	
	void nextPowerState(PowerManager powerManager) {
		if(powerManager.getCurrentState().getPercentCharge() > 0 && powerManager.getCurrentState().getPercentCharge() < 100){
			powerManager.setCurrentState(new DischargingPowerState(_currentCharge));
		}
		else if(powerManager.getCurrentState().getPercentCharge() == 100){
			powerManager.setCurrentState(new FullyChargedPowerState());
		}	
		else{
			powerManager.setCurrentState(new FullyDepletedPowerState());
		}
		logger.info("nextPowerState() was called.");	
	}


}
