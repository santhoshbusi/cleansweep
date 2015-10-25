package edu.cleansweep.floor;

import java.io.Serializable;

/**
 * Used for SensorSimulator to communicate with the Control System
 * @author ajscilingo
 *
 */
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2740888408196155222L;
	private String _operation;
	private Location _location;
	private Direction _direction;
	
	public Message(String operation, Location location){
		_operation = operation;
		_location = location;
	}
	
	public Message(String operation, Location location, Direction direction){
		_operation = operation;
		_location = location;
		_direction = direction;
	}

	public String get_operation() {
		return _operation;
	}

	public void set_operation(String _operation) {
		this._operation = _operation;
	}

	public Location get_location() {
		return _location;
	}

	public void set_location(Location _location) {
		this._location = _location;
	}

	public Direction get_direction() {
		return _direction;
	}

	public void set_direction(Direction _direction) {
		this._direction = _direction;
	}
}
