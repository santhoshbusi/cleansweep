package edu.cleansweep.floor;

import java.io.Serializable;
import java.util.Arrays;

class BareFloorCell extends AbstractCell implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7566728965045014529L;
	
	BareFloorCell(int x, int y){
		super(x,y);
		_dirt = (int)(Math.random() * (5 - 0) + 1);
	}

	/**
	 * Returns percent incline or decline of cell relative to a flat surface 0
	 * @return 0 if cell is flat, a positive percentage relative to 0 if inclined 
	 * and negative percentage relative to 0 if declined
	 */
	@Override
	int getElevationGrade() {
		return _grade;
	}

	/**
	 * Returns an identifier for this object
	 * @return returns a String identifier for this object
	 */
	@Override
	FloorType getFloorType() {
		return FloorType.BAREFLOOR;
	}

	/**
	 * It costs 1 power unit (integer) to traverse BareFloorCells
	 */
	@Override
	int getPowerCost() {
		return 1;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(_adjacentCells);
		result = prime * result + _dirt;
		result = prime * result + _grade;
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
		BareFloorCell other = (BareFloorCell) obj;
		if (!Arrays.equals(_adjacentCells, other._adjacentCells))
			return false;
		if (_dirt != other._dirt)
			return false;
		if (_grade != other._grade)
			return false;
		if (_x != other._x)
			return false;
		if (_y != other._y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "B";
	}
	
}
