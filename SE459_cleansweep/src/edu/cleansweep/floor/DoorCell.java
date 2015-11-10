package edu.cleansweep.floor;

import java.io.Serializable;
import java.util.Random;
import java.util.Arrays;

class DoorCell extends AbstractCell implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3650207702512000586L;
	private boolean _open;
	
	DoorCell(int x, int y){
		super(x,y);
		_open = new Random().nextBoolean();
	}
	
	@Override
	FloorType getFloorType() {
		if(_open)
			return FloorType.DOOR;
		else
			return FloorType.OBSTACLE;	
	}

	/**
	 * Door Cells are ignored
	 */
	@Override
	int getPowerCost() {
		return 0;
	}
	
	void open(){
		_open = true;
	}
	
	void close(){
		_open = false;
	}
	
	@Override
	boolean isObstructed() {
		return !_open;
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
		if(_open)
			return "D";
		else
			return "Ð";
	}
}
