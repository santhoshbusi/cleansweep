package edu.cleansweep.controlsystem;

import edu.cleansweep.floor.*;

public class Move implements Movement {
	
	private FloorNavigationProxy floorNavProxy;
	
	public Move(FloorNavigationProxy _floorNavProx)
	{
		floorNavProxy = _floorNavProx;
	}

	@Override
	public Location executeMove(Location _currentLoc, Direction _direction) {
		// TODO Auto-generated method stub
		Location newLocation = floorNavProxy.move(_currentLoc, _direction);
		
		//Check if new location is clean
		if(!newLocation.isClean()){
			floorNavProxy.clean(newLocation);
		}
		
		return newLocation;
	}
}
