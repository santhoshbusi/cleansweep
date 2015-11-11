package edu.cleansweep.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

class StairsCell extends ObstacleCell {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4611270758216130688L;
	private static final Logger logger = LogManager.getLogger(StairsCell.class.getName());

	StairsCell(int x, int y) {
		super(x, y);
		_grade = -100;
	}
	
	@Override
	public String toString() {
		if (logger.isDebugEnabled()) {
			logger.debug("toString() was called. return S");
			}
		return "S";
	}
}
