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
	private ICell _startingCell;
	
	public FloorNavigationProxy(String _floorPlan){
		_floor = new Floor();
		_floor.createFloorPlanFromFile(_floorPlan);
		
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
		ICell peakCell = _floor.getCellAt(location.getLongitude(), location.getLatitude()).getAdjacentCell(direction);
		
		if(peakCell.isObstructed())
			return false;
		else
			return true;
	}
	
	/**
	 * Removes dirt from location
	 * @param location the current location or Location objection in which you would like to clean
	 */
	public void clean(Location location){
		ICell cell = _floor.getCellAt(location.getLongitude(), location.getLatitude());
		int x = cell.getDirt();
		if(x == 0)
			System.out.println("Clean");
		else
			System.out.println("Removing Dirt");
	}
	
	/**
	 * Returns a new Location relative to current location and direction 
	 * @param location is the current location object
	 * @param direction relative to current location that leads to new location
	 * @return
	 */
	public Location move(Location location, Direction direction){
		
		ICell newCell = _floor.getCellAt(location.getLongitude(), location.getLatitude()).getAdjacentCell(direction);
		_headingDirection = direction;
		
		return new Location(newCell, _headingDirection);
		
		/*
		 * 
		 * Removing checks for moves as this functionality belongs 
		 * to control system 10/24
		 * 
		 */
		
		/*ICell sameCell = _floor.getCellAt(location.getLongitude(), location.getLatitude());
		
		if (canMove(location,direction)){
			 _headingDirection = direction;
			 return new Location(newCell, _headingDirection);
		}
		else{
			_headingDirection = direction.getOpposite();
			if(newCell.getClass() == WallCell.class){
				System.out.println("Bump!");	
			}
			if(newCell.getClass() == DoorCell.class){
				if(!newCell.isObstructed())
					return new Location(newCell, direction);
				else
					System.out.println("Bump!");
					
			}
			if(newCell.getClass() == ObstacleCell.class){
				System.out.println("Bump!");
			}
			if(newCell.getClass() == StairsCell.class)
			{
				System.out.println("CRASH!!!");
				System.out.println("You've fallen and can't get up!");
				return null;
			}
			return new Location(sameCell, _headingDirection);
		}*/
			
	}
	
	/**
	 * Returns the type of floor at location
	 * @param location is the current location or Location object in which you would like to query
	 * @return
	 */
	public FloorType getFloorType(Location location){
		ICell cell = _floor.getCellAt(location.getLongitude(), location.getLatitude());
		
		if(cell.getClass() == BareFloorCell.class){
			return FloorType.BAREFLOOR;
		}
		else if(cell.getClass() == ChargingStationCell.class){
			return FloorType.CHARGINGSTATION;
		}
		else if(cell.getClass() == DoorCell.class){
			
			//Check to see if Door is open or close
			if(cell.isObstructed())
				return FloorType.OBSTACLE;
			else
				return FloorType.DOOR;
		}
		else if(cell.getClass() == HighPileCarpetCell.class){
			return FloorType.HIGHPILECARPET;
		}
		else if(cell.getClass() == LowPileCarpetCell.class){
			return FloorType.LOWPILECARPET;
		}
		else{
			return FloorType.OBSTACLE;
		}
		
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
