package edu.cleansweep.controlsystem;

import java.util.ArrayList;
import edu.cleansweep.floor.Direction;
import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.Location;

public class Decision {
	
	private ArrayList<Direction> directions;
	
	private Location currentLocation;
	private FloorNavigationProxy floorNavProxy;
	private DiscoveryMap discoveryMap;
	private NavigationCell navCell;

	public Decision(Location _currentLocation, FloorNavigationProxy _floorNavProx,
			DiscoveryMap _map, NavigationCell _currentNavCell){
		
		directions =  new ArrayList<Direction>();
		directions.add(Direction.NORTH);
		directions.add(Direction.SOUTH);
		directions.add(Direction.EAST);
		directions.add(Direction.WEST);
		
		currentLocation = _currentLocation;
		
		floorNavProxy = _floorNavProx;
		discoveryMap = _map;
		navCell = _currentNavCell;
		
	}
	
	public void checkNorth(){
		if(!floorNavProxy.canMove(currentLocation, Direction.NORTH)){
			directions.remove(Direction.NORTH);
		}
	}
	
	public void checkSouth(){
		if(!floorNavProxy.canMove(currentLocation, Direction.SOUTH)){
			directions.remove(Direction.SOUTH);
		}
	}
	
	public void checkEast(){
		if(!floorNavProxy.canMove(currentLocation, Direction.EAST)){
			directions.remove(Direction.EAST);
		}
	}
	
	public void checkWest(){
		if(!floorNavProxy.canMove(currentLocation, Direction.WEST)){
			directions.remove(Direction.WEST);
		}
	}
	
	public Direction run(){

		checkNorth();
		checkSouth();
		checkEast();
		checkWest();
		
		for(Enum e : directions){
			if(e.equals(Direction.NORTH)){
				if(!discoveryMap.checkMap(navCell.getX()+1, navCell.getY())){
					return Direction.NORTH;
				}
			}
			if(e.equals(Direction.SOUTH)){
				if(!discoveryMap.checkMap(navCell.getX()-1, navCell.getY())){
					return Direction.SOUTH;
				}
			}
			if(e.equals(Direction.EAST)){
				if(!discoveryMap.checkMap(navCell.getX(), navCell.getY()-1)){
					return Direction.EAST;
				}
			}
			if(e.equals(Direction.EAST)){
				if(!discoveryMap.checkMap(navCell.getX(), navCell.getY()+1)){
					return Direction.EAST;
				}
			}
		}
		return directions.get(0);
	}
}
