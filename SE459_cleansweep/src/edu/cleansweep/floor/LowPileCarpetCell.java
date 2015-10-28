package edu.cleansweep.floor;

class LowPileCarpetCell extends BareFloorCell {

	/**
	 * 
	 */
	private static final long serialVersionUID = 825513656970874362L;

	public LowPileCarpetCell(int x, int y) {
		super(x, y);
	}

	@Override
	public FloorType getFloorType(){
		return FloorType.LOWPILECARPET;
	}
	
	@Override
	public String toString() {
		return "L";
	}
}
