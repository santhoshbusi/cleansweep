package edu.cleansweep.controlsystem.power;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import edu.cleansweep.controlsystem.power.PowerManager;
import edu.cleansweep.floor.Location;
import edu.cleansweep.floor.Direction;
import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.FloorType;

public class PowerManagerTest {
	
	private PowerManager powerManager;
	private FloorNavigationProxy floorNavProxy;
	private double powerLevel = 100.0;

	
	@Before
	public void setup(){
		 powerManager = new PowerManager();
	}
	
	@Test
	public void testGetCurrentCharge1(){
		
		floorNavProxy = new FloorNavigationProxy("TEST_C.cft");
		
		Location start; // used for PowerManager Calculation
		Location end;   // used for PowerManager Calculation
		Location current; // used for FloorNavigationProxy 
		
		current = floorNavProxy.getStaringLocation();
		// Assert that PowerState is FullyChargedPowerState
		assertEquals(FullyChargedPowerState.class, powerManager.getCurrentState().getClass()); 
		
		// Save Location
		start = current;
		// Move
		current = floorNavProxy.move(current, Direction.NORTH);
		// Get Ending Location
		end = current;
		// assert start is Charging Station
		assertEquals(FloorType.CHARGINGSTATION, start.getFloorType());
		// assert end is High Pile Carpet
		assertEquals(FloorType.HIGHPILECARPET, end.getFloorType());
		// Assert power cost is 3 / 2
		assertEquals((double)3/2,PowerManager.getPowerCost(start, end),0.0);
		// Update Power Usage
		powerManager.update(start, end);
		// assert Change in power State
		assertEquals(DischargingPowerState.class, powerManager.getCurrentState().getClass());
		// assert change in power level
		powerLevel = ((double)powerLevel) - ((double)(3.0/2.0));
		assertEquals(powerLevel, powerManager.getCurrentCharge(), 0.0);
		
		// Move West 3 Times
		for(int moves=0; moves<3; moves++){
			// save starting position
			start = current;
			// move west
			current = floorNavProxy.move(current, Direction.WEST);
			// save ending position
			end = current;
			// assert start and ending are both high pile carpet
			assertEquals(FloorType.HIGHPILECARPET, start.getFloorType());
			assertEquals(FloorType.HIGHPILECARPET, end.getFloorType());
			// Assert Cost of move is 3.0
			assertEquals(3.0,PowerManager.getPowerCost(start, end),0.0);
			// Update Power Usage
			powerManager.update(start, end);
			// Assert change in power level
			powerLevel = powerLevel - 3.0;
			assertEquals(powerLevel, powerManager.getCurrentCharge(), 0.0);
		}
		
		// save starting position
		start = current;
		// move west
		current = floorNavProxy.move(current, Direction.WEST);
		// save ending position
		end = current;
		
		// assert start is high pile carpet
		assertEquals(FloorType.HIGHPILECARPET, start.getFloorType());
		// assert end is bare floor
		assertEquals(FloorType.BAREFLOOR, end.getFloorType());
		
		// Assert Cost of move is 3.0
		assertEquals(2.0,PowerManager.getPowerCost(start, end),0.0);
		// Update Power Usage
		powerManager.update(start, end);
		// Assert change in power level
		powerLevel = powerLevel - 2.0;
		assertEquals(powerLevel, powerManager.getCurrentCharge(), 0.0);
		
		// Move West 2 Times
		for(int moves=0; moves<2; moves++){
			// save starting position
			start = current;
			// move west
			current = floorNavProxy.move(current, Direction.WEST);
			// save ending position
			end = current;
			
			// assert start is BareFloor
			assertEquals(FloorType.BAREFLOOR, start.getFloorType());
			// assert end is bare floor
			assertEquals(FloorType.BAREFLOOR, end.getFloorType());
			
			// Assert Cost of move is 3.0
			assertEquals(1.0,PowerManager.getPowerCost(start, end),0.0);
			// Update Power Usage
			powerManager.update(start, end);
			// Assert change in power level
			powerLevel = powerLevel - 1.0;
			assertEquals(powerLevel, powerManager.getCurrentCharge(), 0.0);
			System.out.println("[PowerManagerTest] PowerLevel : " + powerLevel);
		}
	}
	
