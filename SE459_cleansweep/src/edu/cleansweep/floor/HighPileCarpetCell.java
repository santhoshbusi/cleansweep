package edu.cleansweep.floor;

class HighPileCarpetCell extends BareFloorCell {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4992058796878504667L;


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
		return FloorType.HIGHPILECARPET;
	}
	
	
	@Override
	public String toString() {
		return "H";
	}
	
}
