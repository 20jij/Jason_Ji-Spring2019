package fracCalc;

public class Fraction {
	
	//Fields
	private int[] operandInt = new int[3];
	
	
	
	
	//Constructors
	public Fraction(String operand) {
	}
	
	public Fraction() {
	}
	
	//Methods
	
	public Fraction doMath(char operator, String operand) {
		
	}
	public String toString() {
	}

		public static void toCommonDenominator (int [] operand1, int[] operand2) {
	    	
	    	int temp = operand1[2] ;
	    	operand1[2] = operand1[2] * operand2[2];
	    	operand1[1] = operand1[1] * operand2[2];
	    	operand2[2] = operand2[2] * temp;
	    	operand2[1] = operand2[1] * temp;
	    }
	    
	    
	    
	    
	    
	    public static int greatestCommonFactor(int a,int b) {
	    	double limit = max(absValue(a), absValue(b));
	    	int result = 1;
			for (int factor=2; factor<=limit;factor++) {
				boolean c = isDivisibleBy(a,factor);
				boolean d = isDivisibleBy(b,factor);
				if(c==true && d==true) {
					 result = factor;
				}
			}
			
			return result;
	    }
	    
	    public static int[] checkpoint2 (String input, int [] operand) {
	        int indexOf_ = input.indexOf('_');
	        int indexOfslash = input.indexOf('/');
	        if (indexOf_ == -1 && indexOfslash != -1) {     // 2/5
	        	operand[0] = 0;
	        	operand[1] = Integer.parseInt(input.substring(0,indexOfslash));
	        	operand[2] = Integer.parseInt(input.substring(indexOfslash+1));
	        }
	        else if(indexOf_ == -1 && indexOfslash == -1) {   //3
	        	operand[0] = Integer.parseInt(input);
	        	operand[1] = 0;
	        	operand[2] = 1;
	        }
	        else {                      //3_2/5
	        	String wholeNumberString2 = input.substring(0,indexOf_);
	        	int wholeNumberInt2 = Integer.parseInt(wholeNumberString2);
	        	String fractionString = input.substring(indexOf_+1);
	        	operand[0] = wholeNumberInt2;
	        	indexOfslash = fractionString.indexOf('/');
	        	operand[1] = Integer.parseInt(fractionString.substring(0,indexOfslash));
	            operand[2] = Integer.parseInt(fractionString.substring(indexOfslash+1));
	        }
	        return operand;  
	    }

	    public static void toImproper(int[] fraction) {
	    	int wholeNumber = fraction[0];
	    	if (wholeNumber < 0) {
	    		fraction[1] = -fraction[1] + fraction[2]*fraction[0];
	    	}
	    	else {
	    		fraction[1] = fraction[1] + fraction[2]*fraction[0];
	    	}
	    	fraction[0] = 0;
	    }
	    
	    public static boolean isDivisibleBy(int number1,int number2) {
			if (number2 == 0) {
				throw new IllegalArgumentException ("The denominator can't be negative.");
			}
			int d = number1 % number2;
			if (d == 0 ) {
				return true;
			}
			else {
				return false;
			}	
		}
	    public static double absValue(double number) {
			if (number>=0) {
				double answer = number;
				return answer;
			}
			else {
				double answer = number-2*number;
				return answer;
			}
		}
	    public static double max(double number1, double number2) {
			if (number1>number2) {
				return number1;
			}
			else {
				return number2;
			}
		}
	    // TODO: Fill in the space below with any helper methods that you think you will need
	    
	}
}


	