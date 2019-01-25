package fracCalc;

public class Fraction {
	
	//Fields
	private int[] operandInt = new int[3];
	
	
	
	
	//Constructors
	public Fraction(String input) {
		//convert the String operand into three integers that store in an array called operandInt.
		        int indexOf_ = input.indexOf('_');
		        int indexOfslash = input.indexOf('/');
		        if (indexOf_ == -1 && indexOfslash != -1) {     // 2/5
		        	operandInt[0] = 0;
		        	operandInt[1] = Integer.parseInt(input.substring(0,indexOfslash));
		        	operandInt[2] = Integer.parseInt(input.substring(indexOfslash+1));
		        }
		        else if(indexOf_ == -1 && indexOfslash == -1) {   //3
		        	operandInt[0] = Integer.parseInt(input);
		        	operandInt[1] = 0;
		        	operandInt[2] = 1;
		        }
		        else {                      //3_2/5
		        	String wholeNumberString2 = input.substring(0,indexOf_);
		        	int wholeNumberInt2 = Integer.parseInt(wholeNumberString2);
		        	String fractionString = input.substring(indexOf_+1);
		        	operandInt[0] = wholeNumberInt2;
		        	indexOfslash = fractionString.indexOf('/');
		        	operandInt[1] = Integer.parseInt(fractionString.substring(0,indexOfslash));
		            operandInt[2] = Integer.parseInt(fractionString.substring(indexOfslash+1));
		        }
		        
		        //convert the fraction to improper
		       
			    	int wholeNumber = operandInt[0];
			    	if (wholeNumber < 0) {
			    		operandInt[1] = -operandInt[1] + operandInt[2]*operandInt[0];
			    	}
			    	else {
			    		operandInt[1] = operandInt[1] + operandInt[2]*operandInt[0];
			    	}
			    	operandInt[0] = 0;
			    }
		        
		    
	
	public Fraction() {
		operandInt[0] = 0;
    	operandInt[1] = 0;
    	operandInt[2] = 1;
	}
	
	//Methods
	
	public Fraction doMath(char operator, Fraction operand) {
		 //calculations
		Fraction result = new Fraction();
	    if (operator =='+') {
	    	toCommonDenominator(firstOperand, secondOperand);
	      	result[1] = firstOperand[1] + secondOperand[1];
	    	result[2] = firstOperand[2];
	    }
	    else if(operator =='-')) {
	    	toCommonDenominator(firstOperand, secondOperand);
	    	result[1] = firstOperand[1] - secondOperand[1];
	    	result[2] = firstOperand[2];
	
	    }
	    else if(operator =='*') {
	    	result[1] = firstOperand[1] * secondOperand[1];
	    	result[2] = firstOperand[2] * secondOperand[2];
	    } 
	    else {
	    	result[1] = firstOperand[1] * secondOperand[2];
	    	result[2] = firstOperand[2] * secondOperand[1];
	    	
	    }
	    
	
	
		// reduce fraction
	    if (result[1]<0 &&result[2]<0) {
	    	result[1] = -result[1];
	    	result[2] = -result[2];
	    }
	    int i = 0;
	    while (i != 1) {
	    	i = greatestCommonFactor(result[1], result[2]);
	    	result[1] = result[1]/i;
	    	result[2] = result[2]/i;
	    }
	    
	    result[0] = result[1]/result[2];
	    result[1] = result[1]%result[2];
	    //change the sign of result fraction part if it's negative.
	   
	  
	    if (result[1] <0) {
	    	if (result[0]<0) {
	        	result[1] = -result[1];
	        	
	        } 
	    	else if (result[0]>0){
	    		result[0] = -result[0];
	    		result[1] = -result[1];
	    	}
	   
	    	}
	    
	    else if(result[2]<0) {
	    	if (result[0]<0) {
	        	result[2] = -result[2];
	        	
	        }
	    	else if (result[0]>0){
	    		result[0] = -result[0];
	    		result[2] = -result[2];
	    	}
	    	else if (result[0]==0 && result[1]>0) {
	    		result[1]=-result[1];
	    		result[2]=-result[2];
	    	}
	    }
	    
		
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


	