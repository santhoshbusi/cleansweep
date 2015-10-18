package edu.cleansweep.floor;

class StairsCell extends ObstacleCell {
	
	public StairsCell(int x, int y) {
		super(x, y);
	}

	@Override
	public String getType() {
		return "Stairs";
	}

	
	@Override
	public String toString() {
		return "S";
	}
}
