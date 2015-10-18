package edu.cleansweep.floor;

class LowPileCarpetCell extends BareFloorCell {

	public LowPileCarpetCell(int x, int y) {
		super(x, y);
	}

	@Override
	public String getType(){
		return "Low Pile Carpet";
	}
	
	@Override
	public String toString() {
		return "L";
	}
}
