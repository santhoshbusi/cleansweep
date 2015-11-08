package edu.cleansweep.floor;

import java.io.Serializable;

/**
 * Used to represent a location on the floor
 * Locations can be created through the move and getStartingLocation 
 * methods found in FloorNavigationProxy class.
 * @author ajscilingo
 *
 */
public class Location implements Serializable{
	
	/**
	 * Generated servialVersionUID
	 */
	private static final long serialVersionUID = 8781241666543820240L;
	private Direction _heading;
	private int _latitude;
	private int _longitude;
	private AbstractCell _currentCell;
	
	Location(AbstractCell cell, Direction heading){
		_currentCell = cell;
		_latitude = _currentCell.getY();
		_longitude = _currentCell.getX();
		_heading = heading;
	}
	
	/**
	 * Indicates whether or not there is dirt present at location 
	 * @return true if location is clean, false if location has dirt
	 */
	public boolean isClean(){
		return _currentCell.isClean();
	}
	
	/**
	 * Indicates whether or not location can be traversed 
	 * @return true if location isn't clear, false if location is clear
	 */
	public boolean isObstructed(){
		return _currentCell.isObstructed();
	}
	
	/**
	 * Returns the type of floor at location
	 * @return location is the current location or Location object in which you would like to query
	 */
	public FloorType getFloorType(){
		return _currentCell.getFloorType();
	}
	
	/**
	 * The cost in power units it takes to traverse this location
	 * @return the cost in power units (integers) it takes to traverse this location 
	 */
	public int getPowerCost(){
		return _currentCell.getPowerCost();
	}
	
	
	/**
	 * gets longitude for this location
	 * @return longitude represented by x coordinate
	 */
	public int getLongitude(){
		return _longitude;
	}
	
	/**
	 * gets latitude for this location
	 * @return latitude represented by y coordinate
	 */
	public int getLatitude(){
		return _latitude;
	}
	
	/**
	 * get direction heading
	 * @return current direction heading
	 */
	public Direction getDirectionHeading(){
		return _heading;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_currentCell == null) ? 0 : _currentCell.hashCode());
		result = prime * result + _latitude;
		result = prime * result + _longitude;
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
		Location other = (Location) obj;
		if (_currentCell == null) {
			if (other._currentCell != null)
				return false;
		} else if (!_currentCell.equals(other._currentCell))
			return false;
		if (_latitude != other._latitude)
			return false;
		if (_longitude != other._longitude)
			return false;
		return true;
	}

	/**
	 * Get general information about location as a string
	 * @return String with general information about location
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(_currentCell.getFloorType()).append("\n");
		sb.append("Longitude (X): ").append(_longitude).append("\n");
		sb.append("Latitude (Y): ").append(_latitude).append("\n");
		sb.append("Heading Direction: ").append(_heading.toString()).append("\n");
		sb.append("Dirty? ").append(!_currentCell.isClean()).append("\n");
		sb.append("Obstructed? ").append(_currentCell.isObstructed()).append("\n");
		return sb.toString();
	}
}
