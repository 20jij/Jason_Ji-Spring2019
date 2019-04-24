//@author: Jason Ji
//version: March 2019
package textExcel;

public class FormulaCell extends RealCell {

	//field
	private Spreadsheet sheetCopy;
	int count=0;
	//constructor
	public FormulaCell(String input,Spreadsheet sheet) {
		super(input);
		sheetCopy = sheet;
	}
	

	public String abbreviatedCellText() {
		String temp = getDoubleValue() + "          ";
		return temp.substring(0, 10);
		
	}
	public double getDoubleValue() {
		System.out.println("Text: "+fullCellText());
		String[]  splitFormula =  fullCellText().split(" ");
		double answer;
		//check the first term
		
		//SUM 
		if (splitFormula[1].equalsIgnoreCase("SUM")) {
			answer = getSum(splitFormula[2]);
			System.out.println("sum: "+answer);
			return answer;
		}
		//AVG
		else if (splitFormula[1].equalsIgnoreCase("AVG")) {
			answer = getAvg(splitFormula[2]);
			System.out.println("avg: "+answer);
			count = 0;
			return answer;
		}
		//cell reference or numbers 
		else  {
			if(splitFormula[1].matches(".*[A-Z].*") ||splitFormula[1].matches(".*[a-z].*" )){
			
				Location cell = new SpreadsheetLocation(splitFormula[1]);
				RealCell casting =(RealCell)(sheetCopy.getCell(cell));
				answer = casting.getDoubleValue();
			
			}
			else {
				answer =  Double.parseDouble(splitFormula[1]);
				
			}
			
			for(int i =3; i<=splitFormula.length-1;i=i+2) {
				//i is the index for doubles or cell references
				//k is the index for signs
				int k = i -1;
				//if it's cell reference
				double temp;
				if(splitFormula[i].matches(".*[A-Z].*")||splitFormula[i].matches(".*[a-z].*" )) {
					Location cell = new SpreadsheetLocation(splitFormula[i]);
					RealCell casting =(RealCell)(sheetCopy.getCell(cell));
					temp = casting.getDoubleValue();
				}
				// if it's a number
				else {
					temp = Double.parseDouble(splitFormula[i]);
				}
				 
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
	public double getSum(String input) {
		double sum=0;
		
		String[] splitRange = input.split("-");
		Location start = new SpreadsheetLocation(splitRange[0]);
		Location end = new SpreadsheetLocation(splitRange[1]);
		
		for (int col = start.getCol(); col <= end.getCol();col++) {
			for (int row =start.getRow(); row<=end.getRow();row++ ) {
				RealCell casting =(RealCell)(sheetCopy.getCell(row,col));
				sum = sum +casting.getDoubleValue();
				count++;
			}
		}
		System.out.println("sum:" + sum +  "count:" + count );
		return sum;
	}
	
	public double getAvg(String input) {
		double sum = getSum(input);
		return sum/count;
	}
}
