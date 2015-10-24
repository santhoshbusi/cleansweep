package edu.cleansweep.controlsystem;

import edu.cleansweep.floor.*;

public class ControlSystem {

	Floor f;
	Location currentLocation;
	FloorNavigationProxy floorNavProxy;

	public ControlSystem(){
		
		//I shouldn't have access to these objects; can we create them in Nav Proxy?
		f = new Floor();
		f.createDefaultFloorPlan();
		floorNavProxy = new FloorNavigationProxy(f);
		currentLocation = floorNavProxy.getStaringLocation();
	}
	
	public void move()
	{
		System.out.println(currentLocation.toString());
		
		int i = 0;
		
		while(i < 100)
		{
			int random = (int)(Math.random() * (4 - 0) + 1);
			
			switch(random)
			{
				case 1:
					if(floorNavProxy.canMove(currentLocation, Direction.NORTH)){
						currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
						System.out.println("Moving North");
					}
				break;
				
				case 2:
					if(floorNavProxy.canMove(currentLocation, Direction.SOUTH)){
						currentLocation = floorNavProxy.move(currentLocation, Direction.SOUTH);
						System.out.println("Moving South");
					}
				break;
				
				case 3:
					if (floorNavProxy.canMove(currentLocation, Direction.WEST)){
						currentLocation = floorNavProxy.move(currentLocation, Direction.WEST);
						System.out.println("Moving West");
					}
				break;
				
				case 4:
					 if (floorNavProxy.canMove(currentLocation, Direction.EAST)){
						 currentLocation = floorNavProxy.move(currentLocation, Direction.EAST);
						 System.out.println("Moving East");
				}
				break;
			}
			i++;
		}
	}
	
	public static void main(String [] args)
	{
		ControlSystem cs = new ControlSystem();
		cs.move();
	}

}
