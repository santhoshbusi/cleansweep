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
	private DirtRepository _dirtRepository;
	private static final Logger logger = LogManager.getLogger(Vacuum.class.getName());

	
	public Vacuum(FloorNavigationProxy _floorNavProxy)
	{
		this. floorNavProxy = _floorNavProxy;
		this._floorCleaners = new FloorCleaners();
		this._dirtRepository = new DirtRepository();
	}
	
	public int getDirtCount(){
		return _dirtRepository.getCurrentDirt();
	}
	
	public boolean doClean(Location location)
	{
		if(_dirtRepository.getCurrentDirt() >= DirtRepository.MAXIMUM){
			_dirtRepository.setIsFullStatus(true);
			logger.debug("Repository is Full - No More Cleaning");
			return false;
		}
		 //clean the location
		_floorType = floorNavProxy.getFloorType(location);
		if(_floorType.equals(FloorType.BAREFLOOR)){
			_floorCleaners.set_floorType(_floorType);
		}
		if(_floorType.equals(FloorType.LOWPILECARPET)){
			_floorCleaners.set_floorType(_floorType);
		}
		if(_floorType.equals(FloorType.HIGHPILECARPET)){
			_floorCleaners.set_floorType(_floorType);
		}
		floorNavProxy.clean(location);
		_dirtRepository.addDirt();
		return true;
	 }
}
