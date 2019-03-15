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
		//cell inspection(A1)
		if ((int)splitCommand[0].substring(1))
			
		
		//assignment of string values(A1="Hello")
			
			
		//clearing the entire sheet (clear)
			
			
			
		//clearing a particular cell(clear A1)
		return "";
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
		for (int i=0;i<20;i++) {
			int temp = i +1;
			if (temp <10) {
				grid = grid + temp + "  ";
			}
			else {
				grid = grid + temp + " ";
			}
			//cells
			for (int k=0;k<12;k++) {
				grid = grid +"|          ";
			}
			grid = grid + "|" + "\n";
			
		}
		return grid;
	}

}
