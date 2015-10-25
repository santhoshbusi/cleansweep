package edu.cleansweep.floor;

import java.util.Arrays;

public class ObstacleCell implements ICell {

	private ICell [] _adjacentCells;
	private int _x;
	private int _y;
	
	public ObstacleCell(int x, int y){
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
		if(_adjacentCells[direction.ordinal()] == null)
			_adjacentCells[direction.ordinal()] = cell;
	}

	@Override
	public int getDirt() {
		return 0;
	}

	@Override
	public int getCellGrade() {
		return 50;
	}

	@Override
	public String getType() {
		return "Obstacle";
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
