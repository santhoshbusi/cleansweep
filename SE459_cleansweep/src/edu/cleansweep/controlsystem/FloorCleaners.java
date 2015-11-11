package edu.cleansweep.controlsystem;

import edu.cleansweep.floor.FloorType;
import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class FloorCleaners 
{
	private static final Logger logger = LogManager.getLogger(FloorCleaners.class.getName());
	private FloorType _floorType = FloorType.BAREFLOOR;

	public FloorType get_floorType() {
		if (logger.isDebugEnabled()) {
			logger.debug("get_floorType() was called: return floorType-" + _floorType);
			}
		return _floorType;
	}

	public void set_floorType(FloorType _floorType) {
		this._floorType = _floorType;
	}
}
