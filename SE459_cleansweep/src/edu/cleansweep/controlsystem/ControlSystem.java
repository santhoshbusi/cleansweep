package edu.cleansweep.controlsystem;

import java.util.ArrayList;

import edu.cleansweep.floor.*;

public class ControlSystem {

	private int currentX;
	private int currentY;
	private DiscoveryMap discoveryMap;
	
	private Decision decision;
	private Location currentLocation;
	private FloorNavigationProxy floorNavProxy;

	public ControlSystem(){
		currentX = 0;
		currentY = 0;
		
		discoveryMap = new DiscoveryMap();
		
		floorNavProxy = new FloorNavigationProxy("TEST_C.cft");
		currentLocation = floorNavProxy.getStaringLocation();
	}

	/**
	 * This test implementation of move randomly moves the current location
	 */
	
	public void firstMove(){
		
		Move move = new Move(floorNavProxy);
		
		//Print Starting Location
		floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		//Starting Cell
		NavigationCell navCell = new NavigationCell(currentX, currentY, 0);
		discoveryMap.addToMap(navCell);
		
		//Find What's available based on our current location
		decision = new Decision(currentLocation, floorNavProxy);
		
		//run decision and store results in list
		ArrayList<Direction> decisionList = decision.checkAvailable();
		
		//For each direction in ArrayList, store in navCells list
		for(Direction _d: decisionList){
			navCell.getAdjacentList().add(_d);
		}
		
		//for each possible direction, move and calculate adjacent Cells
		for(Direction _d: navCell.getAdjacentList()){
			
			//move
			currentLocation = move.executeMove(currentLocation, _d);
			floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
			//we need to know what integer value we're moving
			updateCurrentXY(_d);
			
			//Create navigation Cell, update required steps, add top map.
			NavigationCell newNav = new NavigationCell(currentX, currentY, 1);
			newNav.getStepsToNavCell().add(_d);
			newNav.getStepsToChargeStation().add(_d.getOpposite());
			discoveryMap.addToMap(newNav);
			
			//Create a new decision object based on new current location
			decision = new Decision(currentLocation, floorNavProxy);
			decisionList = decision.checkNewAvailable(_d);
			for(Direction _dir: decisionList){
				newNav.getAdjacentList().add(_dir);
			}
			
			//Move Back to original
			Direction back = _d.getOpposite();
			currentLocation = move.executeMove(currentLocation, back);
			updateCurrentXY(back);
			floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		}
	}
	
	public void updateCurrentXY(Direction _dir){
		if(_dir.equals(Direction.NORTH)){
			this.currentX++;
		}else if(_dir.equals(Direction.SOUTH)){
			this.currentX--;
		} else if(_dir.equals(Direction.EAST)){
			this.currentY--;
		} else if(_dir.equals(Direction.WEST)){
			this.currentY++;
		}
	}
	public void discoverFloor()
	{
		ArrayList<NavigationCell> topLayerList = discoveryMap.getTopLayerCells();
		
		Move move = new Move(floorNavProxy);
		//floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
		
		int currentMaxNavLayer = discoveryMap.getMaxNavLayer() + 1;
		
		//For Every "Top Layer Cell" (The cells that are most recently discovered)
		for(NavigationCell navCell: topLayerList){
			
			for(Direction dir: navCell.getStepsToNavCell()){
				//Get us to the top layer cell
				currentLocation = move.executeMove(currentLocation, dir);
				floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
				
				updateCurrentXY(dir);
			}
			
			//At Top Layer Cell - go through the adjacent cells
			for(Direction _d: navCell.getAdjacentList()){
				//Move
				currentLocation = move.executeMove(currentLocation, _d);
				floorNavProxy.displayLocationOnFloorInConsole(currentLocation);

				updateCurrentXY(_d);
				//If we haven't been here - Create navigation Cell, 
				//update required steps, add top map.
				
				if(!discoveryMap.checkMap(currentX, currentY)){
					System.out.println("Creating new Navigation Cell " +
							"X: " + currentX + " Y: " + currentY + " layer: " +
							currentMaxNavLayer);
					
					NavigationCell newNav = new NavigationCell(currentX, currentY, 
							currentMaxNavLayer);
					
					//Add back to Charge Station Directions.
					newNav.getStepsToChargeStation().add(0, _d.getOpposite());
					for(Direction _dirStep: navCell.getStepsToChargeStation()){
						newNav.getStepsToChargeStation().add(_dirStep);
					}
					
					//Add To Navigation Cell Directions
					for(Direction _dirStep: navCell.getStepsToNavCell()){
						newNav.getStepsToNavCell().add(_dirStep);
					}
					newNav.getStepsToNavCell().add(_d);
					
					//Add to our Discover Map
					discoveryMap.addToMap(newNav);
					
					//Create a new decision object based on new current location
					decision = new Decision(currentLocation, floorNavProxy);
					ArrayList<Direction> decisionList = decision.checkNewAvailable(_d);
					
					for(Direction _dir: decisionList){
						newNav.getAdjacentList().add(_dir);
					}
				}

				//Go Back To original move
				Direction _back = _d.getOpposite();
				currentLocation = move.executeMove(currentLocation, _d.getOpposite());
				floorNavProxy.displayLocationOnFloorInConsole(currentLocation);

				updateCurrentXY(_back);
			}
			
			//Go Back to Charging Station
			for(Direction dir: navCell.getStepsToChargeStation()){
				currentLocation = move.executeMove(currentLocation, dir);
				floorNavProxy.displayLocationOnFloorInConsole(currentLocation);
				
				updateCurrentXY(dir);
			}
			//Just to be safe
			currentX = 0;
			currentY = 0;
		}
	}
	
	public static void main(String [] args)
	{
		ControlSystem cs = new ControlSystem();
		cs.firstMove();
		
		int i = 0;
		while(i < 20)
		{
			cs.discoverFloor();
			i++;
		}
	}
}
