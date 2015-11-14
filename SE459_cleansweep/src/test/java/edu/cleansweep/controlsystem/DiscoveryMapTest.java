package edu.cleansweep.controlsystem;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Test;

import edu.cleansweep.controlsystem.DiscoveryMap;
import edu.cleansweep.controlsystem.NavigationCell;
import edu.cleansweep.floor.Location;

public class DiscoveryMapTest {

	@Test
	public void ConstructorTest(){
		
		DiscoveryMap dm = new DiscoveryMap();
		assertNotNull(dm);
		
		assertNotNull(dm.getNavigationCells());
	}
	
	@Test
	public void addListTest(){
		
		DiscoveryMap dm = new DiscoveryMap();
		NavigationCell navCell1 = new NavigationCell(1,1,1);
		NavigationCell navCell2 = new NavigationCell(2,2,2);
		
		dm.addToMap(navCell1);
		dm.addToMap(navCell2);
		assertEquals(2, dm.getNavigationCells().size());
		
		//try to add existing nav cell
		dm.addToMap(navCell1);
		assertEquals(2, dm.getNavigationCells().size());
		
		//try to add new nav cell with existing coordinates (add should fail)
		dm.addToMap(new NavigationCell(1,1,1));
		assertEquals(2, dm.getNavigationCells().size());
	}
	
	@Test
	public void addWithCreationTest(){
		
		DiscoveryMap dm = new DiscoveryMap();
		assertEquals(0, dm.getNavigationCells().size());
		
		dm.addNewNavigationCell(1, 1, 1);
		assertEquals(1, dm.getNavigationCells().size());
		
		//confirm this method won't add duplicates
		dm.addNewNavigationCell(1, 1, 1);
		assertEquals(1, dm.getNavigationCells().size());
		
		dm.addNewNavigationCell(1, 2, 1);
		assertEquals(2, dm.getNavigationCells().size());
	}
	
	@Test
	public void checkMapTest(){
		
		DiscoveryMap dm = new DiscoveryMap();
		NavigationCell navCell = new NavigationCell(1,1,1);
		
		//Check using Nav Cell Object
		dm.addToMap(navCell);
		assertTrue(dm.checkMap(navCell));
		
		NavigationCell navCell2 = new NavigationCell(2,2,2);
		assertFalse(dm.checkMap(navCell2));
		
		//Check using Coordinates
		assertTrue(dm.checkMap(1,1));
		assertFalse(dm.checkMap(3,3));
	}
	
	@Test
	public void checkMaxNavLayer(){
		DiscoveryMap dm = new DiscoveryMap();
		NavigationCell navCell = new NavigationCell(1,1,1);
		
		dm.addToMap(navCell);
		assertEquals(1, dm.getMaxNavLayer());
		
		//add new higher layer nav
		dm.addNewNavigationCell(5, 5, 5);
		assertEquals(5, dm.getMaxNavLayer());
		
		//add new but lesser nav layer
		dm.addNewNavigationCell(4,4,4);
		assertEquals(5, dm.getMaxNavLayer());
	}
	
	@Test
	public void topLayerListTest(){
		
		DiscoveryMap dm = new DiscoveryMap();
		dm.addNewNavigationCell(0, 0, 0);
		dm.addNewNavigationCell(1, 1, 1);
		dm.addNewNavigationCell(2, 2, 1);
		dm.addNewNavigationCell(3, 3, 1);
		
		for(NavigationCell navCell: dm.getTopLayerCells()){
			assertEquals(1, navCell.getNavLayer());
		}
		
		dm.addNewNavigationCell(4, 4, 4);
		dm.addNewNavigationCell(5, 5, 5);
		
		for(NavigationCell navCell: dm.getTopLayerCells()){
			assertEquals(5, navCell.getNavLayer());
		}
	}
	
	@Test
	public void getNavigationCellTest(){
		
		DiscoveryMap dm = new DiscoveryMap();
		dm.addNewNavigationCell(1, 1, 1);
		
		NavigationCell navCell = dm.get(1, 1);
		assertEquals(1, navCell.getX());
		assertEquals(1, navCell.getY());
		assertEquals(1, navCell.getNavLayer());
	}
	
	@Test
	public void getFullListTest(){
		
		DiscoveryMap dm = new DiscoveryMap();
		dm.addNewNavigationCell(0, 0, 0);
		dm.addNewNavigationCell(1, 1, 1);
		dm.addNewNavigationCell(2, 2, 1);
		dm.addNewNavigationCell(3, 3, 1);
		
		ArrayList<NavigationCell> list = dm.getNavigationCells();
		assertEquals(4, list.size());
	}
	
	@Test
	public void countDirtyCellsTest(){
		
		DiscoveryMap dm = new DiscoveryMap();
		
		NavigationCell navCell1 = new NavigationCell(1,1,1);
		dm.addToMap(navCell1);
		navCell1.setCleanedLastVisit(true);
		
		NavigationCell navCell2 = new NavigationCell(2,2,2);
		navCell2.setCleanedLastVisit(true);
		dm.addToMap(navCell2);
		
		NavigationCell navCell3 = new NavigationCell(3,3,3);
		navCell3.setCleanedLastVisit(false);
		dm.addToMap(navCell3);
		
		assertEquals(2, dm.countDirtyCells());
		
		navCell2.setCleanedLastVisit(false);
		assertEquals(1, dm.countDirtyCells());
		
		navCell1.setCleanedLastVisit(false);
		assertEquals(0, dm.countDirtyCells());
		
		navCell1.setCleanedLastVisit(true);
		assertEquals(1, dm.countDirtyCells());
	}
	
	@Test
	public void dirtyCellsRemainTest(){
		
		DiscoveryMap dm = new DiscoveryMap();
		
		NavigationCell navCell1 = new NavigationCell(1,1,1);
		dm.addToMap(navCell1);
		navCell1.setCleanedLastVisit(true);
		
		NavigationCell navCell2 = new NavigationCell(2,2,2);
		navCell2.setCleanedLastVisit(true);
		dm.addToMap(navCell2);
		
		NavigationCell navCell3 = new NavigationCell(3,3,3);
		navCell3.setCleanedLastVisit(false);
		dm.addToMap(navCell3);
		
		assertTrue(dm.dirtyCellsRemain());
		
		navCell1.setCleanedLastVisit(false);
		navCell2.setCleanedLastVisit(false);
		
		assertFalse(dm.dirtyCellsRemain());
	}
}
