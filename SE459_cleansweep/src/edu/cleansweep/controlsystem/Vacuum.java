package edu.cleansweep.controlsystem;


import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.FloorType;
import edu.cleansweep.floor.Location;
import org.apache.log4j.Logger;

public class Vacuum 
{
	private FloorNavigationProxy floorNavProxy;
	private FloorType _floorType;
	private FloorCleaners _floorCleaners;
	private static Logger logger=Logger.getLogger("Vacuum");
	
	public Vacuum(FloorNavigationProxy _floorNavProxy)
	{
		this. floorNavProxy = _floorNavProxy;
		this._floorCleaners = new FloorCleaners();
	}
	
	public void doClean(Location location)
	{
		 //clean the location and move to new location
		logger.info("doClean() was called");
		_floorType = floorNavProxy.getFloorType(location);
		if(_floorType.equals(FloorType.BAREFLOOR))
		{
			_floorCleaners.set_floorType(_floorType);
			floorNavProxy.clean(location);
		}
		if(_floorType.equals(FloorType.LOWPILECARPET))
		{
			_floorCleaners.set_floorType(_floorType);
			floorNavProxy.clean(location);
		}
		if(_floorType.equals(FloorType.HIGHPILECARPET))
		{
			_floorCleaners.set_floorType(_floorType);
			floorNavProxy.clean(location);
		}
	 }
}
