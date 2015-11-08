package edu.cleansweep.simulator.power;

import edu.cleansweep.floor.Location;

public class PowerManager {

	private PowerState _currentState;

	public PowerManager(){
		_currentState = new FullyChargedPowerState();
	}
	
	void setCurrentState(PowerState powerState){
		_currentState = powerState;
	}
	
	PowerState getCurrentState(){
		return _currentState;
	}
	
	public int getCurrentCharge(){
		return _currentState.getCurrentCharge();
	}
	
	public void charge(){
		_currentState = new ChargingPowerState(_currentState.getCurrentCharge());
	}
	
	/**
	 * update current charge level based on path
	 * @param starting location of path
	 * @param ending location of path
	 */
	public void update(Location starting, Location ending){
		_currentState.update(starting, ending);
		_currentState.nextPowerState(this);
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("[PowerManager] Current Charge : ").append(_currentState.getCurrentCharge()).toString();
	}
}