	@Test
	public void testGetCurrentCharge2(){
		
		floorNavProxy = new FloorNavigationProxy("TEST_A.cft");
		
		Location start; // used for PowerManager Calculation
		Location end;   // used for PowerManager Calculation
		Location current; // used for FloorNavigationProxy 
		
		current = floorNavProxy.getStaringLocation();
		// Assert that PowerState is FullyChargedPowerState
		assertEquals(FullyChargedPowerState.class, powerManager.getCurrentState().getClass()); 
		
		// Save Location
		start = current;
		// Move
		current = floorNavProxy.move(current, Direction.NORTH);
		// Get Ending Location
		end = current;
		// assert start is Charging Station
		assertEquals(FloorType.CHARGINGSTATION, start.getFloorType());
		// assert end is High Pile Carpet
		assertEquals(FloorType.HIGHPILECARPET, end.getFloorType());
		// Assert power cost is 3.0
		assertEquals((double)3/2,PowerManager.getPowerCost(start, end),0.0);
		// Update Power Usage
		powerManager.update(start, end);
		// assert Change in power State
		assertEquals(DischargingPowerState.class, powerManager.getCurrentState().getClass());
		// assert change in power level
		powerLevel = ((double)powerLevel) - ((double)(3.0/2.0));
		assertEquals(powerLevel, powerManager.getCurrentCharge(), 0.0);
		
		for(int moves=0; moves<4; moves++){
			
			// Save Location
			start = current;
			// Move
			current = floorNavProxy.move(current, Direction.NORTH);
			// Get Ending Location
			end = current;
			// assert start is High Pile Carpet
			assertEquals(FloorType.HIGHPILECARPET, start.getFloorType());
			// assert end is High Pile Carpet
			assertEquals(FloorType.HIGHPILECARPET, end.getFloorType());
			// Assert power cost is 3.0
			assertEquals(3.0,PowerManager.getPowerCost(start, end),0.0);
			// Update Power Usage
			powerManager.update(start, end);
			// assert Change in power State
			assertEquals(DischargingPowerState.class, powerManager.getCurrentState().getClass());
			// assert change in power level
			powerLevel = ((double)powerLevel) - 3.0;
			assertEquals(powerLevel, powerManager.getCurrentCharge(), 0.0);
			System.out.println("[PowerManagerTest] " + powerManager);
		}
		
		for(int moves=0; moves<3; moves++){
			
			// Save Location
			start = current;
			// Move
			current = floorNavProxy.move(current, Direction.EAST);
			// Get Ending Location
			end = current;
			// assert start is High Pile Carpet
			assertEquals(FloorType.HIGHPILECARPET, start.getFloorType());
			// assert end is High Pile Carpet
			assertEquals(FloorType.HIGHPILECARPET, end.getFloorType());
			// Assert power cost is 3
			assertEquals(3.0,PowerManager.getPowerCost(start, end),0.0);
			// Update Power Usage
			powerManager.update(start, end);
			// assert Change in power State
			assertEquals(DischargingPowerState.class, powerManager.getCurrentState().getClass());
			// assert change in power level
			powerLevel = ((double)powerLevel) - 3.0;
			assertEquals(powerLevel, powerManager.getCurrentCharge(), 0.0);
			System.out.println("[PowerManagerTest] " + powerManager);
		}
		
		// Save Location
		start = current;
		// Move
		current = floorNavProxy.move(current, Direction.EAST);
		// Get Ending Location
		end = current;
		// assert start is High Pile Carpet
		assertEquals(FloorType.HIGHPILECARPET, start.getFloorType());
		// assert end is Low Pile Carpet
		assertEquals(FloorType.LOWPILECARPET, end.getFloorType());
		// Assert power cost is 2.5
		assertEquals(2.5,PowerManager.getPowerCost(start, end),0.0);
		
		for(int moves=0; moves<2; moves++){
			// Save Location
			start = current;
			// Move
			current = floorNavProxy.move(current, Direction.EAST);
			// Get Ending Location
			end = current;
			// assert start is Low Pile Carpet
			assertEquals(FloorType.LOWPILECARPET, start.getFloorType());
			// assert end is Low Pile Carpet
			assertEquals(FloorType.LOWPILECARPET, end.getFloorType());
			// Assert power cost is 2
			assertEquals(2,PowerManager.getPowerCost(start, end),0.0);
		}
		
		// Save Location
		start = current;
		// Move
		current = floorNavProxy.move(current, Direction.EAST);
		// Get Ending Location
		end = current;
		// assert start is High Pile Carpet
		assertEquals(FloorType.LOWPILECARPET, start.getFloorType());
		// assert end is Bare Floor
		assertEquals(FloorType.BAREFLOOR, end.getFloorType());
		// Assert power cost is 1.5
		assertEquals(1.5,PowerManager.getPowerCost(start, end),0.0);
		
		for(int moves=0; moves<4; moves++){
			// Save Location
			start = current;
			// Move
			current = floorNavProxy.move(current, Direction.EAST);
			// Get Ending Location
			end = current;
			// assert start is Bare Floor
			assertEquals(FloorType.BAREFLOOR, start.getFloorType());
			// assert end is Bare Floor
			assertEquals(FloorType.BAREFLOOR, end.getFloorType());
			// Assert power cost is 1
			assertEquals(1,PowerManager.getPowerCost(start, end),0.0);
		}
	}
		
