package edu.cleansweep.floor;


interface ICell {
	
	/**
	 * Implement to return adjacent ICell in the position defined by direction
	 * @param direction the Direction relative to this cell
	 * @return Adjacent ICell Object in the direction relative to this ICell
	 */
	public ICell getAdjacentCell(Direction direction);
	
	/**
	 * Implement to assign adjacent ICell in the position defined by direction
	 * @param direction the Direction relative to this cell
	 * @param cell The Adjacent Cell Object
	 */
	public void setAdjacentCell(Direction direction, ICell cell);
	
	
	/**
	 * Implement to remove dirt from ICell type 
	 * subtract the amount of dirt removed from total then return the amount removed
	 * @return amount of dirt units removed, should either be 1 if dirt was removed or 0 if no dirt was removed
	 */
	public int getDirt();
	
	/**
	 * Implement to return percent incline or decline of cell relative to a flat surface 0
	 * @return 0 if cell is flat, a positive percentage relative to 0 if inclined 
	 * and negative percentage relative to 0 if declined
	 */
	public int getCellGrade();
	
	
	/**
	 * Implement to returns an identifier that your class that implements ICell represents
	 * @return Name of structure that your class represents
	 */
	public String getType();
	
	/**
	 * Implement to return x-coordinate of cell
	 * @return
	 */
	public int getX();
	
	/**
	 * Implement to return y-coordinate of cell
	 * @return
	 */
	public int getY();
	
	
	/**
	 * Implement to indicate dirt status of your ICell Type
	 * @return true if clean, false if dirty
	 */
	public boolean isClean();
	
	/**
	 * Implement to indicate that your ICell Type is non-traversable 
	 * @return true if ICell cannot be traversed, false if can be
	 */
	public boolean isObstructed();
	
	/**
	 * Implement for hashing
	 * @return
	 */
	@Override
	int hashCode();
	
	/**
	 * Implement for equality test
	 * @param obj
	 * @return
	 */
	@Override
	boolean equals(Object obj);
}
