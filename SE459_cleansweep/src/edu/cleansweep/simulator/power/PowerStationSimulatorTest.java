package edu.cleansweep.simulator.power;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PowerStationSimulatorTest {


	@Test
	public void testPowerStationSimulator() {

		PowerStationSimulator dt = new PowerStationSimulator();
		assertNotNull(dt);
	
	}

	@Test
	public void testSetStationSimulator() {

		PowerStationSimulator dt = new PowerStationSimulator();

		//set current state to Not emitting signal
		dt.setDontSimulateSignal(dt.getDontSimulateSignal());
		dt.getCurrentOutput().printCurrentSignal();
		
		//set current state to emitting signal
		dt.setCurrentOutput(dt.getSimulateSignal());
		dt.getCurrentOutput().printCurrentSignal();
		
		//swith to not emitting signal
		dt.getCurrentOutput().dontsimulateSignal();
		
		dt.getCurrentOutput().printCurrentSignal();
	
		//swith to emitting signal
		dt.getCurrentOutput().simulateSignal();
		dt.getCurrentOutput().printCurrentSignal();
		
		
	}


}
