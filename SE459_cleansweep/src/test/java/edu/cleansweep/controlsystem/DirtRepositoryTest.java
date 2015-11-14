package edu.cleansweep.controlsystem;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class DirtRepositoryTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testMax() {
		assertEquals(50, DirtRepository.MAXIMUM);
	}
	
	@Test
	public void testAddDirtMax() {
		DirtRepository dr = new DirtRepository();
		assertFalse(dr.getIsFullStatus());
		assertEquals(0, dr.getCurrentDirt());
		
		dr.setCurrentDirt(49);
		dr.addDirt();
		assertEquals(50, dr.getCurrentDirt());
		
		dr.addDirt();
		assertEquals(50, dr.getCurrentDirt());
		dr.setIsFullStatus(true);
		assertTrue(dr.getIsFullStatus());
	}

}
