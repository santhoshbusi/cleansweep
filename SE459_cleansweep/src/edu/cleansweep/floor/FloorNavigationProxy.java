package edu.cleansweep.floor;

/**
 * FloorNavigationProxy is used to maniuplate a Floor object
 * it is also response for creating instances of Location.xw
 * @author ajscilingo
 *
 */
public class FloorNavigationProxy {

	private Floor _floor;
	private Direction _headingDirection;
	private AbstractCell _startingCell;
	
	public FloorNavigationProxy(String floorPlanFilename){
		_floor = new Floor();
		_floor.createFloorPlanFromFile(floorPlanFilename);
		
		_startingCell = _floor.getStartingCell();
		_headingDirection = Direction.NORTH;
	}
	
	/**
	 * Indicates whether adjacent location relative to current location and direction is obstructed or clear
	 * @param location the current location
	 * @param direction the direction of the adjacent location relative to current location
	 * @return
	 */
	public boolean canMove(Location location, Direction direction){
		AbstractCell peakCell = _floor.getCellAt(location.getLongitude(), location.getLatitude()).getAdjacentCell(direction);
		
		if(peakCell.isObstructed() && peakCell.getFloorType() == FloorType.OBSTACLE)
			return false;
		else
			return true;
	}
	
	/**
	 * Returns a new Location relative to current location and direction 
	 * @param location is the current location object
	 * @param direction relative to current location that leads to new location
	 * @return
	 */
	public Location move(Location location, Direction direction){
		
		AbstractCell newCell = _floor.getCellAt(location.getLongitude(), location.getLatitude()).getAdjacentCell(direction);
		_headingDirection = direction;
		
		return new Location(newCell, _headingDirection);
			
	}
	
	/**
	 * Removes dirt from location
	 * @param location the current location or Location objection in which you would like to clean
	 */
	public void clean(Location location){
		AbstractCell cell = _floor.getCellAt(location.getLongitude(), location.getLatitude());
		int x = cell.getDirt();
		if(x == 0)
			System.out.println("Clean");
		else
			System.out.println("Removing Dirt");
	}
	
	/**
	 * -- DEPRECATED METHOD MOVING TO LOCATION CLASS
	 * Returns the type of floor at location
	 * @param location is the current location or Location object in which you would like to query
	 * @return
	 */
	public FloorType getFloorType(Location location){
		AbstractCell cell = _floor.getCellAt(location.getLongitude(), location.getLatitude());
			return cell.getFloorType();	
	}
	
	/**
	 * Displays output of the location on floor to console, location denoted by *
	 * @param location the Location object representing a particular location on floor
	 */
	public void displayLocationOnFloorInConsole(Location location){
		 System.out.println(_floor.markCellAt(location.getLongitude(), location.getLatitude()));
	}
	
	/**
	 * Call the first time you setup a floor, this is used to get "entrance" location on the floor
	 * @return the starting location on the floor.
	 */
	public Location getStaringLocation(){;
		return new Location(_startingCell,_headingDirection);
	}
 
	
}
