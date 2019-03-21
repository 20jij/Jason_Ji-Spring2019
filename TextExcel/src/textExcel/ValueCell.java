package textExcel;

public class ValueCell extends RealCell {

	public ValueCell(String input) {
		super(input);
	}
	
	@Override
	//I need to change int to double format if it passes in an int 12 12.0
	public String abbreviatedCellText() {
		String temp = (getValueText() + "          ").substring(0,10);
		return temp ;
	}
	
	@Override
	public String fullCellText() {

		return getValueText();
	}
	

}
