package edu.cleansweep.simulator.power;

import edu.cleansweep.floor.Location;
import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

/**
 * Extend this class to represent a power state 
 * of a vacuum system 
 * @author ajscilingo
 *
 */

abstract class PowerState {

	protected double _currentCharge = 100;
	private static int _fullCharge = 100;
	private static final Logger logger = LogManager.getLogger(PowerState.class.getName());
	
	double getPercentCharge(){
		if (logger.isDebugEnabled()) {
			logger.debug("getPercentCharge() was called. return - " + (_currentCharge / (double)_fullCharge) * 100);
			}
		return (_currentCharge / (double)_fullCharge) * 100;
	}
	
	double getCurrentCharge(){
		if (logger.isDebugEnabled()) {
			logger.debug("getCurrentCharge() was called. return - " + _currentCharge);
			}
		return _currentCharge;
	}
	
	/**
	 * Implement to switch between states
	 * @param powerManager PowerManager instance
	 */
	abstract void nextPowerState(PowerManager powerManager);
	
	/**
	 * update current power unit level
	 * @param start starting location of path
	 * @param end ending location of path
	 */
	public void update(Location start, Location end){
		if(start != null && end != null )
			_currentCharge -= (double)(start.getPowerCost() + end.getPowerCost()) / 2;
		else if(start != null)
			_currentCharge -= start.getPowerCost();
		else
			_currentCharge += 0;
			
		if (logger.isDebugEnabled()) {
			logger.debug("update() was called.");
			}
	}
	
}
