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
	
	public Fraction doMath(String operator, Fraction operand2) {
		 //calculations
		Fraction answer = new Fraction();
	
	    if (operator.equals("+")) {
	    	toCommonDenominator(this.operandInt, operand2.operandInt);
	      	answer.operandInt[1] = this.operandInt[1] +operand2.operandInt[1];
	    	answer.operandInt[2] = this.operandInt[2];
	    }
	    else if(operator.equals("-")) {
	    	toCommonDenominator(this.operandInt, operand2.operandInt);
	    	answer.operandInt[1] = this.operandInt[1] - operand2.operandInt[1];
	    	answer.operandInt[2] = this.operandInt[2];
	
	    }
	    else if(operator.equals("*")) {
	    	answer.operandInt[1] = this.operandInt[1] * operand2.operandInt[1];
	    	answer.operandInt[2] = this.operandInt[2] * operand2.operandInt[2];
	    } 
	    else {
	    	answer.operandInt[1] = this.operandInt[1] * operand2.operandInt[2];
	    	answer.operandInt[2] = this.operandInt[2] * operand2.operandInt[1];
	    	
	    }
	    
	    
	
	
		// reduce fraction
	    if (answer.operandInt[1]<0 &&answer.operandInt[2]<0) {
	    	answer.operandInt[1] = -answer.operandInt[1];
	    	answer.operandInt[2] = -answer.operandInt[2];
	    }
	    int i = 0;
	    while (i != 1) {
	    	i = greatestCommonFactor(answer.operandInt[1], answer.operandInt[2]);
	    	answer.operandInt[1] = answer.operandInt[1]/i;
	    	answer.operandInt[2] = answer.operandInt[2]/i;
	    }
	    
	    answer.operandInt[0] = answer.operandInt[1]/answer.operandInt[2];
	    answer.operandInt[1] = answer.operandInt[1]%answer.operandInt[2];
	    //change the sign of result fraction part if it's negative.
	   
	  
	    if (answer.operandInt[1] <0) {
	    	if (answer.operandInt[0]<0) {
	    		answer.operandInt[1] = -answer.operandInt[1];
	        	
	        } 
	    	else if (answer.operandInt[0]>0){
	    		answer.operandInt[0] = -answer.operandInt[0];
	    		answer.operandInt[1] = -answer.operandInt[1];
	    	}
	   
	    	}
	    
	    else if(answer.operandInt[2]<0) {
	    	if (answer.operandInt[0]<0) {
	    		answer.operandInt[2] = -answer.operandInt[2];
	        	
	        }
	    	else if (answer.operandInt[0]>0){
	    		answer.operandInt[0] = -answer.operandInt[0];
	    		answer.operandInt[2] = -answer.operandInt[2];
	    	}
	    	else if (answer.operandInt[0]==0 && answer.operandInt[1]>0) {
	    		answer.operandInt[1]=-answer.operandInt[1];
	    		answer.operandInt[2]=-answer.operandInt[2];
	    	}
	    	
	    }
	    return answer;
	    
		
	}
	public String toString() {
		 //return the answer
	    if (operandInt[1] == 0) {
	    	 return (operandInt[0] +"");
	    }
	    else if(operandInt[0]==0) {
	    	return (operandInt[1]+ "/" + operandInt[2]);
	    }
	    else {
	    	return ( operandInt[0] + "_" + operandInt[1] + "/" + operandInt[2]) ;
	    }
		
		
	}

		private static void toCommonDenominator (int [] operand1, int[] operand2) {
	    	
	    	int temp = operand1[2] ;
	    	operand1[2] = operand1[2] * operand2[2];
	    	operand1[1] = operand1[1] * operand2[2];
	    	operand2[2] = operand2[2] * temp;
	    	operand2[1] = operand2[1] * temp;
	    }
	    
	    
	    
	    
	    
	    private static int greatestCommonFactor(int a,int b) {
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
	    
	   
	   
	    
	    private static boolean isDivisibleBy(int number1,int number2) {
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
	    private static double absValue(double number) {
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



	