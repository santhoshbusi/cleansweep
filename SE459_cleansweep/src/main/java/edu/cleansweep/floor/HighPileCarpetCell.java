package edu.cleansweep.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

class HighPileCarpetCell extends BareFloorCell {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4992058796878504667L;
	private static final Logger logger = LogManager.getLogger(HighPileCarpetCell.class.getName());


	HighPileCarpetCell(int x, int y) {
		super(x, y);
	}

	/**
	 * It Costs 3 Power Units to traverse LowPileCarpetCells
	 */
	@Override
	int getPowerCost() {
		return 3;
	}
	
	@Override
	FloorType getFloorType(){
		if (logger.isDebugEnabled()) {
			logger.debug("getFloorType() was called. return - " + FloorType.HIGHPILECARPET);
			}
		return FloorType.HIGHPILECARPET;
	}
	
	
	@Override
	public String toString() {
		return "H";
	}
	
}
