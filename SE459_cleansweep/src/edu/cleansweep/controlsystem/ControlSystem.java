package edu.cleansweep.controlsystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import edu.cleansweep.floor.*;

/**
 * Control System is responsible for controlling navigation,
 * cleaning, repository tracking, & power management
 * @author pmathieu
 */
public class ControlSystem {

	private int currentX;
	private int currentY;
	private DiscoveryMap discoveryMap;
	
	private Location currentLocation;
	private FloorNavigationProxy floorNavProxy;
	private Vacuum vacuum;

	public ControlSystem(String floorFile){
		currentX = 0;
		currentY = 0;
		
		discoveryMap = new DiscoveryMap();
		floorNavProxy = new FloorNavigationProxy(floorFile);
		currentLocation = floorNavProxy.getStaringLocation();
		vacuum = new Vacuum(floorNavProxy);
	}

	/**
	 * Used to move to a particular navigation cell
	 * @param _navCell the destination Navigation Cell
	 * @return current location after move
	 */
	public Location moveToCell(NavigationCell _navCell){
		for(Direction _dir: _navCell.getStepsToNavCell()){
			currentLocation = executeMove(currentLocation, _dir);
		}
		return currentLocation;
	}
	
	public Location moveToChargeStation(NavigationCell _navCell){
		for(Direction _dir: _navCell.getStepsToChargeStation()){
			currentLocation = executeMove(currentLocation, _dir);
		}
		return currentLocation;
	}
	
	/**
	 * Executes a change in current location (a move)
	 * @param _currentLocation of the control system
	 * @param _direction intended direction of travel
	 * @return current location after move
	 */
	private Location executeMove(Location _currentLocation, Direction _direction)
	{
		Location newLocation = floorNavProxy.move(_currentLocation, _direction);
		
		if(_direction.equals(Direction.NORTH)){
			this.currentX++;
		} else if(_direction.equals(Direction.SOUTH)){
			this.currentX--;
		} else if(_direction.equals(Direction.EAST)){
			this.currentY--;
		} else if(_direction.equals(Direction.WEST)){
			this.currentY++;
		}
		
		//If we have Navigation Data on this location
		if(discoveryMap.checkMap(currentX, currentY)){
			checkClean(discoveryMap.get(currentX, currentY), newLocation);
		}
		
		return newLocation;
	}
	
	private void checkClean(NavigationCell _navCell, Location _currentLocation){
		if(!_currentLocation.isClean()){
			vacuum.doClean(_currentLocation);
			_navCell.setCleanedLastVisit(true);
		}
		else {
			_navCell.setCleanedLastVisit(false);
		}
	}
	
	/**
	 * Discovers the floor plan by building an internal map of available cells.
	 * The Power Station starts off with coordinates [0,0] - all cells adjacent
	 * to it are labeled "1".  All Cells adjacent to those cells are labeled 
	 * "2", and so on:
	 * @param discoveryLayer The layer of discovery the control system should roam to.
	 * @return void
	 */
	
	/*
	 * |3|
	 * |2|3|
	 * |1|2|3|
	 * |C|1|2|3|
	 */
	public void discoverFloor(int _discoveryLayer)
	{
		//Store Starting Location Information
		NavigationCell homeCell = discoveryMap.addNewNavigationCell(0, 0, 0, currentLocation);
		homeCell.calculateAdjacentDirections(currentLocation, floorNavProxy);
		
		//See initial dirt map
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation, true);
		
