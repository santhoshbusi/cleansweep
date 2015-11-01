package edu.cleansweep.controlsystem;


import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.FloorType;
import edu.cleansweep.floor.Location;

public class Vacuum 
{
	private FloorType _floorType;
	private FloorCleaners _floorCleaners;
	public void doClean(Location location, FloorNavigationProxy floorProxy)
	{
		 //clean the location and move to new location
		_floorType = floorProxy.getFloorType(location);
		if(_floorType.equals(FloorType.BAREFLOOR))
		{
			_floorCleaners.set_floorType(_floorType);
			floorProxy.clean(location);
		}
		if(_floorType.equals(FloorType.LOWPILECARPET))
		{
			_floorCleaners.set_floorType(_floorType);
			floorProxy.clean(location);
		}
		if(_floorType.equals(FloorType.HIGHPILECARPET))
		{
			_floorCleaners.set_floorType(_floorType);
			floorProxy.clean(location);
		}
	 }
}
