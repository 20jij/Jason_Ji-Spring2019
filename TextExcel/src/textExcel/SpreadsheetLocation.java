//@author Jason Ji
//version March 2019
package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int colunm;

    //constructor
    public SpreadsheetLocation(String cellName)
    {
    	
    	char letter = Character.toUpperCase(cellName.charAt(0));
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
        return colunm;
    }
    
}
