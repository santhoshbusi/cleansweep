package edu.cleansweep.controlsystem;
import java.util.ArrayList;

import edu.cleansweep.floor.Direction;
import edu.cleansweep.floor.Location;

public class NavigationCell {
	private int x;
	private int y;
	private int navigationLayer;
	
	private boolean cleanedLastVisit;
	private Location locationData;
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
	
	public ArrayList<Direction> getAdjacentList()
	{
		return adjacentDirections;
	}
	
	public ArrayList<Direction> getStepsToChargeStation(){
		return stepsToChargeStation;
	}
	
	public void addToNavLists(Direction _dir){
		stepsToNavCell.add(_dir);
		stepsToChargeStation.add(0, _dir);
		
	}
	
	public ArrayList<Direction> getStepsToNavCell(){
		return stepsToNavCell;
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
