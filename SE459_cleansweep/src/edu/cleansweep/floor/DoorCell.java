package edu.cleansweep.floor;

import java.io.Serializable;
import java.util.Arrays;

class DoorCell implements ICell, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3650207702512000586L;
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
	public int getX() {
		return _x;
	}

	@Override
	public int getY() {
		return _y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(_adjacentCells);
		result = prime * result + (_open ? 1231 : 1237);
		result = prime * result + _x;
		result = prime * result + _y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoorCell other = (DoorCell) obj;
		if (!Arrays.equals(_adjacentCells, other._adjacentCells))
			return false;
		if (_open != other._open)
			return false;
		if (_x != other._x)
			return false;
		if (_y != other._y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "D";
	}
}
