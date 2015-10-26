package edu.cleansweep.floor;

class NullCell extends ObstacleCell {

	public NullCell(int x, int y){
		super(x,y);
	}
	
	@Override
	public int getCellGrade() {
		return -1;
	}

	@Override
	public String getType() {
		return "Null Cell";
	}
	
	@Override
	public String toString() {
		return "-";
	}
	
}
