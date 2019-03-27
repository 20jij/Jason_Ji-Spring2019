//@author Jason Ji
//version March 2019

package textExcel;

public class EmptyCell implements Cell {

	// constructor
	public EmptyCell() {
		
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		return ("          ");
	} 
	
	
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return("");
	}

}
