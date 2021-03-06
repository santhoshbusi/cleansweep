package edu.cleansweep.floor;

import java.io.Serializable;
import java.util.Random;
import java.util.Arrays;
import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

class DoorCell extends AbstractCell implements Serializable {

	/**
	 * 
	 */
	private static final Logger logger = LogManager.getLogger(DoorCell.class.getName());
	private static final long serialVersionUID = 3650207702512000586L;
	private boolean _open;
	
	DoorCell(int x, int y){
		super(x,y);
		_open = new Random().nextBoolean();
		logger.debug("Creating " + (_open ? "open" : "closed")  + " door");
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
		logger.info("is Closed? : " + !_open);
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
		if (logger.isDebugEnabled()) {
			logger.debug("hashCode() was called. return - " + result);
			}

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
			return "\u00D0";
	}
}
