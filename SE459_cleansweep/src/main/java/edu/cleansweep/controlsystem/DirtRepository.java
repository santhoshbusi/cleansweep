package edu.cleansweep.controlsystem;

public class DirtRepository {
	
	public final static int MAXIMUM = 50;
	
	private int currentDirt;
	private boolean isFull;
	
	public DirtRepository(){
		currentDirt = 0;
		isFull = false;
	}

	public int getCurrentDirt() {
		return currentDirt;
	}

	public void setCurrentDirt(int currentDirt) {
		this.currentDirt = currentDirt;
	}
	
	public void addDirt(){
		if(currentDirt < 50){
			this.currentDirt++;
		}
	}
	
	public boolean getIsFullStatus(){
		return isFull;
	}
	
	public void setIsFullStatus(boolean _status){
		isFull = _status;
	}
}
