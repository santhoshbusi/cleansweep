package edu.cleansweep.controlsystem;
import edu.cleansweep.floor.Location;

public class NavigationCell {
	private int x;
	private int y;
	private boolean cleanedLastVisit;
	Location locationData;
	
	public NavigationCell(int _x, int _y){
		this.x = _x;
		this.y = _y;
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
