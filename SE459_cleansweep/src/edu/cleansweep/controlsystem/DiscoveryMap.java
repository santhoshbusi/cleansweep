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
	
	public int getMaxNavLayer(){
		int maxNavLayer = 0;
		for (NavigationCell nav: cellMap){
			if(nav.getNavLayer() > maxNavLayer){
				maxNavLayer = nav.getNavLayer();
			}
		}
		return maxNavLayer;
	}
	
	public ArrayList<NavigationCell> getTopLayerCells(){
		
		ArrayList<NavigationCell> topLayerList = new ArrayList<NavigationCell>();
		int topLayer = getMaxNavLayer();
		
		for (NavigationCell nav: cellMap){
			if(nav.getNavLayer() == topLayer){
				topLayerList.add(nav);
			}
		}
		return topLayerList;
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
