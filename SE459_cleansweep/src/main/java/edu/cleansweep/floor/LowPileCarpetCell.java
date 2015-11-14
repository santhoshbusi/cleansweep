package edu.cleansweep.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

class LowPileCarpetCell extends BareFloorCell {

	/**
	 * 
	 */
	private static final Logger logger = LogManager.getLogger(LowPileCarpetCell.class.getName());
	private static final long serialVersionUID = 825513656970874362L;

	LowPileCarpetCell(int x, int y) {
		super(x, y);
	}

	@Override
	FloorType getFloorType(){
		if (logger.isDebugEnabled()) {
			logger.debug("getFloorType() was called. return - " + FloorType.LOWPILECARPET);
			}

		return FloorType.LOWPILECARPET;
	}
	
	/** 
	 * It Costs 2 Power Units to traverse LowPileCarpetCells
	 */
	@Override
	int getPowerCost() {
		return 2;
	}
	
	@Override
	public String toString() {
		return "L";
	}
}
