package edu.cleansweep.floor;

/**
 * Direction relative to current ICell position, 
 * ordered in clockwise starting from North
 * <li>{@link #NORTH}</li>
 * <li>{@link #NORTHEAST}</li>
 * <li>{@link #EAST}</li>
 * <li>{@link #SOUTHEAST}</li>
 * <li>{@link #SOUTH}</li>
 * <li>{@link #SOUTHWEST}</li>
 * <li>{@link #WEST}</li>
 * <li>{@link #NORTHWEST}</li>
 * @author ajscilingo
 */
public enum Direction {
	/**
	 * Direction North relative of current position
	 */
	NORTH {
		@Override
		public Direction getOpposite() {
			return SOUTH;
		}
		
		@Override
		public String toString() {
			return "North";
		}
	}, 
	/**
	 * Direction North East relative of current position
	 */
	NORTHEAST {
		@Override
		public Direction getOpposite() {
			return SOUTHWEST;
		}
		
		@Override
		public String toString() {
			return "North East";
		}
	}, 
	/**
	 * Direction East relative of current position
	 */
	EAST {
		@Override
		public Direction getOpposite() {
			return WEST;
		}
		
		@Override
		public String toString() {
			return "East";
		}
	}, 
	/**
	 * Direction South East relative of current position 
	 */
	SOUTHEAST {
		@Override
		public Direction getOpposite() {
			return NORTHWEST;
		}
		
		@Override
		public String toString() {
			return "South East";
		}
	}, 
	/**
	 * Direction South relative of current position 
	 */
	SOUTH {
		@Override
		public Direction getOpposite() {
			return NORTH;
		}
		
		@Override
		public String toString() {
			return "South";
		}
	}, 
	/**
	 * Direction South West relative of current position
	 */
	SOUTHWEST {
		@Override
		public Direction getOpposite() {
			return NORTHEAST;
		}
		
		@Override
		public String toString() {
			return "South West";
		}
	}, 
	/**
	 * Direction West relative of current position
	 */
	WEST {
		@Override
		public Direction getOpposite() {
			return EAST;
		}
		
		@Override
		public String toString() {
			return "West";
		}
	}, 
	/**
	 * Direction North West relative of current position
	 */
	NORTHWEST {
		@Override
		public Direction getOpposite() {
			return SOUTHEAST;
		}
		
		@Override
		public String toString() {
			return "North West";
		}
	};
	
	public abstract Direction getOpposite();
}
