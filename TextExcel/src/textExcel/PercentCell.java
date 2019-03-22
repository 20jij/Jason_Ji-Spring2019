package textExcel;

public class PercentCell extends RealCell {
	
	//constructor
	public PercentCell(String input) {
		super(input);
	}
	
	public String fullCellText() {
		String temp = (super.getValueText()).substring(0, super.getValueText().length()-1);
		double percent = Double.parseDouble(temp);
		percent = percent/100.0;
		return "" + percent;
	}
	
	public String abbreviatedCellText() {
		
		String result = super.getValueText();
		result.
	}
	

}
