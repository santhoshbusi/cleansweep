package edu.cleansweep.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

class NullCell extends ObstacleCell {

	/**
	 * 
	 */
	private static final Logger logger = LogManager.getLogger(NullCell.class.getName());
	private static final long serialVersionUID = -8539707092328881786L;

	NullCell(int x, int y){
		super(x,y);
		_grade = -1000;
	}

	@Override
	FloorType getFloorType() {
		if (logger.isDebugEnabled()) {
			logger.debug("getFloorType() was called." + FloorType.OBSTACLE);
			}
		return FloorType.OBSTACLE;
	}
	
	@Override
	public String toString() {
		return "-";
	}
	
}
