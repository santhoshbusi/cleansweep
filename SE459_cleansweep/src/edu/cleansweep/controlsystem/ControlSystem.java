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
		int random = (int)(Math.random() * (4 - 0) + 1);
		switch(random)
		{
			case 1:
				if(floorNavProxy.canMove(currentLocation, Direction.NORTH)){
					currentLocation = floorNavProxy.move(currentLocation, Direction.NORTH);
					System.out.println("Moving North");
					f.displayLocationOnFloorInConsole(currentLocation);
				}
			break;
			
			case 2:
				if(floorNavProxy.canMove(currentLocation, Direction.SOUTH)){
					currentLocation = floorNavProxy.move(currentLocation, Direction.SOUTH);
					System.out.println("Moving South");
					f.displayLocationOnFloorInConsole(currentLocation);
				}
			break;
			
			case 3:
				if (floorNavProxy.canMove(currentLocation, Direction.WEST)){
					currentLocation = floorNavProxy.move(currentLocation, Direction.WEST);
					System.out.println("Moving West");
					f.displayLocationOnFloorInConsole(currentLocation);
				}
			break;
			
			case 4:
				 if (floorNavProxy.canMove(currentLocation, Direction.EAST)){
					 currentLocation = floorNavProxy.move(currentLocation, Direction.EAST);
					 System.out.println("Moving East");
					 f.displayLocationOnFloorInConsole(currentLocation);
			}
			break;
		}
	}
	
	public static void main(String [] args)
	{
		ControlSystem cs = new ControlSystem();
		
		int i = 0;
		while(i < 10)
		{
			cs.move();
			i++;
		}
	}
}
