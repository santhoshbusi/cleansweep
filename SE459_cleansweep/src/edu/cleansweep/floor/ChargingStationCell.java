package edu.cleansweep.floor;

import java.io.Serializable;
import java.util.Arrays;

class ChargingStationCell implements ICell, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2398805126052156212L;
	private ICell [] _adjacentCells;
	private int _x;
	private int _y;
	
	public ChargingStationCell(int x, int y){
		_adjacentCells = new ICell[8];
		_x = x;
		_y = y;
	}
	
	@Override
	public ICell getAdjacentCell(Direction direction) {
		return _adjacentCells[direction.ordinal()];	}

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
		return "Charging Station";
	}

	@Override
	public boolean isClean() {
		return true;
	}

	@Override
	public boolean isObstructed() {
		return false;
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
		ChargingStationCell other = (ChargingStationCell) obj;
		if (!Arrays.equals(_adjacentCells, other._adjacentCells))
			return false;
		if (_x != other._x)
			return false;
		if (_y != other._y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "C";
	}
}
