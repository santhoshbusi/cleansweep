package edu.cleansweep.floor;

class WallCell implements ICell {

	@Override
	public ICell getAdjacentCell(Direction direction) {
		return null;
	}

	@Override
	public void setAdjacentCell(Direction direction, ICell cell) {

	}

	@Override
	public int getDirt() {
		return 0;
	}

	@Override
	public int getCellGrade() {
		return 100;
	}

	@Override
	public String getType() {
		return "Wall";
	}

	@Override
	public boolean isClean() {
		return true;
	}

	@Override
	public boolean isObstructed() {
		return true;
	}
	
	@Override
	public String toString() {
		return "W";
	}
}
