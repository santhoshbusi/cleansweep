package edu.cleansweep.floor;

import java.util.LinkedHashSet;
import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Floor {

	private ICell[][] _floor;
	private ICell _startingCell;
	private ArrayList<ChargingStationCell> _setOfChargingStations;
	
	public Floor(){
		_floor = new ICell[1][1];
		_setOfChargingStations = new ArrayList<ChargingStationCell>();
	}
	
	private void setStartingCell(ICell cell){
		_startingCell = cell;
	}
	
	ICell getStartingCell(){
		return _startingCell;
	}
	
	ICell getCellAt(int x, int y){
		if(_floor == null)
			return null;
		else if(_floor.length < 1)
			return null;
		
		if(x < _floor.length && y < _floor[x].length)
			return _floor[x][y];
		else
			return null;
	}
	
	private void placeCellAt(int x, int y, ICell cell){
		if(x > _floor.length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else if(y > _floor[x].length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else{
			_floor[x][y] = cell;
		}
			
	}
	
	private void placeChargingStationCellAt(int x, int y){
		if(x > _floor.length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else if(y > _floor[x].length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else{
			ChargingStationCell c = new ChargingStationCell(x,y);
			_floor[x][y] = c;
			_setOfChargingStations.add(c);
		}
	}
	
	private void placeWallCellAt(int x, int y){
		if(x > _floor.length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else if(y > _floor[x].length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else{
			_floor[x][y] = new WallCell(x,y);
		}
	}
	
	private void placeDoorCellAt(int x, int y){
		if(x > _floor.length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else if(y > _floor[x].length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else{
			_floor[x][y] = new DoorCell(x,y);
		}
	}
	
	private void placeStairsCellAt(int x, int y){
		if(x > _floor.length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else if(y > _floor[x].length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else{
			_floor[x][y] = new StairsCell(x,y);
		}
	}
	
	private void placeBareFloorCellAt(int x, int y){
		if(x > _floor.length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else if(y > _floor[x].length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else{
			_floor[x][y] = new BareFloorCell(x,y);
		}
	}
	
	private void placeLowPileCarpetCellAt(int x, int y){
		if(x > _floor.length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else if(y > _floor[x].length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else{
			_floor[x][y] = new LowPileCarpetCell(x,y);
		}
	}
	
	private void placeHighPileCarpetCellAt(int x, int y){
		if(x > _floor.length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else if(y > _floor[x].length)
			throw new ArrayIndexOutOfBoundsException("Cells cannot be placed outside of floor");
		else{
			_floor[x][y] = new HighPileCarpetCell(x,y);
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
	
	private String printAdjacentCells(ICell cell){
		
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
	
	public void displayLocationOnFloorInConsole(Location location){
		 System.out.println(markCellAt(location.getLongitude(), location.getLatitude()));
	}
	
	String markCellAt(int x, int y){
		StringBuilder sb = new StringBuilder();
		for(int xi=0; xi<_floor.length; xi++){
			for(int yi=0; yi<_floor[xi].length; yi++){
				if(xi == x && yi == y)
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
			for(int y=0; y<_floor[x].length; y++){
				sb.append(queryCellAt(x, y)).append("\n").append(markCellAt(y,x)).append("\n");
			}
		}
		return sb.toString();
	}
	
	public boolean createFloorPlanFromFile(String filename){
		ArrayList<ArrayList<ICell>> cellsFromLine = new ArrayList<ArrayList<ICell>>();
		Path path = FileSystems.getDefault().getPath("src/edu/cleansweep/tests",filename);
		
		//Reset list of charging stations
		_setOfChargingStations = new ArrayList<ChargingStationCell>();
		
		// keep track of x and y coordinates 
		int x = 0;
		int y = 0;
		
		// keep track of max x and max y
		// assume there's at least one line and one character 
		int xMax = 1;
		int yMax = 1;
		
		try{
			BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset());
			int value = 0;
			
			ArrayList<ICell> line = new ArrayList<ICell>();
			while((value = reader.read()) != -1){
				char c = (char)value;
				switch (c) {
				
				case '\n':
					cellsFromLine.add(line);
					line = new ArrayList<ICell>();
					x++;
					xMax = x;
					y=0;
					break;
				case 'W':
					line.add(new WallCell(x,y));
					y++;
					if(yMax < y){ yMax = y;}
					break;
				case 'C':
					ChargingStationCell cStation = new ChargingStationCell(x,y);
					line.add(cStation);
					_setOfChargingStations.add(cStation);
					y++;
					if(yMax < y){ yMax = y;}
					break;
				case 'B':
					line.add(new BareFloorCell(x,y));
					y++;
					if(yMax < y){ yMax = y;}
					break;
				case 'D':
					line.add(new DoorCell(x,y));
					y++;
					if(yMax < y){ yMax = y;}
					break;
				case 'H':
					line.add(new HighPileCarpetCell(x,y));
					y++;
					if(yMax < y){yMax = y;}
					break;
				case 'L':
					line.add(new LowPileCarpetCell(x,y));
					y++;
					if(yMax < y){ yMax = y;}
					break;
				case 'O':
					line.add(new ObstacleCell(x,y));
					y++;
					if(yMax < y){ yMax = y;}
					break;
				case 'S':
					line.add(new StairsCell(x,y));
					y++;
					if(yMax < x){ yMax = y;}
					break;
				}
			
			}
		}
		catch(Exception e){
			return false;
		}
		
		//resize underlying structure 
		_floor = new ICell[xMax][yMax];
		
		for(int xi=0; xi<xMax; xi++)
		{
			if(cellsFromLine.get(xi).size() < yMax)
			{
				ICell [] tempArray = new ICell[yMax];
				for(int t=0; t<yMax; t++)
				{
					if(t < cellsFromLine.get(xi).size())
						tempArray[t] = cellsFromLine.get(xi).get(t);
					else
						tempArray[t] = new NullCell(xi,t);
				}
				_floor[xi] = tempArray;
			}
			else
				_floor[xi] = cellsFromLine.get(xi).toArray(new ICell[yMax]);
		}
	
		populateAdjacentCells();
		
		//Set starting location to first charging station in list
		setStartingCell(_setOfChargingStations.get(0));

		return true;
	}
	
	public void createDefaultFloorPlan() {
		_floor = new ICell[17][18];
		//Left Most Column Of Floor Plan
		placeWallCellAt(0,0);
		placeWallCellAt(0,1);
		placeWallCellAt(0,2);
		placeWallCellAt(0,3);
		placeWallCellAt(0,4);
		placeWallCellAt(0,5);
		placeWallCellAt(0,6);
		placeWallCellAt(0,7);
		placeWallCellAt(0,8);
		placeWallCellAt(0,9);
		placeWallCellAt(0,10);
		placeWallCellAt(0,11);
		placeWallCellAt(0,12);
		placeWallCellAt(0,13);
		placeWallCellAt(0,14);
		placeWallCellAt(0,15);
		placeWallCellAt(0,16);
		placeWallCellAt(0,17);
		
		//Left Most Column of Flooring
		placeWallCellAt(1,0);
		//Creation Charging Station
		ChargingStationCell c = new ChargingStationCell(1,1);
		placeCellAt(1,1, c);
		//Add ChargingStationCell to List of Charging Stations
		_setOfChargingStations.add(c);
		//Set to First Cell
		setStartingCell(c);
		
		placeLowPileCarpetCellAt(1,2);
		placeLowPileCarpetCellAt(1,3);
		placeLowPileCarpetCellAt(1,4);
		placeLowPileCarpetCellAt(1,5);
		placeLowPileCarpetCellAt(1,6);
		placeWallCellAt(1,7);
		placeBareFloorCellAt(1,8);
		placeWallCellAt(1,9);
		placeBareFloorCellAt(1,10);
		placeCellAt(1,11, new DoorCell(1,11));
		placeLowPileCarpetCellAt(1,12);
		placeLowPileCarpetCellAt(1,13);
		placeLowPileCarpetCellAt(1,14);
		placeLowPileCarpetCellAt(1,15);
		placeLowPileCarpetCellAt(1,16);
		placeWallCellAt(1,17);
		
		//Left Most Column + 1 of Flooring
		placeWallCellAt(2,0);
		placeLowPileCarpetCellAt(2,1);
		placeLowPileCarpetCellAt(2,2);
		placeLowPileCarpetCellAt(2,3);
		placeLowPileCarpetCellAt(2,4);
		placeLowPileCarpetCellAt(2,5);
		placeLowPileCarpetCellAt(2,6);
		placeWallCellAt(2,7);
		placeBareFloorCellAt(2,8);
		placeWallCellAt(2,9);
		placeBareFloorCellAt(2,10);
		placeWallCellAt(2,11);
		placeLowPileCarpetCellAt(2,12);
		placeLowPileCarpetCellAt(2,13);
		placeLowPileCarpetCellAt(2,14);
		placeLowPileCarpetCellAt(2,15);
		placeLowPileCarpetCellAt(2,16);
		placeWallCellAt(2,17);
		
		//Left Most Column + 2 of Flooring
		placeWallCellAt(3,0);
		placeLowPileCarpetCellAt(3,1);
		placeLowPileCarpetCellAt(3,2);
		placeLowPileCarpetCellAt(3,3);
		placeLowPileCarpetCellAt(3,4);
		placeLowPileCarpetCellAt(3,5);
		placeLowPileCarpetCellAt(3,6);
		placeWallCellAt(3,7);
		placeBareFloorCellAt(3,8);
		placeWallCellAt(3,9);
		placeWallCellAt(3,10);
		placeWallCellAt(3,11);
		placeLowPileCarpetCellAt(3,12);
		placeLowPileCarpetCellAt(3,13);
		placeLowPileCarpetCellAt(3,14);
		placeLowPileCarpetCellAt(3,15);
		placeLowPileCarpetCellAt(3,16);
		placeWallCellAt(3,17);
		
		//Left Most Column + 3 of Flooring
		placeWallCellAt(4,0);
		placeLowPileCarpetCellAt(4,1);
		placeLowPileCarpetCellAt(4,2);
		placeLowPileCarpetCellAt(4,3);
		placeLowPileCarpetCellAt(4,4);
		placeLowPileCarpetCellAt(4,5);
		placeLowPileCarpetCellAt(4,6);
		placeWallCellAt(4,7);
		placeBareFloorCellAt(4,8);
		placeWallCellAt(4,9);
		placeBareFloorCellAt(4,10);
		placeWallCellAt(4,11);
		placeLowPileCarpetCellAt(4,12);
		placeLowPileCarpetCellAt(4,13);
		placeLowPileCarpetCellAt(4,14);
		placeLowPileCarpetCellAt(4,15);
		placeLowPileCarpetCellAt(4,16);
		placeWallCellAt(4,17);

		//Left Most Column + 4 of Flooring
		placeWallCellAt(5,0);
		placeLowPileCarpetCellAt(5,1);
		placeLowPileCarpetCellAt(5,2);
		placeLowPileCarpetCellAt(5,3);
		placeLowPileCarpetCellAt(5,4);
		placeLowPileCarpetCellAt(5,5);
		placeLowPileCarpetCellAt(5,6);
		placeWallCellAt(5,7);
		placeBareFloorCellAt(5,8);
		placeWallCellAt(5,9);
		placeBareFloorCellAt(5,10);
		placeWallCellAt(5,11);
		placeLowPileCarpetCellAt(5,12);
		placeLowPileCarpetCellAt(5,13);
		placeLowPileCarpetCellAt(5,14);
		placeLowPileCarpetCellAt(5,15);
		placeLowPileCarpetCellAt(5,16);
		placeWallCellAt(5,17);
		
		//Left Most Column + 5 of Flooring
		placeWallCellAt(6,0);
		placeWallCellAt(6,1);
		placeWallCellAt(6,2);
		placeWallCellAt(6,3);
		placeDoorCellAt(6,4);
		placeWallCellAt(6,5);
		placeWallCellAt(6,6);
		placeWallCellAt(6,7);
		placeDoorCellAt(6,8);
		placeWallCellAt(6,9);
		placeDoorCellAt(6,10);
		placeWallCellAt(6,11);
		placeDoorCellAt(6,12);
		placeWallCellAt(6,13);
		placeWallCellAt(6,14);
		placeWallCellAt(6,15);
		placeWallCellAt(6,16);
		placeWallCellAt(6,17);
		
		//Left Most Column + 6 of Flooring
		placeStairsCellAt(7,0);
		placeBareFloorCellAt(7,1);
		placeBareFloorCellAt(7,2);
		placeBareFloorCellAt(7,3);
		placeBareFloorCellAt(7,4);
		placeBareFloorCellAt(7,5);
		placeBareFloorCellAt(7,6);
		placeBareFloorCellAt(7,7);
		placeBareFloorCellAt(7,8);
		placeBareFloorCellAt(7,9);
		placeBareFloorCellAt(7,10);
		placeBareFloorCellAt(7,11);
		placeBareFloorCellAt(7,12);
		placeDoorCellAt(7,13);
		placeBareFloorCellAt(7,14);
		placeWallCellAt(7,15);
		placeBareFloorCellAt(7,16);
		placeWallCellAt(7,17);
		
		//Left Most Column + 7 of Flooring
		placeWallCellAt(8,0);
		placeBareFloorCellAt(8,1);
		placeBareFloorCellAt(8,2);
		placeBareFloorCellAt(8,3);
		placeBareFloorCellAt(8,4);
		placeBareFloorCellAt(8,5);
		placeBareFloorCellAt(8,6);
		placeBareFloorCellAt(8,7);
		placeBareFloorCellAt(8,8);
		placeBareFloorCellAt(8,9);
		placeBareFloorCellAt(8,10);
		placeBareFloorCellAt(8,11);
		placeBareFloorCellAt(8,12);
		placeWallCellAt(8,13);
		placeBareFloorCellAt(8,14);
		placeWallCellAt(8,15);
		placeBareFloorCellAt(8,16);
		placeWallCellAt(8,17);
		
		//Right Most Column - 7 of Flooring
		placeWallCellAt(9,0);
		placeWallCellAt(9,1);
		placeWallCellAt(9,2);
		placeWallCellAt(9,3);
		placeWallCellAt(9,4);
		placeWallCellAt(9,5);
		placeWallCellAt(9,6);
		placeWallCellAt(9,7);
		placeWallCellAt(9,8);
		placeWallCellAt(9,9);
		placeWallCellAt(9,10);
		placeDoorCellAt(9,11);
		placeWallCellAt(9,12);
		placeWallCellAt(9,13);
		placeWallCellAt(9,14);
		placeWallCellAt(9,15);
		placeBareFloorCellAt(9,16);
		placeWallCellAt(9,17);
		
		//Right Most Column - 6 of Flooring
		placeWallCellAt(10,0);
		placeBareFloorCellAt(10,1);
		placeBareFloorCellAt(10,2);
		placeBareFloorCellAt(10,3);
		placeBareFloorCellAt(10,4);
		placeBareFloorCellAt(10,5);
		placeBareFloorCellAt(10,6);
		placeBareFloorCellAt(10,7);
		placeBareFloorCellAt(10,8);
		placeBareFloorCellAt(10,9);
		placeBareFloorCellAt(10,10);
		placeBareFloorCellAt(10,11);
		placeBareFloorCellAt(10,12);
		placeBareFloorCellAt(10,13);
		placeBareFloorCellAt(10,14);
		placeDoorCellAt(10,15);
		placeBareFloorCellAt(10,16);
		placeCellAt(10,17, new WallCell(10,17));
		
		//Right Most Column - 5 of Flooring
		placeWallCellAt(11,0);
		placeBareFloorCellAt(11,1);
		placeHighPileCarpetCellAt(11,2);
		placeHighPileCarpetCellAt(11,3);
		placeHighPileCarpetCellAt(11,4);
		placeHighPileCarpetCellAt(11,5);
		placeHighPileCarpetCellAt(11,6);
		placeBareFloorCellAt(11,7);
		placeBareFloorCellAt(11,8);
		placeBareFloorCellAt(11,9);
		placeBareFloorCellAt(11,10);
		placeBareFloorCellAt(11,11);
		placeBareFloorCellAt(11,12);
		placeBareFloorCellAt(11,13);
		placeBareFloorCellAt(11,14);
		placeWallCellAt(11,15);
		placeBareFloorCellAt(11,16);
		placeWallCellAt(11,17);
		
		//Right Most Column - 4 of Flooring
		placeWallCellAt(12,0);
		placeBareFloorCellAt(12,1);
		placeHighPileCarpetCellAt(12,2);
		placeHighPileCarpetCellAt(12,3);
		placeHighPileCarpetCellAt(12,4);
		placeHighPileCarpetCellAt(12,5);
		placeHighPileCarpetCellAt(12,6);
		placeBareFloorCellAt(12,7);
		placeBareFloorCellAt(12,8);
		placeBareFloorCellAt(12,9);
		placeWallCellAt(12,10);
		placeWallCellAt(12,11);
		placeWallCellAt(12,12);
		placeWallCellAt(12,13);
		placeDoorCellAt(12,14);
		placeWallCellAt(12,15);
		placeWallCellAt(12,16);
		placeWallCellAt(12,17);
		
		//Right Most Column - 3 of Flooring
		placeWallCellAt(13,0);
		placeBareFloorCellAt(13,1);
		placeHighPileCarpetCellAt(13,2);
		placeHighPileCarpetCellAt(13,3);
		placeHighPileCarpetCellAt(13,4);
		placeHighPileCarpetCellAt(13,5);
		placeHighPileCarpetCellAt(13,6);
		placeBareFloorCellAt(13,7);
		placeBareFloorCellAt(13,8);
		placeBareFloorCellAt(13,9);
		placeWallCellAt(13,10);
		placeBareFloorCellAt(13,11);
		placeBareFloorCellAt(13,12);
		placeBareFloorCellAt(13,13);
		placeBareFloorCellAt(13,14);
		placeBareFloorCellAt(13,15);
		placeBareFloorCellAt(13,16);
		placeWallCellAt(13,17);
		
		//Right Most Column - 2 of Flooring
		placeWallCellAt(14,0);
		placeBareFloorCellAt(14,1);
		placeHighPileCarpetCellAt(14,2);
		placeHighPileCarpetCellAt(14,3);
		placeHighPileCarpetCellAt(14,4);
		placeHighPileCarpetCellAt(14,5);
		placeHighPileCarpetCellAt(14,6);
		placeBareFloorCellAt(14,7);
		placeBareFloorCellAt(14,8);
		placeBareFloorCellAt(14,9);
		placeWallCellAt(14,10);
		placeBareFloorCellAt(14,11);
		placeBareFloorCellAt(14,12);
		placeBareFloorCellAt(14,13);
		placeBareFloorCellAt(14,14);
		placeBareFloorCellAt(14,15);
		placeBareFloorCellAt(14,16);
		placeWallCellAt(14,17);
		
		//Right Most Column - 1 of Flooring
		placeWallCellAt(15,0);
		placeBareFloorCellAt(15,1);
		placeBareFloorCellAt(15,2);
		placeBareFloorCellAt(15,3);
		placeBareFloorCellAt(15,4);
		placeBareFloorCellAt(15,5);
		placeBareFloorCellAt(15,6);
		placeBareFloorCellAt(15,7);
		placeBareFloorCellAt(15,8);
		placeBareFloorCellAt(15,9);
		placeWallCellAt(15,10);
		placeBareFloorCellAt(15,11);
		placeBareFloorCellAt(15,12);
		placeBareFloorCellAt(15,13);
		placeBareFloorCellAt(15,14);
		placeBareFloorCellAt(15,15);
		placeBareFloorCellAt(15,16);
		placeWallCellAt(15,17);
		
		//Right Most Column Of Floor Plan
		placeWallCellAt(16,0);
		placeWallCellAt(16,1);
		placeWallCellAt(16,2);
		placeWallCellAt(16,3);
		placeWallCellAt(16,4);
		placeWallCellAt(16,5);
		placeWallCellAt(16,6);
		placeWallCellAt(16,7);
		placeWallCellAt(16,8);
		placeWallCellAt(16,9);
		placeWallCellAt(16,10);
		placeWallCellAt(16,11);
		placeWallCellAt(16,12);
		placeWallCellAt(16,13);
		placeWallCellAt(16,14);
		placeWallCellAt(16,15);
		placeWallCellAt(16,16);
		placeWallCellAt(16,17);
		
		populateAdjacentCells();
	}
	
	//Must run after collection has been filled
	private void populateAdjacentCells(){
		for(int x=0; x<_floor.length; x++){
			for(int y=0; y<_floor[x].length; y++){
				
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
				else if(x == _floor.length - 1 && y == _floor[x].length - 1 ){
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
				else if(x == 0 && y == _floor[x].length - 1)
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
				else if(x == 0 && (y != 0 && y !=_floor[x].length - 1))
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
				else if(x == _floor.length - 1 && (y != 0 && y != _floor[x].length - 1))
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
				else if(y == _floor[x].length - 1 && (x != 0 && x != _floor.length - 1))
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
			for(int y=0; y<_floor[x].length; y++){
				sb.append(_floor[x][y].toString()).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
}

