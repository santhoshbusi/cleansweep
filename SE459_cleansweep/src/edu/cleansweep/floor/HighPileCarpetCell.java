package edu.cleansweep.floor;

class HighPileCarpetCell extends BareFloorCell {

	public HighPileCarpetCell(int x, int y) {
		super(x, y);
	}

	@Override
	public String getType(){
		return "High Pile Carpet";
	}
	
	
	@Override
	public String toString() {
		return "H";
	}
	
}
