package edu.cleansweep.controlsystem;
import java.util.ArrayList;

import edu.cleansweep.floor.Direction;
import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.Location;
import edu.cleansweep.controlsystem.power.*;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

/**
 * Navigation cells represent locations discovered by the control system.
 * They have their own [x,y] coordinates (relative to charging station) and
 * can also store data about the cleanliness of the location.
 * @author pmathieu
 */

public class NavigationCell {
	private int x;
	private int y;
	private int navigationLayer;
	private static final Logger logger = LogManager.getLogger(NavigationCell.class.getName());

	
	private boolean cleanedLastVisit;
	private Location locationData;
	private double powerCostToChargeStation;
	
	private ArrayList<Direction> adjacentDirections;
	private ArrayList<Direction> stepsToChargeStation;
	private ArrayList<Direction> stepsToNavCell;
	
	public NavigationCell(int _x, int _y, int _layer){
		this.x = _x;
		this.y = _y;
		this.navigationLayer = _layer;
		
		adjacentDirections = new ArrayList<Direction>();
		stepsToChargeStation = new ArrayList<Direction>();
		stepsToNavCell = new ArrayList<Direction>();
	}
	
	public NavigationCell(int _x, int _y, int _layer, Location _locationData){
		this.x = _x;
		this.y = _y;
		this.navigationLayer = _layer;
		this.locationData = _locationData;
		
		adjacentDirections = new ArrayList<Direction>();
		stepsToChargeStation = new ArrayList<Direction>();
		stepsToNavCell = new ArrayList<Direction>();
	}
	
	/**
	 * Returns the array list of available adjacent directions for the cell
	 */
	public ArrayList<Direction> getAdjacentList(){
		if (logger.isDebugEnabled()) {
			logger.debug("getAdjacentList() was called: return adjacentDirections-" + adjacentDirections);		
			}
		return adjacentDirections;
	}
	
	/**
	 * Returns an array list of steps to get back to the charging Station
	 */
	public ArrayList<Direction> getStepsToChargeStation(){
		if (logger.isDebugEnabled()) {
			logger.debug("getStepsToChargeStation() was called: return stepsToChargeStation-" + stepsToChargeStation);		
			}
		return stepsToChargeStation;
	}
	
	/**
	 * Returns an array list of steps to get to the navigation cell from the charging station
	 */
	public ArrayList<Direction> getStepsToNavCell(){
		if (logger.isDebugEnabled()) {
			logger.debug("getStepsToNavCell() was called: return stepsToNavCell-" + stepsToNavCell);		
			}
		return stepsToNavCell;
	}
	
	/**
	 * Builds an Array list of Directions on how to get to the navigation cell
	 * from the charging station.
	 */
	public void buildDirectionsToCell(NavigationCell _fromCell, Direction _lastDirection){
		for(Direction _dir: _fromCell.getStepsToNavCell()){
			this.getStepsToNavCell().add(_dir);
		}
		this.getStepsToNavCell().add(_lastDirection);
	}
	
	/**
	 * Builds an Array list of Directions on how to get to the charging station
	 * from the navigation cell.
	 */
	public void buildDirectionsToChargingStation(NavigationCell _fromCell, Direction _lastDirection){
		this.getStepsToChargeStation().add(0, _lastDirection.getOpposite());	
		for(Direction _dir: _fromCell.getStepsToChargeStation()){
			this.getStepsToChargeStation().add(_dir);
		}
	}
	
	public void calcPowerConsumption(NavigationCell _fromCell){
		this.powerCostToChargeStation = _fromCell.getPowerCostToChargeStation() + 
				PowerManager.getPowerCost(_fromCell.locationData,this.locationData);
	}
	/**
	 * Calculates all of the available adjacent directions for a given Navigation Cell
	 */
	public void calculateAdjacentDirections(Location _location, FloorNavigationProxy _floorNavProxy){
		
		if(_floorNavProxy.canMove(_location, Direction.NORTH)){
			this.adjacentDirections.add(Direction.NORTH);
		}
		if(_floorNavProxy.canMove(_location, Direction.SOUTH)){
			this.adjacentDirections.add(Direction.SOUTH);
		}
		if(_floorNavProxy.canMove(_location, Direction.EAST)){
			this.adjacentDirections.add(Direction.EAST);
		}
		if(_floorNavProxy.canMove(_location, Direction.WEST)){
			this.adjacentDirections.add(Direction.WEST);
		}
	}
	
	public double getPowerCostToChargeStation(){
		return powerCostToChargeStation;
	}
	
	public void setPowerCostToChargeStation(double _value){
		powerCostToChargeStation = _value;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isCleanedLastVisit() {
		return cleanedLastVisit;
	}
	public void setCleanedLastVisit(boolean cleanedLastVisit) {
		this.cleanedLastVisit = cleanedLastVisit;
	}
	public Location getLocationData() {
		return locationData;
	}
	public void setLocationData(Location locationData) {
		this.locationData = locationData;
	}
	public int getNavLayer(){
		return this.navigationLayer;
	}
	
	@Override
	public boolean equals(Object _object){
		
		boolean isEqual = false;
		
		if(_object != null && _object instanceof NavigationCell){
			isEqual = ((this.x == ((NavigationCell)_object).x) &&
						this.y == ((NavigationCell)_object).y);
		}
		return isEqual;
	}
}