	@Test
	public void testChangePowerStates(){
		floorNavProxy = new FloorNavigationProxy("TEST_A.cft");
		
		Location start; // used for PowerManager Calculation
		Location end;   // used for PowerManager Calculation
		Location current; // used for FloorNavigationProxy 
		
		current = floorNavProxy.getStaringLocation();
		// Assert that PowerState is FullyChargedPowerState
		assertEquals(FullyChargedPowerState.class, powerManager.getCurrentState().getClass()); 
		System.out.println("[PowerManagerTest] " + powerManager.getCurrentState());
		// Save Location
		start = current;
		// Move
		current = floorNavProxy.move(current, Direction.NORTH);
		// Get Ending Location
		end = current;
		// Update Power Usage
		powerManager.update(start, end);
		powerLevel = powerManager.getCurrentCharge();
		// assert Change in power State
		assertEquals(DischargingPowerState.class, powerManager.getCurrentState().getClass());
		System.out.println("[PowerManagerTest] " + powerManager.getCurrentState());
		// assert change in power level
		
		for(int moves=0;moves<9;moves++){
		
			// Save Location
			start = current;
			// Move
			current = floorNavProxy.move(current, Direction.NORTH);
			// Get Ending Location
			end = current;
			// Update Power Usage
			powerManager.update(start, end);
			powerLevel = powerManager.getCurrentCharge();
			
			// Save Location
			start = current;
			// Move
			current = floorNavProxy.move(current, Direction.EAST);
			// Get Ending Location
			end = current;
			// Update Power Usage
			powerManager.update(start, end);
			powerLevel = powerManager.getCurrentCharge();

			// Save Location
			start = current;
			// Move
			current = floorNavProxy.move(current, Direction.SOUTH);
			// Get Ending Location
			end = current;
			// Update Power Usage
			powerManager.update(start, end);
			powerLevel = powerManager.getCurrentCharge();

			// Save Location
			start = current;
			// Move
			current = floorNavProxy.move(current, Direction.WEST);
			// Get Ending Location
			end = current;
			// Update Power Usage
			powerManager.update(start, end);
			powerLevel = powerManager.getCurrentCharge();
			
			if(moves == 8){
				assertEquals(FullyDepletedPowerState.class, powerManager.getCurrentState().getClass());
				System.out.println("[PowerManagerTest] " + powerManager.getCurrentState());
			}
		}
	
	}
}
