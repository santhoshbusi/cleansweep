package edu.cleansweep.floor;

/**
 * FloorNavigationProxy is used to maniuplate a Floor object
 * it is also response for creating instances of Location.xw
 * @author ajscilingo
 */

public class FloorNavigationProxy {

	private Floor _floor;
	private Direction _headingDirection;
	private ICell _startingCell;
	
	public FloorNavigationProxy(Floor floor){
		_floor = floor;
		_startingCell = _floor.getStartingCell();
		_headingDirection = Direction.NORTH;
	}
	
	
	public boolean canMove(Location location, Direction direction){
		ICell peakCell = _floor.getCellAt(location.getLongitude(), location.getLatitude()).getAdjacentCell(direction);
		
		if(peakCell.isObstructed())
			return false;
		else
			return true;
	}
	
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
	 * @param location is the lo
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
	 * Call the first time you setup a floor, this is used to get "entrance" location on the floor
	 * @return the starting location on the floor.
	 */
	public Location getStaringLocation(){;
		return new Location(_startingCell,_headingDirection);
	}
 
	
}
