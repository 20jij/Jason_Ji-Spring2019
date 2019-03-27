//@author: Jason Ji
//Version: March 2019
package textExcel;

public class ValueCell extends RealCell {

	public ValueCell(String input) {
		super(input);
	}
	
	@Override
	//I need to change int to double format if it passes in an int 12 12.0
	public String abbreviatedCellText() {
		double result = Double.parseDouble(getValueText());
		String temp = (result + "          ").substring(0,10);
		return temp;
	}
	
	@Override
	public String fullCellText() {

		return getValueText();
	}
	
	@Override
	public double getDoubleValue() {
		return Double.parseDouble(getValueText());
	}
	

}
