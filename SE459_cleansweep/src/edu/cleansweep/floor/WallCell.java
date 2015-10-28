package edu.cleansweep.floor;

class WallCell extends ObstacleCell {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4972611435295777664L;

	WallCell(int x, int y){
		super(x,y);
		_grade = 100;
	}
	
	@Override
	public String toString() {
		return "W";
	}
}
