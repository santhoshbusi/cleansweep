package edu.cleansweep.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

class WallCell extends ObstacleCell {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4972611435295777664L;
	private static final Logger logger = LogManager.getLogger(WallCell.class.getName());

	WallCell(int x, int y){
		super(x,y);
		_grade = 100;
	}
	
	@Override
	public String toString() {
		if (logger.isDebugEnabled()) {
			logger.debug("toString() was called. return W");
			}

		return "W";
	}
}
