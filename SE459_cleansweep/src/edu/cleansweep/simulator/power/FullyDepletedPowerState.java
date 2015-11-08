package edu.cleansweep.simulator.power;

import edu.cleansweep.floor.Location;

class FullyDepletedPowerState extends PowerState {

	FullyDepletedPowerState(){
		System.out.println("Entering FullyDepletedPowerState");
		_currentCharge = 0;
	}
	

	@Override
	void nextPowerState(PowerManager powerManager) {
		

	}


}
