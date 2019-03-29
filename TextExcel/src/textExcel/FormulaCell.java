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
		String temp = getDoubleValue() + "          ";
		return temp.substring(0, 10);
		
	}
	public double getDoubleValue() {
		String formula = super.getValueText();
		String[]  splitFormula = formula.split(" ");
		double answer;
		answer =  Double.parseDouble(splitFormula[1]);
		for(int i =3; i<splitFormula.length-1;i=i+2) {
			//i is the index for doubles 
			//k is the index for signs
			int k = i -1;
			double temp = Double.parseDouble(splitFormula[i]);
			if ( splitFormula[k].equals("+")) {
				answer = answer + temp ;
			}
			
			else if(splitFormula[k].equals("-")) {
				answer = answer - temp;
			}
			else if(splitFormula[k].equals("*")) {
				answer = answer * temp;
			}
			else{
				answer = answer / temp;
			}
		}
		
		
		return answer;
	}

	
}
