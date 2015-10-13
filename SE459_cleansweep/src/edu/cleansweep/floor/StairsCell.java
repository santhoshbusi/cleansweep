package edu.cleansweep.floor;

class StairsCell implements ICell {
	
	@Override
	public ICell getAdjacentCell(Direction direction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAdjacentCell(Direction direction, ICell cell) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getDirt() {
		return 0;
	}

	@Override
	public int getCellGrade() {
		return -100;
	}

	@Override
	public String getType() {
		return "Stairs";
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
		return "S";
	}

}
