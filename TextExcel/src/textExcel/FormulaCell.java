//@author: Jason Ji
//version: March 2019
package textExcel;

public class FormulaCell extends RealCell {

	//constructor
	public FormulaCell(String input) {
		super(input);
	}
	
	public String fullCellText() {
		return super.getValueText();
	
	}
	
	public String abbreviatedCellText() {
		String temp = super.getValueText() + "          ";
		return temp.substring(0, 10);
		
	}
	public double getDoubleValue() {
		String formula = super.getValueText();
		for 
		return 0.0;
	}

	
}
