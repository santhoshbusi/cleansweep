package edu.cleansweep.simulator.power;

class DischargingPowerState extends PowerState {
	
	DischargingPowerState(int chargeValue){
		System.out.println("[PowerState] Entering DischargingPowerState");
		_currentCharge = chargeValue;
	}
	

	@Override
	void nextPowerState(PowerManager powerManager) {
		if(powerManager.getCurrentState().getPercentCharge() <= 0)
			powerManager.setCurrentState(new FullyDepletedPowerState());

	}
}
