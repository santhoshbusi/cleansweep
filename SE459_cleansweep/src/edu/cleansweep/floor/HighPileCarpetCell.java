package edu.cleansweep.floor;

class HighPileCarpetCell extends BareFloorCell {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4992058796878504667L;


	HighPileCarpetCell(int x, int y) {
		super(x, y);
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
