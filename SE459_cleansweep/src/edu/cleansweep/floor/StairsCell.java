package edu.cleansweep.floor;

class StairsCell implements ICell {
	
	private ICell [] _adjacentCells;
	
	public StairsCell(){
		_adjacentCells = new ICell[8];
	}
	
	@Override
	public ICell getAdjacentCell(Direction direction) {
		return _adjacentCells[direction.ordinal()];
	}

	@Override
	public void setAdjacentCell(Direction direction, ICell cell) {
		if(_adjacentCells[direction.ordinal()] == null)
			_adjacentCells[direction.ordinal()] = cell;
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
