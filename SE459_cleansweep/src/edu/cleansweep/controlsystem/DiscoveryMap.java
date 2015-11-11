package edu.cleansweep.controlsystem;
import java.util.ArrayList;

import edu.cleansweep.floor.Location;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * This map is esentially a collection of methods wrapped around an array list that
 * represents what the control system has discovered.
 * @author pmathieu
 */

public class DiscoveryMap {

	private static final Logger logger = LogManager.getLogger(DiscoveryMap.class.getName());
	private ArrayList<NavigationCell> cellMap;
	
	public DiscoveryMap(){
		cellMap = new ArrayList<NavigationCell>();
	}
	
	/**
	 * Adds a Navigation Cell to our Master Array List
	 * @param _navCell Navigation Cell to be added to the map
	 * @return False if addition failed
	 */
	public boolean addToMap(NavigationCell _navCell){
		
		logger.info("addToMap() was called.");
		if(checkMap(_navCell.getX(), _navCell.getY())){
			return false;
		}
		cellMap.add(_navCell);
		return true;
	}
	
	/**
	 * Creates a new Navigation Cell and adds it to our Master Array List
	 * @param _x X-Coordinate of new Navigation Cell
	 * @param _y Y-Coordinate of new Navigation Cell
	 * @param _layer Layer of new Navigation Cell
	 * @return the newly created Navigation Cell
	 */
	public NavigationCell addNewNavigationCell(int _x, int _y, int _layer){
		
		NavigationCell newNavCell = null;
		if(!checkMap(_x, _y)){
			newNavCell = new NavigationCell(_x, _y, _layer);
			cellMap.add(newNavCell);
		}
		logger.info("addNewNavigationCell() was called: return newNavCell-" + newNavCell);
		return newNavCell;
	}
	
	public NavigationCell addNewNavigationCell(int _x, int _y, int _layer, Location _locationData){
		
		NavigationCell newNavCell = null;
		if(!checkMap(_x, _y)){
			newNavCell = new NavigationCell(_x, _y, _layer, _locationData);
			cellMap.add(newNavCell);
		}
		logger.info("addNewNavigationCell() was called: return newNavCell-" + newNavCell);
		return newNavCell;
	}
	
	/**
	 * Check to see if a navigation cell already exists in our map
	 * @param _navCell Navigation Cell to check against our array list
	 * @return True if navigation cell was found.
	 */
	public boolean checkMap(NavigationCell _navCell){
		logger.info("checkMap() was called.");
		if(cellMap.contains(_navCell)){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Creates a new Navigation Cell and adds it to our Master Array List
	 * @param _x X-Coordinate of the navigation cell we're checking on
	 * @param _y Y-Coordinate of the navigation cell we're checking on
	 * @return True if navigation cell was found.
	 */
	public boolean checkMap(int _x, int _y){
		logger.info("checkMap() was called");
		for (NavigationCell nav: cellMap){
			if(nav.getX() == _x && nav.getY() == _y){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the current maximum navigation layer of our map.
	 * @return An integer value representing our current maximum map layer.
	 */
	public int getMaxNavLayer(){
		int maxNavLayer = 0;
		for (NavigationCell nav: cellMap){
			if(nav.getNavLayer() > maxNavLayer){
				maxNavLayer = nav.getNavLayer();
			}
		}
		logger.info("getMaxNavLayer() was called: return maxNavLayer" + maxNavLayer);
		return maxNavLayer;
	}
	
	/**
	 * Gets an Array List of all navigation cells in our top layer.
	 * @return Array List of maximum navigation cells
	 */
	public ArrayList<NavigationCell> getTopLayerCells(){
		
		ArrayList<NavigationCell> topLayerList = new ArrayList<NavigationCell>();
		int topLayer = getMaxNavLayer();
		
		for (NavigationCell nav: cellMap){
			if(nav.getNavLayer() == topLayer){
				topLayerList.add(nav);
			}
		}
		logger.info("getTopLayerCells() was called: return topLayerList" + topLayerList);
		return topLayerList;
	}
	
	/**
	 * Retrieves the Navigation Cell based on its coordinates.
	 * @return The Navigation Cell that matches input coordinates.
	 */
	public NavigationCell get(int _x, int _y){
		logger.info("get() was called");
		for (NavigationCell nav: cellMap){
			if(nav.getX() == _x && nav.getY() == _y){
				return nav;
			}
		}
		return null;
	}
	
	/**
	 * Retrieves the Array list of Navigation Cells
	 * @return The Navigation Cell that matches input coordinates.
	 */
	public ArrayList<NavigationCell> getNavigationCells(){
		logger.info("getNavigationCells() was called: return cellMap-" + cellMap);
		return cellMap;
	}
	
	/**
	 * Retrieves the Number of dirty cells left on the floor plan
	 * (based on whether or not we cleaned it on the last visit)
	 * @return The Count of [potentially] dirty cells
	 */
	public int countDirtyCells(){
		int cnt = 0;
		for(NavigationCell nav: cellMap){
			if(nav.isCleanedLastVisit()){
				cnt++;
			}
		}
		return cnt;
	}
	
	/**
	 * Iterates through internal list of navigation areas to see if there
	 * are any remaining cells that might be dirty
	 * (based on whether or not we cleaned it on the last visit)
	 * @return boolen indicating if dirty cells remain
	 */
	public boolean dirtyCellsRemain(){
		logger.info("dirtyCellsRemain() was called.");
		for(NavigationCell nav: cellMap){
			if(nav.isCleanedLastVisit()){
				return true;
			}
		}
		return false;
	}
	/**
	 * Prints the current map
	 */
	public void printMap(){
		logger.info("printMap() was called");
		for(NavigationCell _navCell: cellMap){
			System.out.println("Nav Cell- X: " + _navCell.getX() +
					" Y: " + _navCell.getY() + " Layer: " +  _navCell.getNavLayer());
		}
	}

}