		//Begin Discovery
		for(int i = 0; i< _discoveryLayer; i++){
			
			//What's our current Top Layer
			int currentMaxNavLayer = discoveryMap.getMaxNavLayer() + 1;
			for(NavigationCell navCell: discoveryMap.getTopLayerCells()){
				
				currentLocation = moveToCell(navCell);
				for(Direction _d: navCell.getAdjacentList()){
					
					currentLocation = executeMove(currentLocation, _d);
					//If we haven't been here - Create navigation Cell, 
					//update required steps, add top map.
					if(!discoveryMap.checkMap(currentX, currentY)){
						
						NavigationCell newNavCell = discoveryMap.addNewNavigationCell(currentX, 
													currentY, currentMaxNavLayer, currentLocation);
						
						//Build our lists of directions.
						newNavCell.buildDirectionsToChargingStation(navCell, _d);
						newNavCell.buildDirectionsToCell(navCell, _d);
						newNavCell.calculateAdjacentDirections(currentLocation, floorNavProxy);
					}
					
					//Check if the newly 
					checkClean(discoveryMap.get(currentX, currentY), currentLocation);
					
					//Go Back To original layer
					currentLocation = executeMove(currentLocation, _d.getOpposite());
				}
				//Go Back to Charging Station
				for(Direction dir: navCell.getStepsToChargeStation()){
					currentLocation = executeMove(currentLocation, dir);
				}
			}
		}
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation, true);
	}
	
	/**
	 * This Method runs after the floor plan has been discovered and brings 
	 * the robot back to every location that required cleaning on the last visit
	 * this method will run until the entire floor is clean.  It's relatively
	 * in-efficient as the robot has to return to the control station before it can
	 * navigate to the next dirty location.
	 * @return void
	 */
	
	public void goToDirt()
	{
		for(NavigationCell _navCell: discoveryMap.getNavigationCells()){
			if(_navCell.isCleanedLastVisit()){
				moveToCell(_navCell);
				moveToChargeStation(_navCell);
			}
		}
	}

        public Stack<Direction> shortest_route_to_charger(Location charger_location){
           if(charger_location == null){
              //If the charger supplied is null, use starting location as a default
              charger_location = floorNavProxy.getStaringLocation();
           }
           //I use a hashmap since the DiscoverMap cells won't always be in linear order making checking of ArrayList and Vector values expensive
           HashMap<Integer, HashMap<Integer, Integer>> dist    = new HashMap<Integer, HashMap<Integer, Integer>>();
           HashMap<NavigationCell, Direction> prev    = new HashMap<NavigationCell, Direction>();

           ArrayList<NavigationCell> map = discoveryMap.getNavigationCells();
           //Initialize hashmap
           for(NavigationCell nav: map){
              HashMap<Integer, Integer> curDistMap = dist.get(nav.getX());
              if(curDistMap == null){
                 curDistMap = new HashMap<Integer, Integer>();
              }
              curDistMap.put(nav.getY(), Integer.MAX_VALUE);
              dist.put(nav.getX(), curDistMap);
           }
           dist.get(currentX).put(currentY, 0);
           while(!map.isEmpty()){
              int x = Integer.MAX_VALUE;
              NavigationCell curCell = null;
              //Get unvisited cell with the shortest tentative distance
              for(NavigationCell nav: map){
                 int cur_x = dist.get(nav.getX()).get(nav.getY());
                 if( cur_x < x){
                    x = cur_x;
                    curCell = nav;
                 }
              }
              int cur_x = curCell.getX();
              int cur_y = curCell.getY();
              if(cur_x == charger_location.getLongitude() && cur_y == charger_location.getLatitude()){
                 break;
              }

              //Cell has been visited, remove it from the list
              map.remove(curCell);

              ArrayList<Direction> neighbors = curCell.getAdjacentList();
              //Check neighboring cells
              for(Direction d:neighbors){
                 //Initialize neighbor coordinates to the current cells
                 int n_x = cur_x;
                 int n_y = cur_y;
                 if(d == Direction.EAST){
                    n_x -= 1;
                 }else if(d == Direction.WEST){
                    n_x += 1;
                 }else if(d == Direction.SOUTH){
                    n_y -= 1;
                 }else{
                    n_y += 1;
                 }
                 int alt = x + 1;
                 if(alt < dist.get(n_x).get(n_y)){
                    dist.get(n_x).put(n_y, alt);
                    NavigationCell neighbor = discoveryMap.get(n_x, n_y);
                    prev.put(neighbor, d);
                 }
              }
           }
           NavigationCell curCell = null;
           Stack<Direction> path = new Stack<Direction>();
           while(prev.get(curCell) != null){ 
              Direction d = prev.get(curCell);
              path.add(d); 
           }
           return path;
        }
	
	public static void main(String [] args)
	{
		ControlSystem cs = new ControlSystem("TEST_B.cft");
		//cs.floorNavProxy.displayLocationOnFloorInConsole(cs.currentLocation, true);
		cs.discoverFloor(20);
		cs.floorNavProxy.displayLocationOnFloorInConsole(cs.currentLocation, true);
		while(cs.discoveryMap.dirtyCellsRemain()){
			cs.goToDirt();
			
			System.out.println("Number of Potentially Dirty Cells: " + 
					cs.discoveryMap.countDirtyCells());
		}
		cs.discoveryMap.printMap();
		cs.floorNavProxy.displayLocationOnFloorInConsole(cs.currentLocation, true);
	}
}
