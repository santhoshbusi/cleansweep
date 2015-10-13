package edu.cleansweep.floor;

class DoorCell implements ICell {

	private boolean _open;
	
	public DoorCell(){
		_open = true;
	}
	
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
		return _open;
	}
	
	
	@Override
	public String toString() {
		return "D";
	}

}
