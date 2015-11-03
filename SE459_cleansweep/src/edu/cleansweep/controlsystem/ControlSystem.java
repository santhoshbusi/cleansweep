package edu.cleansweep.controlsystem;
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

	public ControlSystem(String floorFile){
		currentX = 0;
		currentY = 0;
		
		discoveryMap = new DiscoveryMap();
		
		floorNavProxy = new FloorNavigationProxy(floorFile);
		currentLocation = floorNavProxy.getStaringLocation();
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
		}else if(_direction.equals(Direction.SOUTH)){
			this.currentX--;
		} else if(_direction.equals(Direction.EAST)){
			this.currentY--;
		} else if(_direction.equals(Direction.WEST)){
			this.currentY++;
		}
		
		//check if new location is clean
		if(!newLocation.isClean()){
			floorNavProxy.clean(newLocation);
		}
		return newLocation;
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
		NavigationCell homeCell = discoveryMap.addNewNavigationCell(0, 0, 0);
		homeCell.calculateAdjacentDirections(currentLocation, floorNavProxy);
		
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
													currentY, currentMaxNavLayer);
						
						//Build our lists of directions.
						newNavCell.buildDirectionsToChargingStation(navCell, _d);
						newNavCell.buildDirectionsToCell(navCell, _d);
						newNavCell.calculateAdjacentDirections(currentLocation, floorNavProxy);
					}
					//Go Back To original layer
					currentLocation = executeMove(currentLocation, _d.getOpposite());
				}
				//Go Back to Charging Station
				for(Direction dir: navCell.getStepsToChargeStation()){
					currentLocation = executeMove(currentLocation, dir);
				}
			}
		}
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
	}

        //Kinda dirty I know, but it should work as an initial implementation
        public void route_to_charger(){
           Location charger_location = floorNavProxy.getStaringLocation();
           int x = charger_location.getLongitude();
           int y = charger_location.getLatitude();
           
           int cur_x = currentLocation.getLongitude();
           int cur_y = currentLocation.getLatitude();
         
           while(x != cur_x && cur_y != y){
              if(x != cur_x){
                 _charger_route_x(x,y, cur_x, cur_y);
              }else if(cur_y != y){
                 _charger_route_y(x,y, cur_x, cur_y);
              }
              cur_x = currentLocation.getLongitude();
              cur_y = currentLocation.getLatitude();
           }
        }
        public void _charger_route_x(int x, int y, int cur_x, int cur_y){
           //Move move = new Move(floorNavProxy);
           Direction direction = null;
           if(x - cur_x < 0){
              direction = Direction.EAST;
           }else if(x - cur_x > 0){
              direction = Direction.WEST;
           }
           Location curLocation = executeMove(currentLocation, direction);

           if(!curLocation.isObstructed()){
              currentLocation = curLocation;
           }else{
              _charger_route_y(x,y, cur_x, cur_y);
           }
        }
        public void _charger_route_y(int x, int y, int cur_x, int cur_y){
           //Move move = new Move(floorNavProxy);
           Direction direction = null;
           if(y - cur_y < 0){
              direction = Direction.SOUTH;
           }else if(y - cur_y > 0){
              direction = Direction.NORTH;
           }

           Location curLocation = executeMove(currentLocation, direction);
           if(!curLocation.isObstructed()){
              currentLocation = curLocation;
           }else{
              _charger_route_x(x,y, cur_x, cur_y);
           }
        }
	
	public static void main(String [] args)
	{
		ControlSystem cs = new ControlSystem("TEST_C.cft");
		cs.discoverFloor(7);
		cs.discoveryMap.printMap();
	}
}
