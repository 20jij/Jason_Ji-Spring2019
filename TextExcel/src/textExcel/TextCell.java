package textExcel;

public class TextCell implements Cell {
	String text;
	public TextCell(String input) {
		//clear quotation marks
		if (input.equals("\"\"")) {
			text = " ";
		}
		text = input ;
	}
	
	public String abbreviatedCellText() {
		String temp =text;
		temp = temp + "          ";
		return temp.substring(1,11);
	}
	
	public String fullCellText() {
		return  text ;
	}

}
