package edu.cleansweep.simulator.floor;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.cleansweep.simulator.floor.*;

public class FloorSimulatorTest {

	@Test
	public void testFloorSimulator() {
		//Setup
		FloorSimulator ds = new FloorSimulator();
		
		assertNotNull(ds);

	}

	@Test
	public void testGetBareFloorState() {
	
		FloorSimulator ds = new FloorSimulator();
        HighPileState hds = new HighPileState(ds);
        
		assertEquals(ds.getCurrentState(), ds.getBareFloorState());
        ds.setHighPileState(hds);
		ds.setCurrentState(hds);
		assertEquals(ds.getCurrentState(), ds.getHighPileState());
	
	}

	@Test
	public void testSetBareFloorState() {

		FloorSimulator ds = new FloorSimulator();
        BareFloorState hds = new BareFloorState(ds);
        
		assertEquals(ds.getCurrentState(), ds.getBareFloorState());

		ds.setBareFloorState(hds);
		ds.setCurrentState(hds);
		
		assertEquals(ds.getCurrentState(), ds.getBareFloorState());

	}

	@Test
	public void testGetLowPileState() {

		FloorSimulator ds = new FloorSimulator();
        LowPileState hds = new LowPileState(ds);
        
		ds.setLowPileState(hds);
		ds.setCurrentState(hds);
		ds.getCurrentState().SwitchHighPile();
		assertEquals(ds.getCurrentState(), ds.getHighPileState());
		ds.setCurrentState(hds);
		assertEquals(ds.getCurrentState(), ds.getLowPileState());

	}

	@Test
	public void testSetLowPileState() {
		
		FloorSimulator ds = new FloorSimulator();
        LowPileState hds = new LowPileState(ds);
        
		ds.setLowPileState(hds);
		ds.setCurrentState(hds);
				
		assertEquals(ds.getCurrentState(), ds.getLowPileState());

		
	}

	@Test
	public void testGetHighPileState() {

		FloorSimulator ds = new FloorSimulator();
        HighPileState hds = new HighPileState(ds);
        
		ds.setHighPileState(hds);
		ds.setCurrentState(hds);
		
		ds.setCurrentState(hds);
		assertEquals(ds.getCurrentState(), ds.getHighPileState());


	}


}
