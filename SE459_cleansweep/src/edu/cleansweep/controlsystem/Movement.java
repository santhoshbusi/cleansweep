package edu.cleansweep.controlsystem;

import edu.cleansweep.floor.*;

public interface Movement {

	public Location executeMove(Location _location, Direction _direction);
}
