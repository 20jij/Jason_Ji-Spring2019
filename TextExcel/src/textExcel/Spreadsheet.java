package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	Cell [][] s ;
	//constructor
	public Spreadsheet() {
		//initializes 20 array of 20 rows and 12 columns.
		s = new Cell [ getRows()][getCols()];
		for(int row=0;row< getRows();row++) {
			for(int cols=0;cols<getCols();cols++) {
				s[row][cols]= new EmptyCell();
			}
				
		}
	}
	
	
	
	
	@Override
	public String processCommand(String command)
	{
		String[] splitCommand = command.split(" ", 3);
		SpreadsheetLocation location; 
		
		//assignment of string values(A1 = "Hello") and return the entire sheet.
		if (splitCommand.length==3) {
			location = new SpreadsheetLocation(splitCommand[0]);
			s[location.getRow()][location.getCol()] = new TextCell(splitCommand[2]);
			return getGridText();
		}
			
		
		//cell inspection(A1)
		else if (splitCommand[0].length()<4) {
			location = new SpreadsheetLocation(splitCommand[0]);
			return s[location.getRow()][location.getCol()].fullCellText();
		}
		
		//clearing a particular cell(clear A1)
		else if(splitCommand[0].length()==5 && splitCommand.length ==2){
					location = new SpreadsheetLocation(splitCommand[1]);
					s[location.getRow()][location.getCol()] = new EmptyCell();
					return getGridText();
				}
			
		//clearing the entire sheet (clear)
		else  {
			for(int row=0;row< getRows();row++) {
				for(int cols=0;cols<getCols();cols++) {
					s[row][cols]= new EmptyCell();
				}
			}
			return getGridText();
		}		
	}

	
	
	
	@Override
	public int getRows()
	{
		//returns number of rows in grid
		return 20;
	}

	@Override
	public int getCols()
	{
		
		 // returns number of columns in grid
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		//return the cell at this location
		return s[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		// return a single String containing the entire spreadsheet grid.
		//first row
		String grid =  "   |";
		for (int i=0;i<12;i++) {
			int charNumber = 65 +i;
			char temp = (char)charNumber;
			grid = grid + temp +"         |";
		}
		grid = grid + "\n";
		
		//rest of the rows
		//header
		for (int rows=0;rows<20;rows++) {
			int temp = rows +1;
			if (temp <10) {
				grid = grid + temp + "  ";
			}
			else {
				grid = grid + temp + " ";
			}
			//cells
			for (int columns=0;columns<12;columns++) {
				grid = grid +"|" + s[rows][columns].abbreviatedCellText();
			}
			grid = grid + "|" + "\n";
			
		}
		return grid;
	}

}
