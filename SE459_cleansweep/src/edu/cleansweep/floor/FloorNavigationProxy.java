package edu.cleansweep.floor;

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
	
	
	public Location move(Location location, Direction direction){
		
		ICell newCell = _floor.getCellAt(location.getLongitude(), location.getLatitude()).getAdjacentCell(direction);
		ICell sameCell = _floor.getCellAt(location.getLongitude(), location.getLatitude());
		
		if(canMove(location,direction)){
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
		}
			
	}
	
	public FloorType getFloorType(Location location){
		ICell cell = _floor.getCellAt(location.getLongitude(), location.getLatitude());
		
		if(cell.getClass() == BareFloorCell.class){
			return FloorType.BAREFLOOR;
		}
		else if(cell.getClass() == ChargingStationCell.class){
			return FloorType.CHARGINGSTATION;
		}
		else if(cell.getClass() == DoorCell.class){
			return FloorType.DOOR;
		}
		else if(cell.getClass() == HighPileCarpetCell.class){
			return FloorType.HIGHPILECARPET;
		}
		else if(cell.getClass() == LowPileCarpetCell.class){
			return FloorType.LOWPILECARPET;
		}
		else{
			return FloorType.UNKNOWN;
		}
		
	}
	
	public Location getStaringLocation(){;
		return new Location(_startingCell,_headingDirection);
	}
 
	
}
