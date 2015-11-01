package edu.cleansweep.controlsystem;

import edu.cleansweep.floor.FloorType;

public class FloorCleaners 
{
	private FloorType _floorType = FloorType.BAREFLOOR;

	public FloorType get_floorType() {
		return _floorType;
	}

	public void set_floorType(FloorType _floorType) {
		this._floorType = _floorType;
	}
}
