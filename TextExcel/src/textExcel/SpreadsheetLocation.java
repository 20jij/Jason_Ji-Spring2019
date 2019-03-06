package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	int row;
	int colunm;
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
    
    public SpreadsheetLocation(String cellName)
    {
        // TODO: Fill this out with your own code
    	char letter = cellName.charAt(0);
    	int number = Integer.parseInt(cellName.substring(letter));
    	row = letter - 'A';
    	colunm = number-1;
    }

}
