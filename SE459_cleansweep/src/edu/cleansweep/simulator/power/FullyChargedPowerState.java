package edu.cleansweep.simulator.power;

import edu.cleansweep.floor.Location;

class FullyChargedPowerState extends PowerState {

	FullyChargedPowerState(){
		System.out.println("Entering FullyChargedPowerState");
		_currentCharge = 100;
	}
	

	@Override
	void nextPowerState(PowerManager powerManager) {
		powerManager.setCurrentState(new DischargingPowerState(_currentCharge));	
	}


}
