package edu.cleansweep.simulator.power;

import edu.cleansweep.floor.Location;
/**
 * Used to keep track of Current Power State and Power Units Remaining 
 * @author ajscilingo
 *
 */
public class PowerManager {

	private PowerState _currentState;

	public PowerManager(){
		_currentState = new FullyChargedPowerState();
	}
	
	/**
	 * Set Power State
	 * @param powerState new instance of PowerState representing current PowerState
	 */
	void setCurrentState(PowerState powerState){
		_currentState = powerState;
	}
	
	/**
	 * Current Power State
	 * @returns Current Power State
	 */
	PowerState getCurrentState(){
		return _currentState;
	}
	
	/**
	 * Current Charge Level (Power units remaining)
	 * @return integer value of current charge level 
	 */
	public int getCurrentCharge(){
		return _currentState.getCurrentCharge();
	}
	
	/**
	 * Call this when at a PowerStation to Change State from Discharging to Charging
	 */
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
