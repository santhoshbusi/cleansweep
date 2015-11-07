package edu.cleansweep.tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import edu.cleansweep.controlsystem.*;
import edu.cleansweep.floor.Direction;
import edu.cleansweep.floor.FloorNavigationProxy;
import edu.cleansweep.floor.Location;

public class NavigationCellTest {
	
	@Test
	public void ConstructorTest() {
		NavigationCell navCell = new NavigationCell(1, 1, 1);
		assertNotNull(navCell);
		
		assertEquals(navCell.getX(), 1);
		assertEquals(navCell.getY(), 1);
		assertEquals(navCell.getNavLayer(), 1);
	}
	
	@Test
	public void StepsToChargingStationTest(){
		
		NavigationCell navCell = new NavigationCell(1,1,1);
		
		navCell.getStepsToChargeStation().add(Direction.NORTH);
		navCell.getStepsToChargeStation().add(Direction.SOUTH);
		navCell.getStepsToChargeStation().add(Direction.EAST);
		navCell.getStepsToChargeStation().add(Direction.WEST);
		
		ArrayList<Direction> dirs = new ArrayList<Direction>();
		dirs = navCell.getStepsToChargeStation();
		
		assertEquals(dirs.get(0), Direction.NORTH);
		assertEquals(dirs.get(1), Direction.SOUTH);
		assertEquals(dirs.get(2), Direction.EAST);
		assertEquals(dirs.get(3), Direction.WEST);
	}
	
	@Test
	public void StepsToNavCellTest(){
		
		NavigationCell navCell = new NavigationCell(1,1,1);
		
		navCell.getStepsToNavCell().add(Direction.WEST);
		navCell.getStepsToNavCell().add(Direction.EAST);
		navCell.getStepsToNavCell().add(Direction.SOUTH);
		navCell.getStepsToNavCell().add(Direction.NORTH);
		
		ArrayList<Direction> dirs = new ArrayList<Direction>();
		dirs = navCell.getStepsToNavCell();
		
		assertEquals(dirs.get(0), Direction.WEST);
		assertEquals(dirs.get(1), Direction.EAST);
		assertEquals(dirs.get(2), Direction.SOUTH);
		assertEquals(dirs.get(3), Direction.NORTH);
	}
	
	@Test
	public void BuildDirectionsToCellTest(){
		
		NavigationCell navCell = new NavigationCell(1,1,1);
		
		navCell.getStepsToNavCell().add(Direction.WEST);
		navCell.getStepsToNavCell().add(Direction.EAST);
		navCell.getStepsToNavCell().add(Direction.SOUTH);
		navCell.getStepsToNavCell().add(Direction.NORTH);
		
		NavigationCell newNav = new NavigationCell(2,2,2);
		newNav.buildDirectionsToCell(navCell, Direction.NORTH);
		
		ArrayList<Direction> _dir = newNav.getStepsToNavCell();
		
		assertEquals(_dir.get(0), Direction.WEST);
		assertEquals(_dir.get(1), Direction.EAST);
		assertEquals(_dir.get(2), Direction.SOUTH);
		assertEquals(_dir.get(3), Direction.NORTH);
		assertEquals(_dir.get(3), Direction.NORTH);
	}
	
	@Test
	public void BuildDirectionsToCsTest(){
		
		NavigationCell navCell = new NavigationCell(1,1,1);
		
		navCell.getStepsToChargeStation().add(Direction.WEST);
		navCell.getStepsToChargeStation().add(Direction.EAST);
		navCell.getStepsToChargeStation().add(Direction.SOUTH);
		navCell.getStepsToChargeStation().add(Direction.NORTH);
		
		NavigationCell newNav = new NavigationCell(2,2,2);
		newNav.buildDirectionsToChargingStation(navCell, Direction.NORTH);
		
		ArrayList<Direction> _dir = newNav.getStepsToChargeStation();
		
		assertEquals(_dir.get(0), Direction.SOUTH);
		assertEquals(_dir.get(1), Direction.WEST);
		assertEquals(_dir.get(2), Direction.EAST);
		assertEquals(_dir.get(3), Direction.SOUTH);
		assertEquals(_dir.get(4), Direction.NORTH);
	}
	
	@Test
	public void equalsTest(){
		
		NavigationCell testCell1 = new NavigationCell(1,1,1);
		NavigationCell testCell2 = new NavigationCell(2,2,2);
		
		assertFalse(testCell1.equals(testCell2));
		
		NavigationCell testCell3 = new NavigationCell(1,1,1);
		NavigationCell testCell4 = new NavigationCell(1,1,1);
		
		assertTrue(testCell3.equals(testCell4));
	}
	
	@Test
	public void adjacentCellTest(){
		
		NavigationCell navCell = new NavigationCell(1,1,1);
		FloorNavigationProxy floorNavProxy = new FloorNavigationProxy("TEST_C.cft");
		Location currentLocation = floorNavProxy.getStaringLocation();
		
		if(floorNavProxy.canMove(currentLocation, Direction.SOUTH)){
			navCell.getAdjacentList().add(Direction.SOUTH);
		}
		if(floorNavProxy.canMove(currentLocation, Direction.EAST)){
			navCell.getAdjacentList().add(Direction.EAST);
		}
		if(floorNavProxy.canMove(currentLocation, Direction.NORTH)){
			navCell.getAdjacentList().add(Direction.NORTH);
		}
		if(floorNavProxy.canMove(currentLocation, Direction.WEST)){
			navCell.getAdjacentList().add(Direction.WEST);
		}
		assertEquals(navCell.getAdjacentList().get(0),Direction.NORTH);
		assertEquals(navCell.getAdjacentList().get(1),Direction.WEST);
	}
}
