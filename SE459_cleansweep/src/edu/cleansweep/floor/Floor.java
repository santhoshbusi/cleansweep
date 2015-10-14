package edu.cleansweep.floor;

public class Floor {

	private ICell[][] _floor;
	private ICell _startingCell;
	
	public Floor(){
		_floor = new ICell[17][18];
	}
	
	public void placeCellAt(int x, int y, ICell cell)
	{
		if(x > _floor.length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else if(y > _floor[0].length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else{
			_floor[x][y] = cell;
		}
			
	}
	
	public String queryCellAt(int x, int y){
		
		StringBuilder sb = new StringBuilder();
		sb.append("Location: (").append(x).append(",").append(y).append(")").append("\n");
		sb.append("Cell Type: ").append(_floor[x][y].getType()).append("\n");
		sb.append("Grade: ").append(_floor[x][y].getCellGrade()).append("\n");
		sb.append("Dirty?: ").append(!_floor[x][y].isClean()).append("\n");
		sb.append("Obstructed?: ").append(_floor[x][y].isObstructed()).append("\n");
		sb.append("AdjacentCells:\n");
		sb.append(printAdjacentCells(_floor[x][y]));
		return sb.toString();
	}
	
	public String printAdjacentCells(ICell cell){
		
		StringBuilder sb = new StringBuilder();
		
		if(cell != null)
		{
			ICell northCell = cell.getAdjacentCell(Direction.NORTH);
			ICell northEastCell = cell.getAdjacentCell(Direction.NORTHEAST);
			ICell eastCell = cell.getAdjacentCell(Direction.EAST);
			ICell southEastCell = cell.getAdjacentCell(Direction.SOUTHEAST);
			ICell southCell = cell.getAdjacentCell(Direction.SOUTH);
			ICell southWestCell = cell.getAdjacentCell(Direction.SOUTHWEST);
			ICell westCell = cell.getAdjacentCell(Direction.WEST);
			ICell northWestCell = cell.getAdjacentCell(Direction.NORTHWEST);
			
			if(northWestCell != null)
				sb.append(northWestCell.toString());
			else
				sb.append("-");
			
			if(northCell != null)
				sb.append(northCell.toString());
			else
				sb.append("-");
			
			if(northEastCell != null)
				sb.append(northEastCell.toString());
			else
				sb.append("-");
			
			// always print new line here
			sb.append("\n");
			
			if(westCell != null)
				sb.append(westCell.toString());
			else
				sb.append("-");
			
			// always print parent cell
			sb.append("*");
			
			if(eastCell != null)
				sb.append(eastCell.toString());
			else
				sb.append("-");
			
			// always print new line here
			sb.append("\n");
			
			if(southWestCell != null)
				sb.append(southWestCell.toString());
			else
				sb.append("-");
			
			if(southCell != null)
				sb.append(southCell.toString());
			else
				sb.append("-");
			
			if(southEastCell != null)
				sb.append(southEastCell.toString());
			else
				sb.append("-");
			
		}
		return sb.toString();
	}
	
	public String markCellAt(int x, int y){
		StringBuilder sb = new StringBuilder();
		for(int xi=0; xi<_floor.length; xi++){
			for(int yi=0; yi<_floor[0].length; yi++){
				if(xi == y && yi == x)
					sb.append("* ");
				else
					sb.append(_floor[xi][yi].toString()).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public String visitAllCells(){
		StringBuilder sb = new StringBuilder();
		for(int x=0; x<_floor.length; x++){
			for(int y=0; y<_floor[0].length; y++){
				sb.append(queryCellAt(x, y)).append("\n").append(markCellAt(y,x)).append("\n");
			}
		}
		return sb.toString();
	}
	
	public void createDefaultFloorPlan() {
		
		//Left Most Column Of Floor Plan
		placeCellAt(0,0, new WallCell());
		placeCellAt(0,1, new WallCell());
		placeCellAt(0,2, new WallCell());
		placeCellAt(0,3, new WallCell());
		placeCellAt(0,4, new WallCell());
		placeCellAt(0,5, new WallCell());
		placeCellAt(0,6, new WallCell());
		placeCellAt(0,7, new WallCell());
		placeCellAt(0,8, new WallCell());
		placeCellAt(0,9, new WallCell());
		placeCellAt(0,10, new WallCell());
		placeCellAt(0,11, new WallCell());
		placeCellAt(0,12, new WallCell());
		placeCellAt(0,13, new WallCell());
		placeCellAt(0,14, new WallCell());
		placeCellAt(0,15, new WallCell());
		placeCellAt(0,16, new WallCell());
		placeCellAt(0,17, new WallCell());
		
		//Left Most Column of Flooring
		placeCellAt(1,0, new WallCell());
		placeCellAt(1,1, new LowPileCarpetCell());
		placeCellAt(1,2, new LowPileCarpetCell());
		placeCellAt(1,3, new LowPileCarpetCell());
		placeCellAt(1,4, new LowPileCarpetCell());
		placeCellAt(1,5, new LowPileCarpetCell());
		placeCellAt(1,6, new LowPileCarpetCell());
		placeCellAt(1,7, new WallCell());
		placeCellAt(1,8, new BareFloorCell());
		placeCellAt(1,9, new WallCell());
		placeCellAt(1,10, new BareFloorCell());
		placeCellAt(1,11, new DoorCell());
		placeCellAt(1,12, new LowPileCarpetCell());
		placeCellAt(1,13, new LowPileCarpetCell());
		placeCellAt(1,14, new LowPileCarpetCell());
		placeCellAt(1,15, new LowPileCarpetCell());
		placeCellAt(1,16, new LowPileCarpetCell());
		placeCellAt(1,17, new WallCell());
		
		//Left Most Column + 1 of Flooring
		placeCellAt(2,0, new WallCell());
		placeCellAt(2,1, new LowPileCarpetCell());
		placeCellAt(2,2, new LowPileCarpetCell());
		placeCellAt(2,3, new LowPileCarpetCell());
		placeCellAt(2,4, new LowPileCarpetCell());
		placeCellAt(2,5, new LowPileCarpetCell());
		placeCellAt(2,6, new LowPileCarpetCell());
		placeCellAt(2,7, new WallCell());
		placeCellAt(2,8, new BareFloorCell());
		placeCellAt(2,9, new WallCell());
		placeCellAt(2,10, new BareFloorCell());
		placeCellAt(2,11, new WallCell());
		placeCellAt(2,12, new LowPileCarpetCell());
		placeCellAt(2,13, new LowPileCarpetCell());
		placeCellAt(2,14, new LowPileCarpetCell());
		placeCellAt(2,15, new LowPileCarpetCell());
		placeCellAt(2,16, new LowPileCarpetCell());
		placeCellAt(2,17, new WallCell());
		
		//Left Most Column + 2 of Flooring
		placeCellAt(3,0, new WallCell());
		placeCellAt(3,1, new LowPileCarpetCell());
		placeCellAt(3,2, new LowPileCarpetCell());
		placeCellAt(3,3, new LowPileCarpetCell());
		placeCellAt(3,4, new LowPileCarpetCell());
		placeCellAt(3,5, new LowPileCarpetCell());
		placeCellAt(3,6, new LowPileCarpetCell());
		placeCellAt(3,7, new WallCell());
		placeCellAt(3,8, new BareFloorCell());
		placeCellAt(3,9, new WallCell());
		placeCellAt(3,10, new WallCell());
		placeCellAt(3,11, new WallCell());
		placeCellAt(3,12, new LowPileCarpetCell());
		placeCellAt(3,13, new LowPileCarpetCell());
		placeCellAt(3,14, new LowPileCarpetCell());
		placeCellAt(3,15, new LowPileCarpetCell());
		placeCellAt(3,16, new LowPileCarpetCell());
		placeCellAt(3,17, new WallCell());
		
		//Left Most Column + 3 of Flooring
		placeCellAt(4,0, new WallCell());
		placeCellAt(4,1, new LowPileCarpetCell());
		placeCellAt(4,2, new LowPileCarpetCell());
		placeCellAt(4,3, new LowPileCarpetCell());
		placeCellAt(4,4, new LowPileCarpetCell());
		placeCellAt(4,5, new LowPileCarpetCell());
		placeCellAt(4,6, new LowPileCarpetCell());
		placeCellAt(4,7, new WallCell());
		placeCellAt(4,8, new BareFloorCell());
		placeCellAt(4,9, new WallCell());
		placeCellAt(4,10, new BareFloorCell());
		placeCellAt(4,11, new WallCell());
		placeCellAt(4,12, new LowPileCarpetCell());
		placeCellAt(4,13, new LowPileCarpetCell());
		placeCellAt(4,14, new LowPileCarpetCell());
		placeCellAt(4,15, new LowPileCarpetCell());
		placeCellAt(4,16, new LowPileCarpetCell());
		placeCellAt(4,17, new WallCell());

		//Left Most Column + 4 of Flooring
		placeCellAt(5,0, new WallCell());
		placeCellAt(5,1, new LowPileCarpetCell());
		placeCellAt(5,2, new LowPileCarpetCell());
		placeCellAt(5,3, new LowPileCarpetCell());
		placeCellAt(5,4, new LowPileCarpetCell());
		placeCellAt(5,5, new LowPileCarpetCell());
		placeCellAt(5,6, new LowPileCarpetCell());
		placeCellAt(5,7, new WallCell());
		placeCellAt(5,8, new BareFloorCell());
		placeCellAt(5,9, new WallCell());
		placeCellAt(5,10, new BareFloorCell());
		placeCellAt(5,11, new WallCell());
		placeCellAt(5,12, new LowPileCarpetCell());
		placeCellAt(5,13, new LowPileCarpetCell());
		placeCellAt(5,14, new LowPileCarpetCell());
		placeCellAt(5,15, new LowPileCarpetCell());
		placeCellAt(5,16, new LowPileCarpetCell());
		placeCellAt(5,17, new WallCell());
		
		//Left Most Column + 5 of Flooring
		placeCellAt(6,0, new WallCell());
		placeCellAt(6,1, new WallCell());
		placeCellAt(6,2, new WallCell());
		placeCellAt(6,3, new WallCell());
		placeCellAt(6,4, new DoorCell());
		placeCellAt(6,5, new WallCell());
		placeCellAt(6,6, new WallCell());
		placeCellAt(6,7, new WallCell());
		placeCellAt(6,8, new DoorCell());
		placeCellAt(6,9, new WallCell());
		placeCellAt(6,10, new DoorCell());
		placeCellAt(6,11, new WallCell());
		placeCellAt(6,12, new DoorCell());
		placeCellAt(6,13, new WallCell());
		placeCellAt(6,14, new WallCell());
		placeCellAt(6,15, new WallCell());
		placeCellAt(6,16, new WallCell());
		placeCellAt(6,17, new WallCell());
		
		//Left Most Column + 6 of Flooring
		placeCellAt(7,0, new StairsCell());
		placeCellAt(7,1, new BareFloorCell());
		placeCellAt(7,2, new BareFloorCell());
		placeCellAt(7,3, new BareFloorCell());
		placeCellAt(7,4, new BareFloorCell());
		placeCellAt(7,5, new BareFloorCell());
		placeCellAt(7,6, new BareFloorCell());
		placeCellAt(7,7, new BareFloorCell());
		placeCellAt(7,8, new BareFloorCell());
		placeCellAt(7,9, new BareFloorCell());
		placeCellAt(7,10, new BareFloorCell());
		placeCellAt(7,11, new BareFloorCell());
		placeCellAt(7,12, new BareFloorCell());
		placeCellAt(7,13, new DoorCell());
		placeCellAt(7,14, new BareFloorCell());
		placeCellAt(7,15, new WallCell());
		placeCellAt(7,16, new BareFloorCell());
		placeCellAt(7,17, new WallCell());
		
		//Left Most Column + 7 of Flooring
		placeCellAt(8,0, new WallCell());
		placeCellAt(8,1, new BareFloorCell());
		placeCellAt(8,2, new BareFloorCell());
		placeCellAt(8,3, new BareFloorCell());
		placeCellAt(8,4, new BareFloorCell());
		placeCellAt(8,5, new BareFloorCell());
		placeCellAt(8,6, new BareFloorCell());
		placeCellAt(8,7, new BareFloorCell());
		placeCellAt(8,8, new BareFloorCell());
		placeCellAt(8,9, new BareFloorCell());
		placeCellAt(8,10, new BareFloorCell());
		placeCellAt(8,11, new BareFloorCell());
		placeCellAt(8,12, new BareFloorCell());
		placeCellAt(8,13, new WallCell());
		placeCellAt(8,14, new BareFloorCell());
		placeCellAt(8,15, new WallCell());
		placeCellAt(8,16, new BareFloorCell());
		placeCellAt(8,17, new WallCell());
		
		//Right Most Column - 7 of Flooring
		placeCellAt(9,0, new WallCell());
		placeCellAt(9,1, new WallCell());
		placeCellAt(9,2, new WallCell());
		placeCellAt(9,3, new WallCell());
		placeCellAt(9,4, new WallCell());
		placeCellAt(9,5, new WallCell());
		placeCellAt(9,6, new WallCell());
		placeCellAt(9,7, new WallCell());
		placeCellAt(9,8, new WallCell());
		placeCellAt(9,9, new WallCell());
		placeCellAt(9,10, new WallCell());
		placeCellAt(9,11, new DoorCell());
		placeCellAt(9,12, new WallCell());
		placeCellAt(9,13, new WallCell());
		placeCellAt(9,14, new WallCell());
		placeCellAt(9,15, new WallCell());
		placeCellAt(9,16, new BareFloorCell());
		placeCellAt(9,17, new WallCell());
		
		//Right Most Column - 6 of Flooring
		placeCellAt(10,0, new WallCell());
		placeCellAt(10,1, new BareFloorCell());
		placeCellAt(10,2, new BareFloorCell());
		placeCellAt(10,3, new BareFloorCell());
		placeCellAt(10,4, new BareFloorCell());
		placeCellAt(10,5, new BareFloorCell());
		placeCellAt(10,6, new BareFloorCell());
		placeCellAt(10,7, new BareFloorCell());
		placeCellAt(10,8, new BareFloorCell());
		placeCellAt(10,9, new BareFloorCell());
		placeCellAt(10,10, new BareFloorCell());
		placeCellAt(10,11, new BareFloorCell());
		placeCellAt(10,12, new BareFloorCell());
		placeCellAt(10,13, new BareFloorCell());
		placeCellAt(10,14, new BareFloorCell());
		placeCellAt(10,15, new DoorCell());
		placeCellAt(10,16, new BareFloorCell());
		placeCellAt(10,17, new WallCell());
		
		//Right Most Column - 5 of Flooring
		placeCellAt(11,0, new WallCell());
		placeCellAt(11,1, new BareFloorCell());
		placeCellAt(11,2, new HighPileCarpetCell());
		placeCellAt(11,3, new HighPileCarpetCell());
		placeCellAt(11,4, new HighPileCarpetCell());
		placeCellAt(11,5, new HighPileCarpetCell());
		placeCellAt(11,6, new HighPileCarpetCell());
		placeCellAt(11,7, new BareFloorCell());
		placeCellAt(11,8, new BareFloorCell());
		placeCellAt(11,9, new BareFloorCell());
		placeCellAt(11,10, new BareFloorCell());
		placeCellAt(11,11, new BareFloorCell());
		placeCellAt(11,12, new BareFloorCell());
		placeCellAt(11,13, new BareFloorCell());
		placeCellAt(11,14, new BareFloorCell());
		placeCellAt(11,15, new WallCell());
		placeCellAt(11,16, new BareFloorCell());
		placeCellAt(11,17, new WallCell());
		
		//Right Most Column - 4 of Flooring
		placeCellAt(12,0, new WallCell());
		placeCellAt(12,1, new BareFloorCell());
		placeCellAt(12,2, new HighPileCarpetCell());
		placeCellAt(12,3, new HighPileCarpetCell());
		placeCellAt(12,4, new HighPileCarpetCell());
		placeCellAt(12,5, new HighPileCarpetCell());
		placeCellAt(12,6, new HighPileCarpetCell());
		placeCellAt(12,7, new BareFloorCell());
		placeCellAt(12,8, new BareFloorCell());
		placeCellAt(12,9, new BareFloorCell());
		placeCellAt(12,10, new WallCell());
		placeCellAt(12,11, new WallCell());
		placeCellAt(12,12, new WallCell());
		placeCellAt(12,13, new WallCell());
		placeCellAt(12,14, new DoorCell());
		placeCellAt(12,15, new WallCell());
		placeCellAt(12,16, new WallCell());
		placeCellAt(12,17, new WallCell());
		
		//Right Most Column - 3 of Flooring
		placeCellAt(13,0, new WallCell());
		placeCellAt(13,1, new BareFloorCell());
		placeCellAt(13,2, new HighPileCarpetCell());
		placeCellAt(13,3, new HighPileCarpetCell());
		placeCellAt(13,4, new HighPileCarpetCell());
		placeCellAt(13,5, new HighPileCarpetCell());
		placeCellAt(13,6, new HighPileCarpetCell());
		placeCellAt(13,7, new BareFloorCell());
		placeCellAt(13,8, new BareFloorCell());
		placeCellAt(13,9, new BareFloorCell());
		placeCellAt(13,10, new WallCell());
		placeCellAt(13,11, new BareFloorCell());
		placeCellAt(13,12, new BareFloorCell());
		placeCellAt(13,13, new BareFloorCell());
		placeCellAt(13,14, new BareFloorCell());
		placeCellAt(13,15, new BareFloorCell());
		placeCellAt(13,16, new BareFloorCell());
		placeCellAt(13,17, new WallCell());
		
		//Right Most Column - 2 of Flooring
		placeCellAt(14,0, new WallCell());
		placeCellAt(14,1, new BareFloorCell());
		placeCellAt(14,2, new HighPileCarpetCell());
		placeCellAt(14,3, new HighPileCarpetCell());
		placeCellAt(14,4, new HighPileCarpetCell());
		placeCellAt(14,5, new HighPileCarpetCell());
		placeCellAt(14,6, new HighPileCarpetCell());
		placeCellAt(14,7, new BareFloorCell());
		placeCellAt(14,8, new BareFloorCell());
		placeCellAt(14,9, new BareFloorCell());
		placeCellAt(14,10, new WallCell());
		placeCellAt(14,11, new BareFloorCell());
		placeCellAt(14,12, new BareFloorCell());
		placeCellAt(14,13, new BareFloorCell());
		placeCellAt(14,14, new BareFloorCell());
		placeCellAt(14,15, new BareFloorCell());
		placeCellAt(14,16, new BareFloorCell());
		placeCellAt(14,17, new WallCell());
		
		//Right Most Column - 1 of Flooring
		placeCellAt(15,0, new WallCell());
		placeCellAt(15,1, new BareFloorCell());
		placeCellAt(15,2, new BareFloorCell());
		placeCellAt(15,3, new BareFloorCell());
		placeCellAt(15,4, new BareFloorCell());
		placeCellAt(15,5, new BareFloorCell());
		placeCellAt(15,6, new BareFloorCell());
		placeCellAt(15,7, new BareFloorCell());
		placeCellAt(15,8, new BareFloorCell());
		placeCellAt(15,9, new BareFloorCell());
		placeCellAt(15,10, new WallCell());
		placeCellAt(15,11, new BareFloorCell());
		placeCellAt(15,12, new BareFloorCell());
		placeCellAt(15,13, new BareFloorCell());
		placeCellAt(15,14, new BareFloorCell());
		placeCellAt(15,15, new BareFloorCell());
		placeCellAt(15,16, new BareFloorCell());
		placeCellAt(15,17, new WallCell());
		
		//Right Most Column Of Floor Plan
		placeCellAt(16,0, new WallCell());
		placeCellAt(16,1, new WallCell());
		placeCellAt(16,2, new WallCell());
		placeCellAt(16,3, new WallCell());
		placeCellAt(16,4, new WallCell());
		placeCellAt(16,5, new WallCell());
		placeCellAt(16,6, new WallCell());
		placeCellAt(16,7, new WallCell());
		placeCellAt(16,8, new WallCell());
		placeCellAt(16,9, new WallCell());
		placeCellAt(16,10, new WallCell());
		placeCellAt(16,11, new WallCell());
		placeCellAt(16,12, new WallCell());
		placeCellAt(16,13, new WallCell());
		placeCellAt(16,14, new WallCell());
		placeCellAt(16,15, new WallCell());
		placeCellAt(16,16, new WallCell());
		placeCellAt(16,17, new WallCell());
		
		populateAdjacentCells();
	}
	
	//Must run after collection has been filled
	private void populateAdjacentCells(){
		for(int x=0; x<_floor.length; x++){
			for(int y=0; y<_floor[0].length; y++){
				
				// Lower Left Corner Case, No cells West and No cells South
				if(x == 0 && y==0)
				{
					_floor[x][y].setAdjacentCell(Direction.NORTH, _floor[x][y+1]);
					_floor[x][y].setAdjacentCell(Direction.NORTHEAST, _floor[x+1][y+1]);
					_floor[x][y].setAdjacentCell(Direction.EAST, _floor[x+1][y]);
					_floor[x][y].setAdjacentCell(Direction.SOUTHEAST, null);
					_floor[x][y].setAdjacentCell(Direction.SOUTH, null);
					_floor[x][y].setAdjacentCell(Direction.SOUTHWEST, null);
					_floor[x][y].setAdjacentCell(Direction.WEST, null);
					_floor[x][y].setAdjacentCell(Direction.NORTHWEST, null);
				}
				
				// Upper Right Corner Case, No Cells East and No Cells North
				else if(x == _floor.length - 1 && y == _floor[0].length - 1 ){
					_floor[x][y].setAdjacentCell(Direction.NORTH, null);
					_floor[x][y].setAdjacentCell(Direction.NORTHEAST, null);
					_floor[x][y].setAdjacentCell(Direction.EAST, null);
					_floor[x][y].setAdjacentCell(Direction.SOUTHEAST, null);
					_floor[x][y].setAdjacentCell(Direction.SOUTH, _floor[x][y-1]);
					_floor[x][y].setAdjacentCell(Direction.SOUTHWEST, _floor[x-1][y-1]);
					_floor[x][y].setAdjacentCell(Direction.WEST, _floor[x-1][y]);
					_floor[x][y].setAdjacentCell(Direction.NORTHWEST, null);
					
				}
				
				// Upper Left Corner Case, No Cells West, No Cells North
				else if(x == 0 && y == _floor[0].length - 1)
				{
					_floor[x][y].setAdjacentCell(Direction.NORTH, null);
					_floor[x][y].setAdjacentCell(Direction.NORTHEAST, null);
					_floor[x][y].setAdjacentCell(Direction.EAST, _floor[x+1][y]);
					_floor[x][y].setAdjacentCell(Direction.SOUTHEAST, _floor[x+1][y-1]);
					_floor[x][y].setAdjacentCell(Direction.SOUTH, _floor[x][y-1]);
					_floor[x][y].setAdjacentCell(Direction.SOUTHWEST, null);
					_floor[x][y].setAdjacentCell(Direction.WEST, null);
					_floor[x][y].setAdjacentCell(Direction.NORTHWEST, null);
				}
				
				// Lower Right Corner Case, No Cells East, No Cells South
				else if(x == _floor.length - 1 && y == 0)
				{
					_floor[x][y].setAdjacentCell(Direction.NORTH, _floor[x][y+1]);
					_floor[x][y].setAdjacentCell(Direction.NORTHEAST, null);
					_floor[x][y].setAdjacentCell(Direction.EAST, null);
					_floor[x][y].setAdjacentCell(Direction.SOUTHEAST, null);
					_floor[x][y].setAdjacentCell(Direction.SOUTH, null);
					_floor[x][y].setAdjacentCell(Direction.SOUTHWEST, null);
					_floor[x][y].setAdjacentCell(Direction.WEST, _floor[x-1][y]);
					_floor[x][y].setAdjacentCell(Direction.NORTHWEST, _floor[x-1][y+1]);
				}
				
				// Left Side Boundary, Case No Cells West
				else if(x == 0 && (y != 0 && y !=_floor[0].length - 1))
				{
					_floor[x][y].setAdjacentCell(Direction.NORTH, _floor[x][y+1]);
					_floor[x][y].setAdjacentCell(Direction.NORTHEAST, _floor[x+1][y+1]);
					_floor[x][y].setAdjacentCell(Direction.EAST, _floor[x+1][y]);
					_floor[x][y].setAdjacentCell(Direction.SOUTHEAST, _floor[x+1][y-1]);
					_floor[x][y].setAdjacentCell(Direction.SOUTH, _floor[x][y-1]);
					_floor[x][y].setAdjacentCell(Direction.SOUTHWEST, null);
					_floor[x][y].setAdjacentCell(Direction.WEST, null);
					_floor[x][y].setAdjacentCell(Direction.NORTHWEST, null);
				}
				
				// Right Side Boundary, Case No Cells East
				else if(x == _floor.length - 1 && (y != 0 && y != _floor[0].length - 1))
				{
					_floor[x][y].setAdjacentCell(Direction.NORTH, _floor[x][y+1]);
					_floor[x][y].setAdjacentCell(Direction.NORTHEAST, null);
					_floor[x][y].setAdjacentCell(Direction.EAST, null);
					_floor[x][y].setAdjacentCell(Direction.SOUTHEAST, null);
					_floor[x][y].setAdjacentCell(Direction.SOUTH, _floor[x][y-1]);
					_floor[x][y].setAdjacentCell(Direction.SOUTHWEST, _floor[x-1][y-1]);
					_floor[x][y].setAdjacentCell(Direction.WEST, _floor[x-1][y]);
					_floor[x][y].setAdjacentCell(Direction.NORTHWEST, _floor[x-1][y+1]);	
				}
				
				// Top Boundary, Case No Cells North
				else if(y == _floor[0].length - 1 && (x != 0 && x != _floor.length - 1))
				{
					_floor[x][y].setAdjacentCell(Direction.NORTH, null);
					_floor[x][y].setAdjacentCell(Direction.NORTHEAST, null);
					_floor[x][y].setAdjacentCell(Direction.EAST, _floor[x+1][y]);
					_floor[x][y].setAdjacentCell(Direction.SOUTHEAST, _floor[x+1][y-1]);
					_floor[x][y].setAdjacentCell(Direction.SOUTH, _floor[x][y-1]);
					_floor[x][y].setAdjacentCell(Direction.SOUTHWEST, _floor[x-1][y-1]);
					_floor[x][y].setAdjacentCell(Direction.WEST, _floor[x-1][y]);
					_floor[x][y].setAdjacentCell(Direction.NORTHWEST, null);
				}
				
				// Bottom Boundary, Case No Cells South
				else if(y == 0 && (x != 0 && x != _floor.length - 1) )
				{
					_floor[x][y].setAdjacentCell(Direction.NORTH, _floor[x][y+1]);
					_floor[x][y].setAdjacentCell(Direction.NORTHEAST, _floor[x+1][y+1]);
					_floor[x][y].setAdjacentCell(Direction.EAST, _floor[x+1][y]);
					_floor[x][y].setAdjacentCell(Direction.SOUTHEAST, null);
					_floor[x][y].setAdjacentCell(Direction.SOUTH, null);
					_floor[x][y].setAdjacentCell(Direction.SOUTHWEST, null);
					_floor[x][y].setAdjacentCell(Direction.WEST, _floor[x-1][y]);
					_floor[x][y].setAdjacentCell(Direction.NORTHWEST, _floor[x-1][y+1]);
				}
				// Locations that fall outside of the special cases
				else
				{
					_floor[x][y].setAdjacentCell(Direction.NORTH, _floor[x][y+1]);
					_floor[x][y].setAdjacentCell(Direction.NORTHEAST, _floor[x+1][y+1]);
					_floor[x][y].setAdjacentCell(Direction.EAST, _floor[x+1][y]);
					_floor[x][y].setAdjacentCell(Direction.SOUTHEAST, _floor[x+1][y-1]);
					_floor[x][y].setAdjacentCell(Direction.SOUTH, _floor[x][y-1]);
					_floor[x][y].setAdjacentCell(Direction.SOUTHWEST, _floor[x-1][y-1]);
					_floor[x][y].setAdjacentCell(Direction.WEST, _floor[x-1][y]);
					_floor[x][y].setAdjacentCell(Direction.NORTHWEST, _floor[x-1][y+1]);
				}
				
			}
		}
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int x=0; x<_floor.length; x++){
			for(int y=0; y<_floor[0].length; y++){
				sb.append(_floor[x][y].toString()).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
}

