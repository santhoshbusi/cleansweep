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
	private ICell _currentCell;
	
	Location(ICell cell, Direction heading){
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
	
	/**
	 * Get general information about location as a string
	 * @return String with general information about location
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(_currentCell.getType()).append("\n");
		sb.append("Longitude (X): ").append(_longitude).append("\n");
		sb.append("Latitude (Y): ").append(_latitude).append("\n");
		sb.append("Heading Direction: ").append(_heading.toString()).append("\n");
		sb.append("Dirty? ").append(!_currentCell.isClean()).append("\n");
		sb.append("Obstructed? ").append(_currentCell.isObstructed()).append("\n");
		return sb.toString();
	}
}
