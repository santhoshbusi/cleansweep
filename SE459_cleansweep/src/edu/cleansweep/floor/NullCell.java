package edu.cleansweep.floor;

public class NullCell extends ObstacleCell {

	public NullCell(int x, int y){
		super(x,y);
	}
	
	@Override
	public int getCellGrade() {
		return -1;
	}

	@Override
	public String getType() {
		return "";
	}
	
	@Override
	public String toString() {
		return "";
	}
	
}
