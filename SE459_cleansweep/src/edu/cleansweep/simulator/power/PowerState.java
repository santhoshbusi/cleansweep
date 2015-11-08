package edu.cleansweep.simulator.power;

import edu.cleansweep.floor.Location;

/**
 * Extend this class to represent a power state 
 * of a vacuum system 
 * @author ajscilingo
 *
 */

abstract class PowerState {

	protected int _currentCharge = 100;
	private static int _fullCharge = 100;
	
	int getPercentCharge(){
		return (int)(( (double)_currentCharge / (double)_fullCharge) * 100);
	}
	
	int getCurrentCharge(){
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
		_currentCharge -= (start.getPowerCost() + end.getPowerCost()) / 2;
	}
	
}
