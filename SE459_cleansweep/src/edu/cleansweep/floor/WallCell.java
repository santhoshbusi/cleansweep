package edu.cleansweep.floor;

class WallCell implements ICell {
	
	private ICell [] _adjacentCells;
	
	public WallCell(){
		_adjacentCells = new ICell[8];
	}
	
	@Override
	public ICell getAdjacentCell(Direction direction) {
		return _adjacentCells[direction.ordinal()];
	}

	@Override
	public void setAdjacentCell(Direction direction, ICell cell) {
		//Set AdjacentCell for this to cell if there is nothing there
		if(_adjacentCells[direction.ordinal()] == null)
			_adjacentCells[direction.ordinal()] = cell;
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
