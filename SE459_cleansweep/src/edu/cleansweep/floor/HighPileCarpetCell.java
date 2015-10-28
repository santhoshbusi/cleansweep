package edu.cleansweep.floor;

class HighPileCarpetCell extends BareFloorCell {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4992058796878504667L;


	public HighPileCarpetCell(int x, int y) {
		super(x, y);
	}

	@Override
	public FloorType getFloorType(){
		return FloorType.HIGHPILECARPET;
	}
	
	
	@Override
	public String toString() {
		return "H";
	}
	
}
