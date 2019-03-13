package textExcel;

public class TextCell implements Cell {
	String text;
	public TextCell(String input) {
		text = input;

	}
	
	public String abbreviatedCellText() {
		return text.substring(0,10);
	}
	
	public String fullCellText() {
		return '"' + text + '"';
	}

}
