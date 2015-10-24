package edu.cleansweep.simulator.power;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimulateSignalTest {


	@Test
	public void testSimulateSignal() {
		//setup
		PowerStationSimulator dt = new PowerStationSimulator();
		assertNotNull(dt);

	}

	@Test
	public void testNotsimulateSignal() {
		
		PowerStationSimulator dt = new PowerStationSimulator();
	
		assertEquals(dt.getCurrentOutput(), dt.getDontSimulateSignal());

		//switch to emitting signal
		dt.getCurrentOutput().simulateSignal();
		
		dt.getCurrentOutput().printCurrentSignal();

		assertEquals(dt.getCurrentOutput(), dt.getSimulateSignal());

		//set to Not emitting signal
		dt.getCurrentOutput().dontsimulateSignal();
		
		assertEquals(dt.getCurrentOutput(), dt.getDontSimulateSignal());
				
		//print current output
		dt.getCurrentOutput().printCurrentSignal();

	}

	
	
}
