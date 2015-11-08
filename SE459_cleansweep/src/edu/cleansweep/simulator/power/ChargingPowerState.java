package edu.cleansweep.simulator.power;

class ChargingPowerState extends PowerState {
	
	ChargingPowerState(int chargeValue){
		System.out.println("Entering ChargingPowerState");
		_currentCharge = chargeValue;
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
			
	}


}
