package edu.cleansweep.floor;

import java.io.Serializable;
import java.util.Arrays;

class ObstacleCell extends AbstractCell implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6521485866250467349L;

	
	public ObstacleCell(int x, int y){
		super(x,y);
		_grade = (int)(Math.random() * (100 - 0) + 1);
	}
	

	@Override
	public FloorType getFloorType() {
		return FloorType.OBSTACLE;
	}

	@Override
	public boolean isObstructed() {
		return true;
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
		ObstacleCell other = (ObstacleCell) obj;
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
		return "O";
	}

}
