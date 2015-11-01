package edu.cleansweep.controlsystem;

import java.util.ArrayList;
import edu.cleansweep.floor.Direction;
import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.Location;

public class Decision {
	
	private ArrayList<Direction> directions;
	
	private Location currentLocation;
	private FloorNavigationProxy floorNavProxy;

	public Decision(Location _currentLocation, FloorNavigationProxy _floorNavProx){
		
		directions =  new ArrayList<Direction>();
		directions.add(Direction.NORTH);
		directions.add(Direction.SOUTH);
		directions.add(Direction.EAST);
		directions.add(Direction.WEST);
		
		currentLocation = _currentLocation;
		
		floorNavProxy = _floorNavProx;
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
	
	public ArrayList<Direction> checkNewAvailable(Direction _d)
	{
		if(_d.equals(Direction.NORTH)){
			directions.remove(Direction.SOUTH);
		} else if(_d.equals(Direction.SOUTH)){
			directions.remove(Direction.NORTH);
		} else if(_d.equals(Direction.EAST)){
			directions.remove(Direction.WEST);
		} else if(_d.equals(Direction.WEST)){
			directions.remove(Direction.EAST);
		}
		checkNorth();
		checkSouth();
		checkEast();
		checkWest();
		
		return directions;
	}
	
	public ArrayList<Direction> checkAvailable(){

		checkNorth();
		checkSouth();
		checkEast();
		checkWest();
		
		/*
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
		*/
		return directions;
	}
}
