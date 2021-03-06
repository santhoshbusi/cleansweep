package edu.cleansweep.controlsystem;
import java.util.ArrayList;
import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

import java.util.HashMap;
import java.util.Stack;

import edu.cleansweep.floor.Direction;
import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.Location;
import edu.cleansweep.controlsystem.power.*;

/**
 * Control System is responsible for controlling navigation,
 * cleaning, repository, & power management
 * @author pmathieu
 */
public class ControlSystem {

	private int currentX;
	private int currentY;
	private DiscoveryMap discoveryMap;
	private static final Logger logger = LogManager.getLogger(ControlSystem.class.getName());

	private Location currentLocation;
	private FloorNavigationProxy floorNavProxy;
	private Vacuum vacuum;
	private PowerManager powerManager;
	private boolean emptyMeLight;

	public ControlSystem(String floorFile){

		currentX = 0;
		currentY = 0;
		
		discoveryMap = new DiscoveryMap();
		floorNavProxy = new FloorNavigationProxy(floorFile);
		currentLocation = floorNavProxy.getStaringLocation();
		vacuum = new Vacuum(floorNavProxy);
		powerManager = new PowerManager();
		emptyMeLight = false;
	}
	
	/**
	 * Used to move to a particular navigation cell
	 * @param _navCell the destination Navigation Cell
	 * @return current location after move
	 */
	private Location moveToCell(NavigationCell _navCell){
		for(Direction _dir: _navCell.getStepsToNavCell()){
			currentLocation = executeMove(currentLocation, _dir);
		}
		return currentLocation;
	}
	/**
	 * Used to move back to the control station from a particular
	 * navigation cell
	 * @param _navCell the destination Navigation Cell
	 * @return current location after move
	 */
	private Location moveToChargeStation(NavigationCell _navCell){
		for(Direction _dir: _navCell.getStepsToChargeStation()){
			currentLocation = executeMove(currentLocation, _dir);
		}
		return currentLocation;
	}
	
	public int getCurrentX(){
		return currentX;
	}
	
	public int getCurrentY(){
		return currentY;
	}
	
	public boolean getEmptyMeLight(){
		return emptyMeLight;
	}
	/**
	 * Counts the number of cells where "cleaned last visit"
	 * is equal to true.
	 * @return number of potentially dirt cells
	 */
	public int countPotentiallyDirtyCells(){
		int cnt = 0;
		for(NavigationCell _navCell: discoveryMap.getNavigationCells()){
			if(_navCell.isCleanedLastVisit()){
				cnt++;
			}
		}
		return cnt;
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
		
		//Hard Stop on no power
		if(powerManager.getCurrentCharge() <= 0){
			logger.fatal("No Power Remaining");
			System.out.println("No Power");
			System.exit(0);
		}

		// Update Power Consumption
		powerManager.update(_currentLocation, newLocation);
		
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
			checkClean(discoveryMap.get(currentX, currentY));
		}
		return newLocation;
	}
	
	/**
	 * Checks to see if a particular Navigation Cell is clean.
	 * @param _navCell of the cell to check
	 */
	private void checkClean(NavigationCell _navCell){
		if(!_navCell.getLocationData().isClean()){
			 boolean cleaned = vacuum.doClean(_navCell.getLocationData());
			 if(cleaned){
				 _navCell.setCleanedLastVisit(true);
			 }
			 else {
				 emptyMeLight = true;
			 }
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
	
	private void discoverFloor()
	{
		//Store Starting Location Information
		NavigationCell homeCell = discoveryMap.addNewNavigationCell(0, 0, 0, currentLocation);
		homeCell.calculateAdjacentDirections(currentLocation, floorNavProxy);
		homeCell.setPowerCostToChargeStation(0);
		
		//See initial dirt map
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation, true);
		
		int currentMaxNavLayer = discoveryMap.getMaxNavLayer();
		int newMaxNavLayer = currentMaxNavLayer + 1;
		
		//Begin Discovery
		while(this.emptyMeLight == false){
			
			//What's our current top discovery layer
			currentMaxNavLayer = discoveryMap.getMaxNavLayer();
			newMaxNavLayer = discoveryMap.getMaxNavLayer() + 1;
			
			boolean needCharge = false;
			
			for(NavigationCell navCell: discoveryMap.getTopLayerCells()){
				
				//Move to our cell
				currentLocation = moveToCell(navCell);
				
				for(Direction _d: navCell.getAdjacentList()){
					
					/*perform a check if we can get back to CS from potential destination cell
					 * 6 represents the maximum possible cost of a 1 cell round trip */
					if(navCell.getPowerCostToChargeStation() + 6 >= powerManager.getCurrentCharge()){
						needCharge = true;
						break;
					}
					currentLocation = executeMove(currentLocation, _d);

					//If we haven't been here - Create navigation Cell, 
					//update required steps, add top map.
					if(!discoveryMap.checkMap(currentX, currentY)){
						
						NavigationCell newNavCell = discoveryMap.addNewNavigationCell(currentX, 
													currentY, newMaxNavLayer, currentLocation);
						
						//Build our lists of directions.
						newNavCell.buildDirectionsToChargingStation(navCell, _d);
						newNavCell.buildDirectionsToCell(navCell, _d);
						newNavCell.calcPowerConsumption(navCell);
						newNavCell.calculateAdjacentDirections(currentLocation, floorNavProxy);
					}
					
					if(needCharge == false){
						//Check if the newly created cell needs cleaning
						checkClean(discoveryMap.get(currentX, currentY));
						
						//Go Back To original layer
						currentLocation = executeMove(currentLocation, _d.getOpposite());
					}
				}
				
				//Go Back to Charging Station
				for(Direction dir: navCell.getStepsToChargeStation()){
					currentLocation = executeMove(currentLocation, dir);
				}
				
				//This should always be true
				if(currentX == 0 & currentY == 0){
					powerManager.charge();
					needCharge = false;
				}
			}
			
			if(currentMaxNavLayer == discoveryMap.getMaxNavLayer()){
				if (logger.isDebugEnabled()) {
					logger.info("Discovery Ending at: " + discoveryMap.getMaxNavLayer());
					}
				break;
			}
		}
	}
	
	/**
	 * This Method runs after the floor plan has been discovered and brings 
	 * the robot back to every location that required cleaning on the last visit
	 * this method will run until the entire floor is clean.  It's relatively
	 * in-efficient as the robot has to return to the control station before it can
	 * navigate to the next dirty location.
	 * @return void
	 */
	private void goToDirt(){
		
		while(discoveryMap.dirtyCellsRemain() && emptyMeLight == false){
			for(NavigationCell _navCell: discoveryMap.getNavigationCells()){
				if(_navCell.isCleanedLastVisit()){
					moveToCell(_navCell);
					moveToChargeStation(_navCell);
					powerManager.charge();
				}
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
	/**
		This Method starts the clean sweeper
	 * @return void
	 */
	public void start(){
		discoverFloor();
		goToDirt();
	}
	
	public void printCleaningCycleStats(){
		System.out.println("Cells Discovered: " + discoveryMap.getNavigationCells().size());
		System.out.println("Dirt Collected: " + vacuum.getDirtCount());
		System.out.println("Empty Indicator On (?): " + emptyMeLight);
	}
}
