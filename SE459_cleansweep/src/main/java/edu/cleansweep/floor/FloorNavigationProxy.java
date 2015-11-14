package edu.cleansweep.floor;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

/**
 * FloorNavigationProxy is used to manipulate a Floor object
 * it is responsible for creating instances of Location, 
 * and instantiating a floor object
 * @author ajscilingo
 *
 */
public class FloorNavigationProxy {

	private static final Logger logger = LogManager.getLogger(FloorNavigationProxy.class.getName());
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
		if(peakCell == null){
			logger.debug("Can't move " + direction + " off floorplan");
			return false;
		}
			
		
		// If peakCell is a door cell it needs to get the cell immediately after it instead
		if(peakCell.getClass() == DoorCell.class){
			DoorCell d = (DoorCell) peakCell;

			// If Door is closed we need to return false else we need to get the cell directly after it
			if(d.isObstructed()){
				return false;
			}
				
			else{
				// Temporarily get location of Door Cell
				Location tempLocation = new Location(peakCell, direction);
				// get the cell directly after it in the same direction
				peakCell = _floor.getCellAt(tempLocation.getLongitude(), tempLocation.getLatitude()).getAdjacentCell(direction);
				if(peakCell == null){
					logger.debug("Can't move " + direction + " off floorplan");
					return false;
				}
			}
		}
		
		if(peakCell.isObstructed() && peakCell.getFloorType() == FloorType.OBSTACLE){
			logger.debug("Can't move " + direction + " into an obstacle");
			return false;
		}
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
		
		logger.debug("Moving " +  direction + " from (" + location.getLongitude() + "," + location.getLatitude() + ")");
		AbstractCell newCell = _floor.getCellAt(location.getLongitude(), location.getLatitude()).getAdjacentCell(direction);
		_headingDirection = direction;
		
		// Special Case, this assumes door is open and not closed 
		if(newCell.getClass() == DoorCell.class){
			// Temporarily get location of Door Cell 
			Location tempLocation = new Location(newCell, _headingDirection);
			// get the cell directly after it in the same direction 
			newCell = _floor.getCellAt(tempLocation.getLongitude(), tempLocation.getLatitude()).getAdjacentCell(direction);
		}
		
		// If cell is still on the floorplan return it, else return null
		if(newCell != null)
			return new Location(newCell, _headingDirection);
		else
			return null;
			
	}
	
	/**
	 * Removes dirt from location
	 * @param location the current location or Location objection in which you would like to clean
	 */
	public void clean(Location location){
		AbstractCell cell = _floor.getCellAt(location.getLongitude(), location.getLatitude());
		cell.getDirt();
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
		 System.out.println(_floor.markCellAt(location.getLongitude(), location.getLatitude(), false));
	}
	
	/** 
	 * Displays output of the location on the floor to console, with dirt counts
	 * @param location the location object representing a particular location on floor
	 * @param showDirtAmount boolean for whether to show cells dirt amount or type
	 */
	public void displayLocationOnFloorInConsole(Location location, boolean showDirtAmount){
		 System.out.println(_floor.markCellAt(location.getLongitude(), location.getLatitude(), showDirtAmount));
	}
	
	/**
	 * Call the first time you setup a floor, this is used to get "entrance" location on the floor
	 * @return the starting location on the floor.
	 */
	public Location getStaringLocation(){;
		return new Location(_startingCell,_headingDirection);
	}
 
	/**
	 * This method will not exist in final version, but being used for the time being
	 */
	public Location getChargingStation(int x){
		return new Location(_floor.getChargingStation(x),Direction.NORTH);
	}
	
}
