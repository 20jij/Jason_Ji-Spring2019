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
		return ("");
	}

	@Override
	public int getRows()
	{
		//returns number of rows in grid
		return (20);
	}

	@Override
	public int getCols()
	{
		
		 // returns number of columns in grid
		return (12);
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
