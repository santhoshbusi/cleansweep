package edu.cleansweep.floor;

class WallCell extends ObstacleCell {
	
	public WallCell(int x, int y){
		super(x,y);
	}
	
	@Override
	public int getCellGrade() {
		return 100;
	}

	@Override
	public String getType() {
		return "Wall";
	}
	
	@Override
	public String toString() {
		return "W";
	}
}
