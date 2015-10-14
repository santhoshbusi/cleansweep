package edu.cleansweep.floor;

public class FloorTest {

	public static void main(String[] args)
	{		
		Floor f = new Floor();
		f.createDefaultFloorPlan();
		System.out.println(f.toString());
		
		
		System.out.println(f.queryCellAt(0,7));
		System.out.println(f.markCellAt(0,7));
		System.out.println(f.visitAllCells());
		
	}
}
