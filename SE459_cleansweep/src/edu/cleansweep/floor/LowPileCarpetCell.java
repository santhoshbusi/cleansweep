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
	
	@Override
	public String toString() {
		return "L";
	}
}
