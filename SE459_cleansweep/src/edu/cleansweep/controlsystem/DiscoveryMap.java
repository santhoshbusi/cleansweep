package edu.cleansweep.controlsystem;

import java.util.ArrayList;

public class DiscoveryMap {
	
	private ArrayList<NavigationCell> cellMap;
	
	public DiscoveryMap(){
		cellMap = new ArrayList<NavigationCell>();
	}
	
	public boolean addToMap(NavigationCell _navCell){
		
		if(checkMap(_navCell.getX(), _navCell.getY()))
		{
			return false;
		}
		cellMap.add(_navCell);
		
		return true;
	}
	
	public boolean checkMap(NavigationCell _navCell){
		if(cellMap.contains(_navCell)){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkMap(int _x, int _y){
		for (NavigationCell nav: cellMap){
			if(nav.getX() == _x && nav.getY() == _y){
				return true;
			}
		}
		return false;
	}
	
	public NavigationCell get(int _x, int _y){
		for (NavigationCell nav: cellMap){
			if(nav.getX() == _x && nav.getY() == _y){
				return nav;
			}
		}
		return null;
	}

}
