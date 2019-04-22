//@author:Jason Ji 
//version: March 2019
package textExcel;

public class PercentCell extends RealCell {
	
	//fields
	//string without % sign
	private String decimalString = (super.fullCellText()).substring(0, super.fullCellText().length()-1);
	
	//constructor
	public PercentCell(String input) {
		super(input);
	}
	
	public String fullCellText() {
		double result = Double.parseDouble(decimalString);
		result = result/100.0;
		return "" + result;
	}
	
	public String abbreviatedCellText() {
		int intResult = (int)Double.parseDouble(decimalString);
		String temp = intResult + "%" + "          ";
		return temp.substring(0,10)  ;
	}
	
	public double getDoubleValue() {
		double doubleValue = Double.parseDouble(decimalString);
		doubleValue = doubleValue/100.0;
		return doubleValue;
		
	}
	

}
