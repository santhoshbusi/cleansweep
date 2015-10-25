package edu.cleansweep.floor;

import java.io.Serializable;
import java.util.Arrays;

class BareFloorCell implements ICell, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7566728965045014529L;
	private ICell [] _adjacentCells;
	private int _dirt;
	private int _grade = 0;
	private int _x;
	private int _y;
	
	public BareFloorCell(int x, int y){
		_adjacentCells = new ICell[8];
		_x = x;
		_y = y;
		_dirt = (int)(Math.random() * (10 - 0) + 1);
	}
	
	/**
	 * Returns adjacent ICell in the position defined by direction
	 * @param direction the Direction relative to this cell
	 * @return Adjacent ICell Object in the direction relative to this ICell
	 */
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
	
	/**
	 * Removes dirt from Cell
	 * subtracts the amount of dirt removed from total then return the amount removed
	 * @return amount of dirt removed, 1 signifies 1 unit of dirt extracted, 0 signifies no dirt extracted
	 */
	@Override
	public int getDirt() {
		if(!this.isClean()){
			_dirt -= 1;
			return 1;
		}
		else
			return 0;
	}

	/**
	 * Returns percent incline or decline of cell relative to a flat surface 0
	 * @return 0 if cell is flat, a positive percentage relative to 0 if inclined 
	 * and negative percentage relative to 0 if declined
	 */
	@Override
	public int getCellGrade() {
		return _grade;
	}

	/**
	 * Returns an identifier for this object
	 * @return returns a String identifier for this object
	 */
	@Override
	public String getType() {
		return "Bare Floor";
	}

	/**
	 * Indicates if Cell is clean or dirty
	 * @return true if clean, false if dirty
	 */
	@Override
	public boolean isClean() {
		return _dirt == 0;
	}

	/**
	 * Indicates if Cell is non-traversable 
	 * @return false if Cell can be traversed, true if cannot.
	 */
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
