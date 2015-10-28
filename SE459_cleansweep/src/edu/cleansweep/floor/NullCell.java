package edu.cleansweep.floor;

class NullCell extends ObstacleCell {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8539707092328881786L;

	public NullCell(int x, int y){
		super(x,y);
		_grade = -1000;
	}

	@Override
	public FloorType getFloorType() {
		return FloorType.OBSTACLE;
	}
	
	@Override
	public String toString() {
		return "-";
	}
	
}
