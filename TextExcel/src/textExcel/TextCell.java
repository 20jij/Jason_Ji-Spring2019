package textExcel;

public class TextCell implements Cell {
	String text;
	
	//TextCell constructor
	public TextCell(String input) {
		
		text = input ;
	}
	
	public String abbreviatedCellText() {
		
		//get rid of two quotation marks
		String temp = text.substring(1,text.length()-1);
		
		//add 10 spaces after the string and return abbreviatedCellText
		temp = temp + "          ";
		return temp.substring(0,10);
	}
	
	//return full String cell
	public String fullCellText() {
		return  text ;
	}

}
