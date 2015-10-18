package edu.cleansweep.floor;
/**
 * Used to represent a location on the floor
 * @author ajscilingo
 *
 */
public class Location {
	
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
	
	public boolean isClean(){
		return _currentCell.isClean();
	}
	
	public boolean isObstructed(){
		return _currentCell.isObstructed();
	}
	
	public int getDirt(){
		return _currentCell.getDirt();
	}
	
	public int getLongitude(){
		return _longitude;
	}

	public int getLatitude(){
		return _latitude;
	}
	
	public Direction getDirectionHeading(){
		return _heading;
	}
	
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
