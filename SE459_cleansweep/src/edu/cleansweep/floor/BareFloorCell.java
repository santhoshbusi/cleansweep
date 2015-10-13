package edu.cleansweep.floor;

class BareFloorCell implements ICell {

	private ICell [] _adjacentCells;
	private int _dirt;
	private int _grade = 0;
	
	public BareFloorCell(){
		_adjacentCells = new ICell[8];
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
		
		//DEBUG CODE
		//System.out.println(direction.toString());
		//System.out.println(direction.getOpposite().toString());
		
		//if(cell.getAdjacentCell(direction.getOpposite()) != this)
		//	setReciprocalConnection(direction, cell, this);
			
	}
	
	private void setReciprocalConnection(Direction direction, ICell fromCell, ICell toCell){
		
		
		switch(direction){
		
		case NORTH:
			fromCell.setAdjacentCell(Direction.NORTH.getOpposite(), toCell);
			break;
		case NORTHEAST:
			fromCell.setAdjacentCell(Direction.NORTHEAST.getOpposite(), toCell);
			break;
		case EAST:
			fromCell.setAdjacentCell(Direction.EAST.getOpposite(), toCell);
			break;
		case SOUTHEAST:
			fromCell.setAdjacentCell(Direction.SOUTHEAST.getOpposite(), toCell);
			break;
		case SOUTH:
			fromCell.setAdjacentCell(Direction.SOUTH.getOpposite(), toCell);
			break;
		case SOUTHWEST:
			fromCell.setAdjacentCell(Direction.SOUTHWEST.getOpposite(), toCell);
			break;
		case WEST:
			fromCell.setAdjacentCell(Direction.WEST.getOpposite(), toCell);
			break;
		case NORTHWEST:
			fromCell.setAdjacentCell(Direction.NORTHWEST.getOpposite(), toCell);
			break;
		}

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
	public String toString() {
		return "B";
	}

}