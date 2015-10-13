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
	}, 
	/**
	 * Direction North East relative of current position
	 */
	NORTHEAST {
		@Override
		public Direction getOpposite() {
			return SOUTHWEST;
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
	}, 
	/**
	 * Direction South East relative of current position 
	 */
	SOUTHEAST {
		@Override
		public Direction getOpposite() {
			return NORTHWEST;
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
	}, 
	/**
	 * Direction South West relative of current position
	 */
	SOUTHWEST {
		@Override
		public Direction getOpposite() {
			return NORTHEAST;
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
	}, 
	/**
	 * Direction North West relative of current position
	 */
	NORTHWEST {
		@Override
		public Direction getOpposite() {
			return SOUTHEAST;
		}
	};
	
	public abstract Direction getOpposite();
}
