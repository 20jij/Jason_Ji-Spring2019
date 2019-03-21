package textExcel;

public class RealCell implements Cell {
	//fields
	private String valueText;
	private double value;

	//constructor
	public RealCell(String input) {
		valueText = input;
		value = Integer.parseInt(input);
	}

	@Override
	public String abbreviatedCellText() {
		return null;
	}

	@Override
	public String fullCellText() {

		return null;
	}
	
	//getValueText and getValue methods that allow subclasses to access the fields.
	public String getValueText() {
		return valueText;
	}
	
	public double getValue() {
		return value;
	}
	
	public double getDoubleValue() {
		return 0;
	}

}
