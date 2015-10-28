package edu.cleansweep.floor;

import java.util.Arrays;

abstract class AbstractCell {
	
	protected AbstractCell [] _adjacentCells;
	protected int _dirt;
	protected int _grade;
	protected int _x;
	protected int _y;
	
	AbstractCell(int x, int y){
		_adjacentCells = new AbstractCell[8];
		_x = x;
		_y = y;
		_dirt = 0;
		_grade = 0;
	}
	
	/**
	 * Returns adjacent AbstractCell in the position defined by direction
	 * @param direction the Direction relative to this cell
	 * @return Adjacent AbstractCell Object in the direction relative to this AbstractCell
	 */
	AbstractCell getAdjacentCell(Direction direction){
		return _adjacentCells[direction.ordinal()];
	}
	
	/**
	 * Assigns adjacent AbstractCell in the position defined by direction
	 * @param direction the Direction relative to this cell
	 * @param cell The Adjacent Cell Object
	 */
	void setAdjacentCell(Direction direction, AbstractCell cell){
		//Set AdjacentCell for this to cell if there is nothing there
		if(_adjacentCells[direction.ordinal()] == null)
			_adjacentCells[direction.ordinal()] = cell;
	}
	
	
	/**
	 * Remove dirt from AbstractCell type 
	 * subtract the amount of dirt removed from total then return the amount removed
	 * @return amount of dirt units removed, should either be 1 if dirt was removed or 0 if no dirt was removed
	 */
	int getDirt(){
		if(!this.isClean()){
			_dirt -= 1;
			return 1;
		}
		else
			return 0;
	}
	
	/**
	 * Return percent incline or decline of cell relative to a flat surface 0
	 * @return 0 if cell is flat, a positive percentage relative to 0 if inclined 
	 * and negative percentage relative to 0 if declined
	 */
	int getElevationGrade(){
		return _grade;
	}
	
	
	/**
	 * Implement to return the FloorType that your AbstractCell represents
	 * @return Name of structure that your class represents
	 */
	abstract FloorType getFloorType();
	
	/**
	 * Return x-coordinate of cell
	 * @return
	 */
	int getX(){
		return _x;
	}
	
	/**
	 * Return y-coordinate of cell
	 * @return
	 */
	int getY(){
		return _y;
	}
	
	
	/**
	 * Indicates dirt status of your AbstractCell Type
	 * @return true if clean, false if dirty
	 */
	boolean isClean(){
		return _dirt == 0;
	}
	
	/**
	 * Indicates that your AbstractCell Type is non-traversable 
	 * @return true if AbstractCell cannot be traversed, false if can be
	 */
	boolean isObstructed(){
		return false;
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
		AbstractCell other = (AbstractCell) obj;
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
	
	
}
