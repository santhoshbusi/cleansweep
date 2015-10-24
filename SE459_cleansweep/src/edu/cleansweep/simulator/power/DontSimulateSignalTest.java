package edu.cleansweep.simulator.power;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DontSimulateSignalTest {


	@Test
	public void testDontSimulateSignal() {
		//setup
		PowerStationSimulator dt = new PowerStationSimulator();
		assertNotNull(dt);

	}

	@Test
	public void testsimulateSignal() {
		
		PowerStationSimulator dt = new PowerStationSimulator();
	
		assertEquals(dt.getCurrentOutput(), dt.getDontSimulateSignal());

		//switch to emitting signal
		dt.getCurrentOutput().simulateSignal();

		assertEquals(dt.getCurrentOutput(), dt.getSimulateSignal());

		//set to Not emitting signal
		dt.setCurrentOutput(dt.getDontSimulateSignal());
		
		
		assertEquals(dt.getCurrentOutput(), dt.getDontSimulateSignal());
		//print current output
		dt.getCurrentOutput().printCurrentSignal();

	}

	
	
}
