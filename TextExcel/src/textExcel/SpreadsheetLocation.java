package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	int row;
	int colunm;

    //constructor
    public SpreadsheetLocation(String cellName)
    {
    	char letter = cellName.charAt(0);
    	int number = Integer.parseInt(cellName.substring(1));
    	colunm = letter - 65;
    	row = number-1;
    }

    @Override
    public int getRow()
    {
        return row;
    }

    @Override
    public int getCol()
    {
    	// represents a location like B6, must be implemented by your SpreadsheetLocation class
    			 // gets row of this location
    			 // gets column of this location
        return colunm;
    }
    
}
