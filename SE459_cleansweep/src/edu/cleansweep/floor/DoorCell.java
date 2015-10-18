package edu.cleansweep.floor;

class DoorCell implements ICell {

	private boolean _open;
	private ICell [] _adjacentCells;
	private int _x;
	private int _y;
	
	public DoorCell(int x, int y){
		_open = true;
		_adjacentCells = new ICell[8];
		_x = x;
		_y = y;
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
		return 0;
	}

	@Override
	public String getType() {
		return "Door";
	}

	@Override
	public boolean isClean() {
		return true;
	}

	public void open(){
		_open = true;
	}
	
	public void close(){
		_open = false;
	}
	
	@Override
	public boolean isObstructed() {
		return !_open;
	}
	
	
	@Override
	public String toString() {
		return "D";
	}

	@Override
	public int getX() {
		return _x;
	}

	@Override
	public int getY() {
		return _y;
	}

}
