package edu.cleansweep.floor;

class LowPileCarpetCell extends BareFloorCell {

	/**
	 * 
	 */
	private static final long serialVersionUID = 825513656970874362L;

	LowPileCarpetCell(int x, int y) {
		super(x, y);
	}

	@Override
	FloorType getFloorType(){
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
