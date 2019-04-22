//@author: Jason Ji
//Version: March 2019
package textExcel;

public class RealCell implements Cell {
	//fields
	private String valueText;

	//constructor
	public RealCell(String input) {
		valueText = input;
	}

	@Override
	public String abbreviatedCellText() {
		return null;
	}

	@Override
	public String fullCellText() {

		return valueText;
	}
	
	
	public double getDoubleValue() {
		return Double.parseDouble(valueText);
	}

}
