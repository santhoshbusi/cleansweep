package edu.cleansweep.floor;
/**
 * Floor Type related to each non-obstacle class that implements ICell
 * <li>{@link #BAREFLOOR}</li>
 * <li>{@link #LOWPILECARPET}</li>
 * <li>{@link #HIGHPILECARPET}</li>
 * <li>{@link #CHARGINGSTATION}</li>
 * <li>{@link #DOOR}</li>
 * @author ajscilingo
 *
 */
public enum FloorType {

	/**
	 * Corresponds to a BareFloorCell
	 */
	BAREFLOOR{
		@Override
		public String toString() {
			return "Bare Floor";
		}
	},
	
	/**
	 * Corresponds to a LowPileCarpetCell
	 */
	LOWPILECARPET{
		@Override
		public String toString() {
			return "Low Pile Carpet";
		}
	},
	
	/**
	 * Corresponds to HighPileCarpetCell
	 */
	HIGHPILECARPET{
		@Override
		public String toString(){
			return "High Pile Carpet";
		}
	},
	
	/**
	 * Corresponds to ChargingStationCell
	 */
	CHARGINGSTATION{
		@Override
		public String toString(){
			return "Charing Station";
		}
	},
	
	/**
	 * Corresponds to DoorCell
	 */
	DOOR{
		@Override
		public String toString() {
			return "Door";
		}
	},
	
	/**
	 * Corresponds to Obstacle / Other floor type
	 */
	OBSTACLE{
		@Override
		public String toString(){
			return "Obstacle";
		}
	}
}
