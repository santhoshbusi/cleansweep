package edu.cleansweep.controlsystem;

public class ControlSystemDriver {

	/**
	 * This method is the driver of the control system.  The constructor can read in
	 * any of the below file names:
	 * TEST_A.cft
	 * TEST_B.cft
	 * TEST_C.cft
	 * TEST_D.cft
	 * TEST_E.cft
	 * 
	 */
	
    public static void main(String [] args)
	{
		ControlSystem cs = new ControlSystem("TEST_A.cft");
		cs.start();
		cs.printCleaningCycleStats();
	}
}
