package edu.cleansweep.simulator.power;

import edu.cleansweep.floor.Location;
import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

/**
 * Used to keep track of Current Power State and Power Units Remaining 
 * @author ajscilingo
 *
 */
public class PowerManager {

	private PowerState _currentState;
	private static final Logger logger = LogManager.getLogger(PowerManager.class.getName());

	public PowerManager(){
		_currentState = new FullyChargedPowerState();
		logger.info("PowerManager() was called.");
	}
	
	/**
	 * Set Power State
	 * @param powerState new instance of PowerState representing current PowerState
	 */
	void setCurrentState(PowerState powerState){
		_currentState = powerState;
		logger.info("setCurrentState() was called.");
	}
	
	/**
	 * Current Power State
	 * @returns Current Power State
	 */
	PowerState getCurrentState(){
		logger.info("getCurrentState() was called. return" + _currentState);
		return _currentState;
	}
	
	/**
	 * Current Charge Level (Power units remaining)
	 * @return integer value of current charge level 
	 */
	public double getCurrentCharge(){
		logger.info("getCurrentCharge() was called. return " + _currentState.getCurrentCharge());
		return _currentState.getCurrentCharge();
	}
	
	/**
	 * Call this when at a PowerStation to Change State from Discharging to Charging
	 */
	public void charge(){
		_currentState = new ChargingPowerState(_currentState.getCurrentCharge());
		logger.info("charge() was called.");
	}
	
	/**
	 * update current charge level based on path
	 * @param starting location of path
	 * @param ending location of path
	 */
	public void update(Location starting, Location ending){
		_currentState.update(starting, ending);
		_currentState.nextPowerState(this);
		logger.info("update() was called.");
	}
	
	/**
	 * Reports the cost of traversing the path.
	 * @param starting location of path.
	 * @param ending location of path.
	 * @return cost of traversing path.
	 */
	public static double getPowerCost(Location starting, Location ending){
		logger.info("getPowerCost() was called.");
		if(starting != null && ending != null )
			return (double)(starting.getPowerCost() + ending.getPowerCost()) / 2;
		else if(starting != null)
			return starting.getPowerCost();
		else
			return 0;
	}
	
	@Override
	public String toString() {
		logger.info("toString() was called.");
		return new StringBuilder().append("[PowerManager] Current Charge : ").append(_currentState.getCurrentCharge()).toString();
	}
}
