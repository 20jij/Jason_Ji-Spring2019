//@author: Jason Ji
//Version: March 2019

package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	//field
	Cell [][] sheet ;
	
	//constructor
	public Spreadsheet() {
		//initializes 20 array of 20 rows and 12 columns.
		sheet = new Cell [ getRows()][getCols()];
		for(int row=0;row< getRows();row++) {
			for(int cols=0;cols<getCols();cols++) {
				sheet[row][cols]= new EmptyCell();
			}
				
		}
	}
	
	
	
	
	@Override
	public String processCommand(String command)
	{
		String[] splitCommand = command.split(" ", 3);
		SpreadsheetLocation location; 
		
		//assignment of formula
		if (command.indexOf("(")>0){
			location = new SpreadsheetLocation(splitCommand[0]);
			sheet[location.getRow()][location.getCol()] = new FormulaCell(splitCommand[2], this);
			
		}
					
		
		//assignment of values(A1 = ____) and return the entire sheet.
		else if (splitCommand.length==3) {
			location = new SpreadsheetLocation(splitCommand[0]);
			// assignment of string values
			if (splitCommand[2].charAt(0)=='"' && splitCommand[2].charAt(splitCommand[2].length()-1)=='"') {
				sheet[location.getRow()][location.getCol()] = new TextCell(splitCommand[2]);
				
			}
			//assignment of percent
			else if (splitCommand[2].charAt(splitCommand[2].length()-1)=='%') {
				sheet[location.getRow()][location.getCol()] = new PercentCell(splitCommand[2]);
				
			}
			//assignment of double
			else {
				sheet[location.getRow()][location.getCol()] = new ValueCell(splitCommand[2]);
			}
		}
		
		
		//cell inspection(A1)
		else if (splitCommand[0].length()<4) {
			
			location = new SpreadsheetLocation(splitCommand[0]);
			return sheet[location.getRow()][location.getCol()].fullCellText();
			}
		
		//clearing a particular cell(clear A1)
		else if(splitCommand[0].length()==5 && splitCommand.length ==2){
					location = new SpreadsheetLocation(splitCommand[1]);
					sheet[location.getRow()][location.getCol()] = new EmptyCell();
					
				}
			
		//clearing the entire sheet (clear)
		else  {
			for(int row=0;row< getRows();row++) {
				for(int cols=0;cols<getCols();cols++) {
					sheet[row][cols]= new EmptyCell();
				}
			}
			
		}
		return getGridText();
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
		return sheet[loc.getRow()][loc.getCol()];
	}
	public Cell getCell(int a, int b) {
		return sheet[a][b];
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
				grid = grid +"|" + sheet[rows][columns].abbreviatedCellText();
			}
			grid = grid + "|" + "\n";
			
		}
		return grid;
	}

}
