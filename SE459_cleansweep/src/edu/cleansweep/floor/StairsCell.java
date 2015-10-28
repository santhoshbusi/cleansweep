package edu.cleansweep.floor;

class StairsCell extends ObstacleCell {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4611270758216130688L;

	public StairsCell(int x, int y) {
		super(x, y);
		_grade = -100;
	}
	
	@Override
	public String toString() {
		return "S";
	}
}
