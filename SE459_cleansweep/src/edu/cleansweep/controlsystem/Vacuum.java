package edu.cleansweep.controlsystem;


import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.FloorType;
import edu.cleansweep.floor.Location;
import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class Vacuum 
{
	private FloorNavigationProxy floorNavProxy;
	private FloorType _floorType;
	private FloorCleaners _floorCleaners;
	private static final Logger logger = LogManager.getLogger(Vacuum.class.getName());

	
	public Vacuum(FloorNavigationProxy _floorNavProxy)
	{
		this. floorNavProxy = _floorNavProxy;
		this._floorCleaners = new FloorCleaners();
	}
	
	public void doClean(Location location)
	{
		 //clean the location and move to new location
		logger.info("doClean() was called.");
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
